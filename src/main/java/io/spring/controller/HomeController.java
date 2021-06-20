//package io.spring.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import io.spring.repository.ProductRepository;
//import io.spring.service.ProductService;
//
//@Controller
//public class HomeController {
//	
//	@Autowired
//	private ProductService productService;
//	
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@GetMapping("/products")
//	public String getAll(@RequestParam(value="name", required = false) String name, Model model){
//		model.addAttribute("list", productService.findAll());
//		return "productListPage";
//	}
//	
//	@GetMapping(value = {"/home", "/index", "/", ""})
//	public String homePage(Model model){
//		//String[] A = new String[] {"/home", "/index", "/", ""};
//		model.addAttribute("user", "Pham Ngoc Huy");
//		Integer count = productRepository.countQuantityByCategory(1,15);
//		model.addAttribute("countQuantity", count);
//		return "homePage";
//	}
//	
//	@GetMapping("/products/{id}")
//	public String detailPage(Model model){
//		model.addAttribute("user", "Product Page");
//		return "detailProductPage";
//	} 
//	
//	@GetMapping("/login")
//	public String login(Model model){
//		return "login";
//	} 
//	
//	
//	
//	@GetMapping("/forgot-password")
//	public String forgotpassword(Model model){
//		return "forgot-password";
//	} 
//	
//	@GetMapping("/404")
//	public String page404(Model model){
//		return "404";
//	} 
//
//}