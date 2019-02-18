package org.brainacademy.controller;

import org.brainacademy.controller.form.UserForm;
import org.brainacademy.controller.validation.UserValidator;
import org.brainacademy.model.User;
import org.brainacademy.service.UserService;
import org.brainacademy.service.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller // Помечаем класс как контроллер обрабатывающий роутинг для стр. авторизации
@RequestMapping("/users")
public class AuthController {

    // Иньектируем сервис для работы с пользователями
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping({"/registration"})
    public String registration(Model model) {
        model.addAttribute("userForm", new UserForm());

        return "users/registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "users/registration";
        }
        User newUser = new User();
        newUser.setEmail(userForm.getEmail());
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        newUser.setPassword(encoder.encode(userForm.getPassword()));
        newUser.setCreationDate(new Date());
        userService.save(newUser);

        securityService.autoLogin(userForm.getEmail(), userForm.getPassword());
        return "redirect:/index";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "users/login";
    }

}
