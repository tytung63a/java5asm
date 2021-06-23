package io.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.spring.entities.Product;
import io.spring.model.ProductModel;
import io.spring.service.CategoryService;
import io.spring.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ServletContext application;

	@GetMapping("/products")
	public String getAll(Model model, @RequestParam(name = "field", defaultValue = "") String field,
			@RequestParam(name = "page") Optional<Integer> page) {
		model.addAttribute("list", productService.findAll(page.orElse(0), 4, field , ""));
		return "productsAdminList";
	}

	@ModelAttribute("listAvailable")
	public Map<Integer, String> getListAvailable() {
		Map<Integer, String> listAvailable = new HashMap<Integer, String>();
		listAvailable.put(1, "Yes");
		listAvailable.put(0, "No");
		return listAvailable;
	}

	@ModelAttribute("listCategory")
	public Map<Integer, String> getListCategory() {
		Map<Integer, String> listCategory = new HashMap<Integer, String>();
		for (int i = 0; i < categoryService.findAll().size(); i++) {
			listCategory.put(categoryService.findAll().get(i).getId(), categoryService.findAll().get(i).getName());
		}
		return listCategory;
	}

	@GetMapping("/products/create")
	public String viewCreate(Model model) {
		model.addAttribute("productForm", new ProductModel());
		return "productsAdminCreate";
	}

	@PostMapping("/products/create")
	public String saveProduct(@Validated @ModelAttribute("productForm") ProductModel productModel,
			BindingResult bindingResult, @Parameter(name = "image") MultipartFile multipartFile, Model model)
			throws IllegalAccessException, InvocationTargetException, ParseException {
		String path = application.getRealPath("/");
		try {
			String filePath = path + "/images/" + productModel.getImage().getOriginalFilename();
			productModel.getImage().transferTo(Paths.get(filePath));
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (!bindingResult.hasErrors()) {
			productService.save(productModel);
			model.addAttribute("message", "Save product is successfuly");
			return "redirect:/admin/products";
		} else {
			// 3. else = => Show error message
			return "productsAdminCreate";
		}
	}

	@GetMapping("/products/edit/{id}")
	public String editView(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("productForm", productService.findById(id));
		model.addAttribute("idValue", productService.findById(id).get().getId());
		try {
			model.addAttribute("idCate", productService.findById(id).get().getCategory().getId());
		} catch (Exception e) {
			model.addAttribute("idCate", 25);
		}
		return "productsAdminEdit";
	}

	@PostMapping("/products/edit/{id}")
	public String editAccount(@Validated @ModelAttribute("productForm") ProductModel productModel,
			@Parameter(name = "category") Integer id, BindingResult bindingResult,
			@Parameter(name = "photo") MultipartFile photo, RedirectAttributes rAttributes, Model model)
			throws IllegalAccessException, InvocationTargetException, ParseException {
		String path = application.getRealPath("/");
		try {
			String filePath = path + "/images/" + productModel.getImage().getOriginalFilename();
			productModel.getImage().transferTo(Paths.get(filePath));
		} catch (Exception e) {
			System.err.println("có lỗi tại trycath");
		}

		if (!bindingResult.hasErrors()) {
			rAttributes.addFlashAttribute("message",
					"Edit Product is successfuly with username : " + productModel.getId());
			Product product = new Product();
			product.setId(id);
			BeanUtils.copyProperties(product, productModel);
			String localDate = LocalDate.now().toString();
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(localDate);
			product.setCreateDate(date);
			product.setImage(productModel.getImage().getOriginalFilename());
			productService.save(product);
			return "redirect:/admin/products";
		} else {
			return "productsAdminEdit";
		}
	}

	@GetMapping("/products/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes rAttributes) {
		productService.deleteById(id);
		rAttributes.addFlashAttribute("message", "Delete product is successfuly with id: " + id);
		return "redirect:/admin/products";
	}
}