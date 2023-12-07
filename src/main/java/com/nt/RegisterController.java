package com.nt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.dao.EmployeeDao;
import com.nt.entity.Employee;

@Controller
public class RegisterController {
	@Autowired
	private EmployeeDao dao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute Employee e, Model model) {

		boolean isRegister = dao.register(e);
		if (isRegister) {
			model.addAttribute("msg", "Registered successfully");
			return "result";
		} else {
			model.addAttribute("msg", "Unable to register");
			return "error";

		}
	}

	@RequestMapping("/registerForm")
	public String registerForm() {
		return "register";
	}



	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, @RequestParam("sal") int sal, Model model) {
		boolean isUpdate = dao.update(id, sal);
		if (isUpdate)
			model.addAttribute("msg", "Updated successfully");
		else
			model.addAttribute("msg", "Unable to update salary");
		return "result";
	}

	@RequestMapping("/updateForm")
	public String updateForm() {
		return "update";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam int id, Model model) {
		boolean isDelete = dao.delete(id);
		if (isDelete)
			model.addAttribute("msg", "Deleted successfully");
		else
			model.addAttribute("msg", "Unable to delete employee");
		return "result";
	}

	@RequestMapping("/deleteForm")
	public String deleteForm() {
		return "delete";
	}
	@RequestMapping("/byId")
	public String selectRecord(@RequestParam int id, Model model) {
		Employee e = dao.findById(id);
		if (e != null) {
			model.addAttribute("emp", e);
			return "display";
		} else {
			model.addAttribute("msg", "No Record found !!!");
			return "result";
		}
	}

	@RequestMapping("/selectForm")
	public String selectForm() {
		return "select";
	}

	@RequestMapping("/all")
	public String selectAll(Model model) {
		List<Employee> list = dao.selectAll();
		model.addAttribute("emplist", list);
		return "displayAll";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
