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

//@Controller
//@RequestMapping("/admin/admin_login")
//public class AdminController {
//    @RequestMapping("/admin/dashboard")
//    public ModelAndView admin() {
//        return new ModelAndView("Staff Landing Page");
//    }
//}
