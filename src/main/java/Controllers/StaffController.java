package Controllers;

import Repositories.DatesRepository;
import Repositories.UsersRepository;
import Services.AppointmentDetailsServiceImpl;
import Services.UserDetailsServiceImpl;
import models.Appointments;
import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/staff")
public class StaffController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    DatesRepository datesRepository;

    @Autowired
    AppointmentDetailsServiceImpl appointmentDetailsService;


    @RequestMapping("/dashboard")
    public ModelAndView adminDashboard() {
        return new ModelAndView("staff-dashboard");
    }

    @RequestMapping("/app-schedule")
    public ModelAndView adminAppointmentSchedule(Model model, Principal principal){
        //Todo change from call to userRespository to call to AdminDetailsServiceImpl
      Users loggedInAdmin = usersRepository.findAdmin(principal.getName()).get(0);
    List<Appointments> appointments = appointmentDetailsService.findAdminAppointmentSchedule(loggedInAdmin.getUserId());
    model.addAttribute("appointments", appointments);
    return new ModelAndView("staff-appointment-schedule");
    }

    @RequestMapping("/unclosed-app")
    public ModelAndView adminUnclosedAppointment(Model model, Principal principal){
        Users loggedInAdmin = usersRepository.findAdmin(principal.getName()).get(0);
        List<Appointments> unclosedAppointments = appointmentDetailsService.findPreviousAppointments(loggedInAdmin.getUserId());
        model.addAttribute("appointments", unclosedAppointments);
        return new ModelAndView("staff-previous-appointments");
    }

    @RequestMapping(value="/cancelAppointment/{appIdString}", method = RequestMethod.GET)
    public ModelAndView cancelAppointmentById(@PathVariable String appIdString, Model model, Principal principal){
        Integer appId = Integer.parseInt(appIdString);
        appointmentDetailsService.deleteByAppId(appId);
        Users loggedInUser =  usersRepository.findAdmin(principal.getName()).get(0);
        List<Appointments> appointments = appointmentDetailsService.findAdminAppointmentSchedule(loggedInUser.getUserId());
        model.addAttribute("appointments", appointments);
        return new ModelAndView("staff-appointment-schedule");
    }

}
