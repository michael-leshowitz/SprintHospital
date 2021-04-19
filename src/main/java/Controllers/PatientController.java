package Controllers;

import DTO.UserDTO;
import Repositories.UsersRepository;
import Services.UserDetailsServiceImpl;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;

@Controller
@RequestMapping(path = "/patient")
@ComponentScan("Config")
@ComponentScan("Services")
public class PatientController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping("/dashboard")
    @ResponseBody
    public ModelAndView userDashboard(Principal principal) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mv = new ModelAndView("patient-dashboard");
        Users loggedInUser =  usersRepository.findUser(principal.getName()).get(0);
        mv.addObject("user", loggedInUser);
        return mv;
    }

    @RequestMapping(value="/patient/app-creation")
    public ModelAndView adminLoginProcessing(Authentication authentication) {
        ModelAndView mv = new ModelAndView("patient-create-appointment");
//        Users loggedInUser = (Users) authentication.getPrincipal();
//        mv.addObject("user", loggedInUser);
        return mv;
    }
}
