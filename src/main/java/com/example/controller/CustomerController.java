package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.CustomerDetails;
import com.example.service.CustomerServiceInterface;

@Controller
@RequestMapping({ "/employee", "/" })
public class CustomerController {

	@Autowired
	private CustomerServiceInterface service;

	@GetMapping({ "/register", "/" })
	public String showRegsiter() {

		return "Register";
	}

	@PostMapping("/save")
	public String saveForm(@ModelAttribute @Valid CustomerDetails customerDetails, Model model) {

		String id = service.save(customerDetails);

		String message = "Employee '" + id + "' Created";

		model.addAttribute("message", message);

		return "Register";
	}

	@GetMapping("/all")
	public String showAll(@RequestParam(required = false) String message, Model model) {

		List<CustomerDetails> list = service.getAllData();

		model.addAttribute("list", list);
		model.addAttribute("message", message);

		return "Data";
	}

	@GetMapping("/delete")
	public String doDelete(@RequestParam Integer id, RedirectAttributes attributes) {
		try {
			service.delete(id);
			attributes.addAttribute("message", "Employee '" + id + "' Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
		}
		return "redirect:all";
	}

	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		String page = null;
		try {
			Optional<CustomerDetails> employee = service.getOneData(id);
			model.addAttribute("employee", employee);
			page = "Edit";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	@PostMapping("/update")
	public String updateForm(@ModelAttribute CustomerDetails customerDetails, RedirectAttributes attributes) {
		service.update(customerDetails);
		attributes.addAttribute("message", "Employee '" + customerDetails.getId() + "' Updated");
		return "redirect:all";
	}

}
