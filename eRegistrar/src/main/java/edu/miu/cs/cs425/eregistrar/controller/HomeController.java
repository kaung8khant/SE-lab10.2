package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value= {"/", "/home"})
    public ModelAndView displayHomePage(){
        List<Student> students = studentService.allStudent();
        var modelAndView = new ModelAndView();

        modelAndView.addObject("students", students);
        modelAndView.setViewName("public/index");
        return modelAndView;
    }

    @PostMapping(value={"/add","/home/add"})
    public String add(@Valid Student student, BindingResult result){
        if (result.hasErrors()) {
            System.out.println(result);
            return "public/index";
        }
        studentService.save(student);
        return "redirect:/";
    }
    @GetMapping(value="/delete/{stuid}")
    public String delete(@PathVariable Long stuid){
        studentService.delete(stuid);
        return "redirect:/";
    }

    @GetMapping(value="/edit/{stuid}")
    public String edit(@PathVariable Long stuid, Model model){
        Student student = studentService.getStudent(stuid);
        if(student!=null) {
            model.addAttribute("stu", student);
            return "public/update";
        }
        return "redirect:/";
    }
    @PostMapping(value={"/update","/home/update"})
    public String update(@Valid Student student, BindingResult result,Model model){
        if (result.hasErrors()) {
            System.out.println(result);
            return "public/index";
        }
        studentService.save(student);
        return "redirect:/";
    }
}
