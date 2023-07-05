package website.anime.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import website.anime.dto.UserDTO;
import website.anime.model.Role;
import website.anime.model.User;
import website.anime.repository.RoleRepository;
import website.anime.repository.UserRepository;

@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/forgotpassword")
    public String forgotPassword(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "forgotpassword";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        return "register";
    }

    @GetMapping
    public String register(@ModelAttribute User userModel, HttpServletRequest request) throws ServletException{
        String password = userModel.getPassword();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(1).get());
        roles.add(roleRepository.findById(2).get());
        userModel.setRoles(roles);
        request.login(userModel.getEmail(), password);
        return "redirect:/";
    }

}
