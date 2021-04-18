package Controllers;

import DTO.UserDTO;
import Services.UserDetailsServiceImpl;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping
public class TestController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping("/")
    public ModelAndView defaultHome() {
        return new ModelAndView("home");
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }


        @RequestMapping(value = "/login-patient")//get method
    public ModelAndView login() {
ModelAndView mv = new ModelAndView("patient-login");
//On the page patient-login, an object was described. To place the object there, in this "get" statement, we define the
        //object to add, with the string, and give it a java class
mv.addObject("user", new UserDTO());
return mv;
    }


    @RequestMapping("/patient-login-process")
    public ModelAndView userLogingProcess(){return new ModelAndView("login-process");}

    @RequestMapping("/patient/dashboard")
    public ModelAndView userDashboard() {
        return new ModelAndView("patient-dashboard");
    }

    @RequestMapping("/accessdenied")
    public ModelAndView userAccessError() {
        return new ModelAndView("error page");
    }

    @RequestMapping("/login-patient-error")
    public ModelAndView userLogingFailure(){return new ModelAndView("error");}

    @RequestMapping("/login")
    public ModelAndView testWhatsUp(){return new ModelAndView("successRegister");}

    @RequestMapping("/logout-success")
    public ModelAndView logoutPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("logout");
        return mv;
    }

    @RequestMapping(value = "/registration-patient")
    public ModelAndView registration(WebRequest request, Model model){
        UserDTO userDto = new UserDTO();
        model.addAttribute("user",userDto);
        return new ModelAndView("registration-patient");
    }

    @PostMapping("/registration-patient")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDto, HttpServletRequest request, Errors errors){
        ModelAndView mav = new ModelAndView();
        try{
            Users registered = userDetailsService.registerNewUserAccount(userDto);
            userDetailsService.updateUserRole();
        } catch (Exception uaeEx) {
            mav.addObject("error", uaeEx.getMessage());
            return new ModelAndView("registration-patient");
        }

        return new ModelAndView("patient-login");

    }

    ///////////////////////////////////////////////////////



    @RequestMapping(value = "/login-staff")//get method
    public ModelAndView stafflogin() {
        ModelAndView mv = new ModelAndView("staff-login");
    //On the page patient-login, an object was described. To place the object there, in this "get" statement, we define the
        //object to add, with the string, and give it a java class
        mv.addObject("user", new UserDTO());
        return mv;
    }

    @RequestMapping(value="/staff-login-process")
    public ModelAndView adminLoginProcessing() {
        return new ModelAndView("staff-login-process");
    }

    @RequestMapping("/staff/dashboard")
    public ModelAndView admindashboard() {
        return new ModelAndView("staff-dashboard");
    }

    @RequestMapping("/login-staff-error")
    public ModelAndView adminAccessError() {
        return new ModelAndView("error page");
    }


}
