package com.vinit.Foodplazabootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vinit.Foodplazabootweb.dto.RoleDTO;
import com.vinit.Foodplazabootweb.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("all")
	public String getAllroles(Model model) {

		model.addAttribute("roles", roleService.findAllRoles());
		return "role/allRoles";
	}

	@GetMapping("add")
	public String addRole(Model model) {
		model.addAttribute("role", new RoleDTO());
		return "role/add";
	}

	@PostMapping("add")
	public String saveRole(@ModelAttribute RoleDTO role) {
		roleService.saveRole(role);
		return "redirect:all";
	}

	@GetMapping("{id}")
	@ResponseBody
	public RoleDTO getRoleByRoleId(@PathVariable int id) {
		return roleService.findByRoleId(id);
	}

	@DeleteMapping("{id}")
	@ResponseBody
	public boolean deleteRoleByRoleId(@PathVariable int id) {
		return roleService.deleteByRoleId(id);
	}

}
