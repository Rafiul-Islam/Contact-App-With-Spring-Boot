package com.rafiulislam;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class homeController extends HttpServlet {

	@Autowired
	StudentsRepo stdRepo;

	@RequestMapping("/")
	public ModelAndView welcomePage() {

		ModelAndView modelAndView = new ModelAndView("loginPage.jsp"); // return
		return modelAndView;
	}

	@RequestMapping("/login")
	public void afterLogin(@RequestParam("name") String name, @RequestParam("password") String passowrd,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		session.setAttribute("name", name);

		if (name.equals("admin") && passowrd.equals("admin")) {
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("loginPage.jsp");
		}
	}

	@RequestMapping("/addAlien")
	public ModelAndView saveStudent(Students students) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");

		stdRepo.save(students);

		return modelAndView;

	}

	@RequestMapping("/logout")
	public ModelAndView logOutMethod(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("loginPage.jsp");

		HttpSession session = request.getSession();
		session.removeAttribute("name");
		session.invalidate();

		return modelAndView;

	}

	@RequestMapping("/getAlien")
	public ModelAndView getStudent(int id) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.jsp");

		// Custom Sorting
//		System.out.println(stdRepo.findByTech("java"));
//		System.out.println(stdRepo.findByIdGreaterThan(102));
//		System.out.println(stdRepo.findByTechSorted("java"));
//		System.out.println(stdRepo.findByNameSorted());

		Students students = stdRepo.findById(id).orElse(new Students());
		modelAndView.addObject(students);

		return modelAndView;

	}

	@RequestMapping("/allAlien")
	public ModelAndView getAllStudent(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home.jsp");

		stdRepo.findByName();

		List<Students> students = stdRepo.findByName();
		request.setAttribute("students", students);

		return modelAndView;

	}

	@RequestMapping("/updateAlien")
	public ModelAndView updateStudent(Students students) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.jsp");

		stdRepo.save(students);
		modelAndView.addObject(students);

		return modelAndView;

	}

	@RequestMapping("/deleteAlien")
	public void deleteStudent(int id, HttpServletRequest request, HttpSession session, HttpServletResponse response)
			throws IOException {

		if (stdRepo.existsById(id)) {
			stdRepo.deleteById(id);
			response.sendRedirect("login.jsp");
		} else {
			session = request.getSession();
			session.setAttribute("log", "This Id Doesn't Exist !");
			response.sendRedirect("Log.jsp");

		}

	}

	@GetMapping("students")
	public List<Students> getAllStudents() {
		return stdRepo.findAll();
	}

	@GetMapping(path = "students/{id}"/* , produces = {"application/xml", "application/json"} */)
	public Optional<Students> getPerticulerStudentByID(@PathVariable("id") int id) {
		return stdRepo.findById(id);
	}

	@DeleteMapping("delete/{id}")
	public String deletePerticulerStudentByID(@PathVariable("id") int id) {

		Students students = stdRepo.getOne(id);

		stdRepo.delete(students);

		return "Deleted";

	}

	@PostMapping(path = "students"/* , consumes = "application/json" */)
	public Students SaveData(@RequestBody Students students) {

		stdRepo.save(students);
		return students;

	}

	@PutMapping(path = "update"/* , consumes = "application/json" */)
	public Students updateData(@RequestBody Students students) {

		stdRepo.save(students);
		return students;

	}

}
