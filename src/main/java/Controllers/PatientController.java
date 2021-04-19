package Controllers;

import DTO.AppointmentDTO;
import Repositories.DatesRepository;
import Repositories.UsersRepository;
import Services.AppointmentDetailsServiceImpl;
import Services.UserDetailsServiceImpl;
import models.Appointments;
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

    //Todo: Replace the autowired repositories with autowired services. Have the services interface with respositories for queries
    @Autowired
    private UsersRepository usersRepository;

    @Autowired DatesRepository datesRepository;

    @Autowired
    AppointmentDetailsServiceImpl appointmentDetailsService;

    @RequestMapping("/dashboard")
    @ResponseBody
    public ModelAndView userDashboard(Principal principal) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mv = new ModelAndView("patient-dashboard");
        Users loggedInUser =  usersRepository.findUser(principal.getName()).get(0);
        mv.addObject("user", loggedInUser);
        return mv;
    }

    @RequestMapping(value="/app-creation")
    public ModelAndView createAppPageInit(Model model){
        AppointmentDTO appDTO = new AppointmentDTO();
        model.addAttribute("app",appDTO);
        List<Users> staff = usersRepository.findAllAdmin();
        List<Dates> dates = datesRepository.findNextTwoWeeks();
        model.addAttribute("staff", staff);
        model.addAttribute("dates", dates);
        return new ModelAndView("patient-create-appointment");
    }

    @PostMapping("/app-creation")
    public ModelAndView createApp(@ModelAttribute("app") AppointmentDTO appointmentDTO, Principal principal){
        try{
            Users loggedInUser = usersRepository.findUser(principal.getName()).get(0);
            appointmentDetailsService.createAppointment(appointmentDTO,
                    usersRepository.findUser(principal.getName()).get(0).getUserId());
        } catch (Exception e){
            return new ModelAndView("patient-create-appointment");
        }

        return new ModelAndView("patient-app-created-success");
    }

    @RequestMapping("/app-schedule")
    public ModelAndView viewAppSchedule(Model model, Principal principal){
        Users loggedInUser =  usersRepository.findUser(principal.getName()).get(0);
        List<Appointments> appointments = appointmentDetailsService.findAppointmentSchedule(loggedInUser.getUserId());
        model.addAttribute("appointments", appointments);
        return new ModelAndView("patient-appointment-schedule");
    }

    @RequestMapping(value="/cancelAppointment/{appIdString}", method = RequestMethod.GET)
    public ModelAndView cancelAppointmentById(@PathVariable String appIdString, Model model, Principal principal){
        Integer appId = Integer.parseInt(appIdString);
        appointmentDetailsService.deleteByAppId(appId);
        Users loggedInUser =  usersRepository.findUser(principal.getName()).get(0);
        List<Appointments> appointments = appointmentDetailsService.findAppointmentSchedule(loggedInUser.getUserId());
        model.addAttribute("appointments", appointments);
        return new ModelAndView("patient-appointment-schedule");
    }
}
