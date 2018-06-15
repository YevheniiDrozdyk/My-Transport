package com.khadi.mytransport.controller;

import com.khadi.mytransport.dto.UserDto;
import com.khadi.mytransport.model.User;
import com.khadi.mytransport.service.CaptchaService;
import com.khadi.mytransport.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping({"/registration", "/registration.html"})
public class RegistrationController {

    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        model.addAttribute("currentPage", "registration");

        return "page-template";
    }

    @PostMapping
    public ModelAndView register(
            @ModelAttribute @Valid UserDto userDto, BindingResult result,
            @RequestParam(name = "g-recaptcha-response") String captcha, HttpServletRequest request) {
        User user = new User();
        String captchaErrors = captchaService.verify(request.getRemoteAddr(), captcha);
        if (!result.hasErrors() && StringUtils.isEmpty(captchaErrors)) {
            user = userService.register(userDto);
        }
        if (user == null) {
            result.rejectValue("phoneNumber", "message.regError");
            result.addError(new ObjectError("registration.message", "There is an account with such phone number: " + userDto.getPhoneNumber()));
        }
        if (result.hasErrors() || StringUtils.isNotEmpty(captchaErrors)) {
            return new ModelAndView("redirect:/registration")
                    .addObject("userDto", userDto)
                    .addObject("errors", result.getAllErrors())
                    .addObject("captchaErrors", captchaErrors);
        }

        return new ModelAndView("redirect:/index")
                .addObject("registration.message", "Thanks " + userDto.getFirstName() + ", for the registration");
    }

}
