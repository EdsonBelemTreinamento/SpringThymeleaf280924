package br.com.arq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.arq.model.Users;
import br.com.arq.repository.UsersRepository;

@Controller
public class UsersController {

	@Autowired
	private UsersRepository repository;	
	
	@GetMapping("/cadastro")
	public String cadastroform() {
		ModelAndView model = new ModelAndView();
		model.addObject("message","Seja bem vindo ao Cadastro");
		return "cadastro";
	}
	
	
	@PostMapping("/cadastro")
	public String cadastrar(@RequestParam String email, @RequestParam String name,
			@RequestParam String password,Model model) {
		try {
		 Users users= new Users();
		   users.setEmail(email);
		   users.setName(name);
		   users.setPassword(users.criptografarSenha(password));
		   Users resposta= repository.save(users);
		   model.addAttribute("message", resposta.toString());
		   return "cadastro";
		   
		}catch(Exception ex) {
		  model.addAttribute("message","Error" + ex.getMessage());
		  return "cadastro";	
		}
		
		
	}
}

