package io.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import io.spring.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = { "/homepage", "/index", "/", "" })
	public String homePage(Model model, @RequestParam(name = "field", defaultValue = "") String field,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "page") Optional<Integer> page) {
		if (field.equals("")) {
			model.addAttribute("list", productService.findAll(page.orElse(0), 8, "id", ""));
		} else {
			model.addAttribute("list", productService.findAll(page.orElse(0), 8, field, ""));
		}
		return "homePageUser";
	}

	@GetMapping("/products/{id}")
	public String detailPage(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("list", productService.findById(id).get());
		return "detailProduct";
	}

	@GetMapping("/homepage/find")
	public String searchName(Model model, @RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "page") Optional<Integer> page) {
		model.addAttribute("list", productService.findAll(page.orElse(0), 8, "id", name));
		return "homePageUser";
	}

	@GetMapping("/404")
	public String page404(Model model) {
		return "404";
	}

}