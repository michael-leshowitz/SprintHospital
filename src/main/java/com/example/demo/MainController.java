//package com.example.demo;
//
//import Repositories.PatientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
////@RequestMapping(path = "/")
//@ComponentScan("Configuration")
//@RequestMapping
//public class MainController {
//
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @GetMapping(path="/all")
//    public @ResponseBody
//    Iterable<Patient> getAllPatient() {
//        // This returns a JSON or XML with the users
//        return patientRepository.findAll();
//    }
//
//    @RequestMapping("")
//    public ModelAndView home(Patient patient){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        return mv;
//    }
//
//    @RequestMapping("/findPatient")
//    public @ResponseBody Iterable<Patient> findPatient(@RequestParam String username){
//        System.out.println(patientRepository.findAllByUserName(username));
//        return patientRepository.findAllByUserName(username);
//    }
//
//    @RequestMapping("/addPatient")
//    public ModelAndView addPatient(Patient patient){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        return mv;
//    }
//
//    @RequestMapping("/logout-success")
//    public ModelAndView logoutPage(){
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("logout");
//        return mv;
//    }
//
//}
