package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class TestController {

    @RequestMapping("/")
    public ModelAndView defaultHome() {
        return new ModelAndView("home");
    }

    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }


    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("patient-login");
    }

    @RequestMapping("/dashboard")
    public ModelAndView userDashboard() {
        return new ModelAndView("registration");
    }

    @RequestMapping("/accessdenied")
    public ModelAndView userAccessError() {
        return new ModelAndView("error page");
    }

    @RequestMapping("/admin/")
    public ModelAndView admin() {
        return new ModelAndView("staff-login");
    }

    @RequestMapping("/admin/login")
    public ModelAndView adminlogin() {
        return new ModelAndView("staff-login");
    }

    @RequestMapping("/admin/dashboard")
    public ModelAndView admindashboard() {
        return new ModelAndView("Staff Landing Page");
    }

    @RequestMapping("/admin/accessdenied")
    public ModelAndView adminAccessError() {
        return new ModelAndView("error page");
    }
}
