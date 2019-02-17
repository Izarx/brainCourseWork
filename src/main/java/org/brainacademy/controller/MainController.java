package org.brainacademy.controller;

import org.brainacademy.controller.form.EnterpriseForm;
import org.brainacademy.controller.form.UserForm;
import org.brainacademy.model.Enterprise;
import org.brainacademy.model.User;
import org.brainacademy.service.EnterpriseService;
import org.brainacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller // Помечаем класс как контроллер обрабатывающий REST запросы
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private EnterpriseService enterpriseService;

    // Вводится (inject) из application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = { "/users" })
    public String personList(Model model) {

        model.addAttribute("users", userService.getList());
        return "users";
    }

    @GetMapping(value = { "/registraton" })
    public String showAddPersonPage(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "registration";
    }

    @PostMapping(value = { "/registration" })
    public String savePerson(Model model, @ModelAttribute("userForm") UserForm userForm) {

        String login = userForm.getEmail();
        String password = userForm.getPassword();

        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            User newUser = new User();
            newUser.setEmail(login);
            newUser.setPassword(password);
            newUser.setCreationDate(new Date());
            userService.save(newUser);

            return "redirect:/users";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "registration";
    }

    @GetMapping(value = { "/enterprises" })
    public String enterpriseList(Model model) {

        model.addAttribute("enterprises", enterpriseService.getList());
        return "enterprises";
    }

    @GetMapping(value = { "/enterpriseAdd" })
    public String showAddEnterprisePage(Model model) {

        EnterpriseForm enterpriseForm = new EnterpriseForm();
        model.addAttribute("enterpriseForm", enterpriseForm);
        return "enterpriseAdd";
    }

    @PostMapping(value = { "/enterpriseAdd" })
    public String saveEnterprise(Model model, @ModelAttribute("enterpriseForm") EnterpriseForm enterpriseForm) {

        String name = enterpriseForm.getName();
        String address = enterpriseForm.getAddress();

        if (name != null && !name.isEmpty() && address != null && !address.isEmpty()) {
            Enterprise newEnterprise = new Enterprise();
            newEnterprise.setName(name);
            newEnterprise.setAddress(address);
            enterpriseService.save(newEnterprise);

            return "redirect:/enterprises";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "enterpriseAdd";
    }

}

