package com.convertion2.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.convertion2.Config.UserExcelExporter;
import com.convertion2.Repository.StudentRepository;
import com.convertion2.model.Student;



@Controller
@RequestMapping("/excel")
public class HomeController 
{
	@Autowired
	private StudentRepository studentRepo;

	@GetMapping()
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=Student_info.xlsx";

		response.setHeader(headerKey, headervalue);
		List<Student> listStudent = studentRepo.findAll();
		UserExcelExporter exp = new UserExcelExporter(listStudent);
		exp.export(response);

	}
}

