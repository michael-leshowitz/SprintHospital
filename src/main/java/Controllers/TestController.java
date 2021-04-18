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

//    @RequestMapping(value = "/patient/login")//get method
//    public ModelAndView login() {
//ModelAndView mv = new ModelAndView("patient-login");
////On the page patient-login, an object was described. To place the object there, in this "get" statement, we define the
//        //object to add, with the string, and give it a java class
//mv.addObject("user", new UserDTO());
//return mv;
//    }

        @RequestMapping(value = "/login-patient")//get method
    public ModelAndView login() {
ModelAndView mv = new ModelAndView("patient-login");
//On the page patient-login, an object was described. To place the object there, in this "get" statement, we define the
        //object to add, with the string, and give it a java class
mv.addObject("user", new UserDTO());
return mv;
    }


//    @RequestMapping("/patient/login-process")
//    public ModelAndView userLogingProcess(){return new ModelAndView("login-process");}

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

//    @RequestMapping("/patient/login/error")
//    public ModelAndView userLogingFailure(){return new ModelAndView("error");}

    @RequestMapping("/login-patient-error")
    public ModelAndView userLogingFailure(){return new ModelAndView("error");}

    @PostMapping("/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDto, HttpServletRequest request, Errors errors){
        ModelAndView mav = new ModelAndView();
        try{
            Users registered = userDetailsService.registerNewUserAccount(userDto);
        } catch (Exception uaeEx) {
            mav.addObject("error", uaeEx.getMessage());
            return new ModelAndView("patient-registration");
        }

        return new ModelAndView("patient-login");

    }

    @RequestMapping("/login")
    public ModelAndView testWhatsUp(){return new ModelAndView("successRegister");}

    @RequestMapping("/logout-success")
    public ModelAndView logoutPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("logout");
        return mv;
    }

    ///////////////////////////////////////////////////////

    @RequestMapping("/admin/")
    public ModelAndView admin() {
        return new ModelAndView("staff-login");
    }


    @RequestMapping(value = "/registration")
    public ModelAndView registration(WebRequest request, Model model){
        UserDTO userDto = new UserDTO();
        model.addAttribute("user",userDto);
        return new ModelAndView("patient-registration");
    }

    @RequestMapping("/admin/login")
    public ModelAndView adminlogin() {
        return new ModelAndView("staff-login");
    }

    @RequestMapping(value="/admin/admin_login")
    public ModelAndView adminLoginProcessing() {
        return new ModelAndView("staff-login-process");
    }

    @RequestMapping("/admin/dashboard")
    public ModelAndView admindashboard() {
        return new ModelAndView("staff-dashboard");
    }

    @RequestMapping("/admin/accessdenied")
    public ModelAndView adminAccessError() {
        return new ModelAndView("error page");
    }


}
