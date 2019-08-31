package com.todolist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todolist.entities.Tache;
import com.todolist.metier.interf.TacheMetierInterf;

@Controller
@RequestMapping(value = "/Tache")
public class TacheController {

	@Autowired
	private TacheMetierInterf tacheMetierInterf;

	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest httpServletRequest) {
		model.addAttribute("tache", new Tache());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		return "tachepage";
	}

	@RequestMapping(value = "/saveTache")
	public String saveTache(@Valid Tache tache, Model model, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("tachelist", tacheMetierInterf.listTache());
			return "tachepage";
		}
		if (tache.getTacheId() != null)
			tacheMetierInterf.udpateTache(tache);
		else
			tacheMetierInterf.addTache(tache);
		model.addAttribute("tache", new Tache());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		return "tachepage";
	}

	@RequestMapping(value = "/editTache")
	public String editTache(Integer tacheId, Model model, HttpServletRequest httpServletRequest) {
		Tache tache = tacheMetierInterf.getTache(tacheId);
		model.addAttribute("tache", tache);
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		return "tachepage";
	}

	@RequestMapping(value = "/deleteTache")
	private String deleteTache(Integer tacheId, Model model, HttpServletRequest httpServletRequest) {
		tacheMetierInterf.deleteTache(tacheId);
		model.addAttribute("tache", new Tache());
		model.addAttribute("tachelist", tacheMetierInterf.listTache());
		return "tachepage";
	}
}
