package org.brainacademy.controller;

import org.brainacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller // Помечаем класс как контроллер обрабатывающий REST запросы
public class MainUserController {

    @Autowired
    private UserService userService;

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

    @GetMapping(value = { "/list" })
    public String personList(Model model) {

        model.addAttribute("users", userService.getList());
        return "list";
    }

}
