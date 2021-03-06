package com.win.spring;

import java.util.Locale;

import okjsp.User;
import okjsp.UserDAO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	@RequestMapping(value="/register.do", method =RequestMethod.GET)
	public String register(Locale locale, Model model)
	{
		return "register";
		
	}
	
	@RequestMapping(value="/register.do", method =RequestMethod.POST)
	public String registerFinshed(Locale locale, @ModelAttribute("user") User user, Model model)
	{
		if (!user.getPwd().equals(user.getConfirmpwd()))
		{
			model.addAttribute("msg", "password not matched!!");
			model.addAttribute("user", user);
			return "register";
		}
				
		UserDAO.save(user);

	    return "redirect:registerFinshed.do";
	}
	
	@RequestMapping(value="/registerFinshed.do")
	public String registerFinshed(Model model){
		return "registerFinshed";
	}
}
