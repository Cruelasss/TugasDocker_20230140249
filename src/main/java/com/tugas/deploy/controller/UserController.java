package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Data bersifat temporary (tidak pakai database)
    private List<User> listMahasiswa = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login"; // Mengarahkan ke login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        // Login: username = admin, password = nim masing-masing
        // GANTI "123456789" DENGAN NIM ASLIMU!
        if ("admin".equals(username) && "123456789".equals(password)) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password salah!");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("listMahasiswa", listMahasiswa);
        return "home"; // Mengarahkan ke home.html
    }

    @GetMapping("/form")
    public String formInput(Model model) {
        model.addAttribute("user", new User());
        return "form"; // Mengarahkan ke form.html
    }

    @PostMapping("/submit-form")
    public String submitForm(@ModelAttribute User user) {
        listMahasiswa.add(user);
        return "redirect:/home";
    }
}