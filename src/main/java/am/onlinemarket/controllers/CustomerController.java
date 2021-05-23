package am.onlinemarket.controllers;

import am.onlinemarket.models.User;
import am.onlinemarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class CustomerController {

    @Autowired
    UserService userService;


    @GetMapping("/new")
    public String getRegNewUser(Model model){

        model.addAttribute("userForm", new User());
        return "customer/new";
    }

    @PostMapping("/new")
    public String postRegNewUser(Model model,
                             @ModelAttribute("userForm") User userForm,
                             @RequestParam(value = "confirmPass") String confirmPass){
        System.out.println(userForm.getFirsName());
        System.out.println(userForm.getPassword());
        System.out.println(confirmPass);


        if (userForm.getPassword().equals(confirmPass)) {
            userService.save(userForm);

            return "redirect:/index";
        }


        return "customer/new";
    }








}
