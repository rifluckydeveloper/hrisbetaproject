package com.example.hrisproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hrisproject.model.Users;
import com.example.hrisproject.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "LoginForm";  // Mengarah ke form login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        Model model) {
        // Autentikasi user
        Optional<Users> userOptional = userService.authenticateUser(username, password);
        if (userOptional.isPresent()) {
            // Redirect ke halaman dashboard atau halaman utama
            return "redirect:/dashboard";
        } else {
            // Menampilkan pesan error jika login gagal
            model.addAttribute("error", "Username atau password salah.");
            return "LoginForm";  // Kembali ke halaman login
        }
    }

    // Halaman dashboard setelah login berhasil
    @GetMapping("/dashboard")
    public String dashboard() {
        return "MainFrame"; // Halaman dashboard yang ingin ditampilkan
    }
}
