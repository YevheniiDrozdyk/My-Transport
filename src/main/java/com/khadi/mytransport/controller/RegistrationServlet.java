package com.khadi.mytransport.controller;

import com.khadi.mytransport.dto.UserDto;
import com.khadi.mytransport.model.User;
import com.khadi.mytransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationServlet {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        model.addAttribute("currentPage", "registration");
        return "page-template";
    }

    @PostMapping("/new")
    public ModelAndView register(@ModelAttribute @Valid UserDto userDto, BindingResult result,
                                 WebRequest request, Errors errors) {
        User user = new User();
        if (!result.hasErrors()) {
            user = userService.register(userDto);
        }
        if (user == null) {
            result.rejectValue("phoneNumber", "message.regError");
        }
        ModelAndView modelAndView = new ModelAndView("page-template", "userDto", userDto);
        if (result.hasErrors()) {
            modelAndView.addObject("currentPage", "registration");
        } else {
            modelAndView.addObject("currentPage", "index");
        }

        return modelAndView;
    }

}
