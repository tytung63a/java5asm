package io.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.ArrayList;
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

import antlr.collections.List;
import io.spring.entities.Product;
import io.spring.model.ProductModel;
import io.spring.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ServletContext application;
	
	@GetMapping("/products")
	public String getAll(@RequestParam(value="name", required = false) String name, Model model){
		model.addAttribute("list", productService.findAll());
		return "productsAdminList";
	}
	
	 @ModelAttribute("listAvailable")
	   public Map<Integer, String> getListAvailable() {
		 Map<Integer, String> listAvailable = new HashMap<Integer, String>();
			listAvailable.put(1, "Yes");
			listAvailable.put(0, "No");
	      return listAvailable;
	   }
	
	@GetMapping("/products/create")
	public String viewCreate(Model model){
		model.addAttribute("productForm", new ProductModel());
		return "productsAdminCreate";
	} 
	
	@PostMapping("/products/create")
	public String saveProduct(@Validated @ModelAttribute("productForm") ProductModel productModel,
			@Parameter(name = "image") MultipartFile multipartFile,
			BindingResult bindingResult, Model model) throws IllegalAccessException, InvocationTargetException{
		boolean check = bindingResult.hasErrors();
		String path = application.getRealPath("/");
		try {
			String filePath = path + "/images/" + productModel.getImage().getOriginalFilename();
			productModel.getImage().transferTo(Paths.get(filePath));
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!check) {
			Product product = new Product();
			BeanUtils.copyProperties(product, productModel);
			product.setImage(productModel.getImage().getOriginalFilename());
			productService.save(product);
			model.addAttribute("message", "Save product is successfuly");
			//3. else   = => Show error message
			return "redirect:/admin/products";
		} else {
			//3. else   = => Show error message
			return "productsAdminCreate";
		}
	} 
	
	@GetMapping("/products/edit/{id}")
	public String editView(@PathVariable("id") Integer id, Model model) {
		Optional<Product> product = productService.findById(id);
		model.addAttribute("productForm", product.get());
		return "productsAdminEdit";
	} 
	
	@PostMapping("/products/edit")
	public String updateProduct(@Validated @ModelAttribute("productForm") Product product, BindingResult bindingResult, Model model){
		//1. Validate Product
		boolean check = bindingResult.hasErrors();
		
		//2. if (validate ok) => save ok => Show message success
		if(!check) {
			//TODO save product
			productService.save(product);
			model.addAttribute("message", "Save product is successfuly");
			//3. else   = => Show error message
			return "redirect:/admin/products";
		} else {
			//3. else   = => Show error message
			return "admin/products/edit";
		}
	} 
	
	@GetMapping("/products/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model , RedirectAttributes rAttributes){
		productService.deleteById(id);
		rAttributes.addFlashAttribute("message", "Delete product is successfuly with id: " + id);
		return "redirect:/admin/products";
	} 
}