package Controllers;

import DTO.AppointmentDTO;
import Repositories.DatesRepository;
import Repositories.UsersRepository;
import Services.UserDetailsServiceImpl;
import models.Dates;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/patient")
@ComponentScan("Config")
@ComponentScan("Services")
public class PatientController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired DatesRepository datesRepository;

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
    public ModelAndView adminLoginProcessing(Principal principal, Model model){
        AppointmentDTO appDTO = new AppointmentDTO();
        model.addAttribute("app",appDTO);
        List<Users> staff = usersRepository.findAllAdmin();
        List<Dates> dates = datesRepository.findNextTwoWeeks();
        model.addAttribute("staff", staff);
        model.addAttribute("dates", dates);
        return new ModelAndView("patient-create-appointment");
    }

//    @PostMapping("/app-creation")
//    public ModelAndView registerUserAccount(
//            @ModelAttribute("user") @Valid UserDTO userDto, HttpServletRequest request, Errors errors){
//        ModelAndView mav = new ModelAndView();
//        try{
//            Users registered = userDetailsService.registerNewUserAccount(userDto);
//            userDetailsService.updateUserRole();
//        } catch (Exception uaeEx) {
//            mav.addObject("error", uaeEx.getMessage());
//            return new ModelAndView("registration-patient");
//        }
//
//        return new ModelAndView("patient-login");
//    }
}
