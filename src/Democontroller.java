package com.example.demo;

import com.example.demo.Product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Democontroller {
 
    @Autowired
    private ProductService service;
     
    @RequestMapping("/p")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
         
        return "index";
    }
     
    @RequestMapping("/new")
     public String newproduct(Model model)
     {
    	 Product product = new Product();
    	 model.addAttribute("product",product);
         
         return "newproduct";
     }
    
    
    @RequestMapping(value="/save" ,method=RequestMethod.POST) 
    public String saveProduct(@ModelAttribute("product") Product product) 
     {
    	 service.save(product);
    	 
    	return "save";
     }
     
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("Edit");
        Product product = service.get(id);
        mav.addObject("product", product);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";       
    }
         
         
         
         
         
         
         
         
         
         
         
         
     
    
}