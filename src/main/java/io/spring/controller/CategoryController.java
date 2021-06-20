package io.spring.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.spring.entities.Category;
import io.spring.model.CategoryModel;
import io.spring.service.CategoryService;

@RequestMapping("/admin")
@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public String getAll(Model model, @RequestParam(name = "field", defaultValue = "") String field,
			@RequestParam(name = "page") Optional<Integer> page) {
		if (field.equals("")) {
			PageRequest pageable = PageRequest.of(page.orElse(0), 2, Sort.by(Direction.ASC, "id"));
			model.addAttribute("list", categoryService.findAll(pageable));
		} else {
			PageRequest pageable = PageRequest.of(page.orElse(0), 2, Sort.by(Direction.DESC, field));
			model.addAttribute("list", categoryService.findAll(pageable));

		}
		return "categoriesAdminList";
	}

	@GetMapping("/categories/create")
	public String viewCreate(Model model) {
		model.addAttribute("categoryForm", new CategoryModel());
		return "categoriesAdminCreate";
	}

	@PostMapping("/categories/create")
	public String saveProduct(@Validated @ModelAttribute("categoryForm") CategoryModel categoryModel,
			BindingResult bindingResult, RedirectAttributes rAttributes, Model model)
			throws IllegalAccessException, InvocationTargetException {
		Category category = new Category();
		if (!bindingResult.hasErrors()) {
			BeanUtils.copyProperties(category, categoryModel);
			rAttributes.addFlashAttribute("message", "Save Category is successfuly");
			categoryService.save(category);
			return "redirect:/admin/categories";
		} else {
			return "categoriesAdminCreate";
		}
	}

	@GetMapping("/categories/edit/{id}")
	public String editView(@PathVariable("id") Integer id, Model model) {
		Optional<Category> category = categoryService.findById(id);
		model.addAttribute("categoryForm", category.get());
		return "categoriesAdminEdit";
	}

	@PostMapping("/categories/edit/{id}")
	public String editCategory(@PathVariable("id") Integer id,
			@Validated @ModelAttribute("categoryForm") CategoryModel categoryModel, BindingResult bindingResult,
			RedirectAttributes rAttributes, Model model) throws IllegalAccessException, InvocationTargetException {
		if (!bindingResult.hasErrors()) {
			rAttributes.addFlashAttribute("message", "Edit Category is successfuly with id : " + id);
			Category category = new Category();
			BeanUtils.copyProperties(category, categoryModel);
			categoryService.save(category);
			return "redirect:/admin/categories";
		} else {
			return "categoriesAdminEdit";
		}
	}

	@GetMapping("/categories/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes rAttributes) {
		categoryService.deleteById(id);
		rAttributes.addFlashAttribute("message", "Delete Category is successfuly with id: " + id);
		return "redirect:/admin/categories";
	}

}
