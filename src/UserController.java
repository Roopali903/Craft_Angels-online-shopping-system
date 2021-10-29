package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.Entity.User;
//import com.Service.UserServices;

@Controller
public class UserController {

	    @Autowired
	    private UserServices service;
	     
	    @RequestMapping("/u")
	    public String viewHomePage(Model model) {
	        List<User> listUsers = service.listAll();
	        model.addAttribute("listUsers", listUsers);
	         
	        return "UserIndex";
	    }
	     
	    @RequestMapping("/new1")
	     public String newUser(Model model)
	     {
	    	 User user = new User();
	    	 model.addAttribute("user",user);
	         
	         return "newUser";
	     }
	    
	    
	    @RequestMapping(value="/saveUser" ,method=RequestMethod.POST) 
	    public String saveUser(@ModelAttribute("user") User user) 
	     {
	    	 service.save(user);
	    	 
	    	return "saveUser";
	     }
	     
	    @RequestMapping("/edit1/{Id}")
	    public ModelAndView showEditProductPage(@PathVariable(name = "Id") Long Id) {
	        ModelAndView mav = new ModelAndView("editUser");
	        User user = service.get(Id);
	        mav.addObject("user", user);
	         
	        return mav;
	    }
	    
	    @RequestMapping("/delete1/{Id}")
	    public String deleteProduct(@PathVariable(name = "Id") Long Id) {
	        service.delete(Id);
	        return "redirect:/";       
	    }
}
