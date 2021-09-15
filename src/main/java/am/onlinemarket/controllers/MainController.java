package am.onlinemarket.controllers;

import am.onlinemarket.models.User;
import am.onlinemarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    UserService userService;



//    @GetMapping("/")
//    public String index(Model model){
//
//
//        return "index";
//    }

/*
    @GetMapping("")
    public String getRegNewUser(Model model){

        System.out.println("+++++++++++++++===================");
        model.addAttribute("userForm", new User());
        return "index";
    }
*/


    @GetMapping("/login")
    public String getLogin(){
        System.out.println("getlogin++++++++++++++++++");
        return "login";
    }



    @PostMapping("/login")
    public String postLogin(Model model, @RequestParam(value = "email") String email,
                            @RequestParam(value = "password") String password){
        System.out.println(password);
        if (userService.findByEmail(email).isPresent()){
            User user = userService.findByEmail(email).get();
            String pass = user.getPassword();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(password,pass)){
                System.out.println("CHHHHishta");
                return "mutq";

            }else {
                System.out.println("SSSxala");
                return "error";

            }

        }else {
            System.out.println("nman email chka");
            return "error";
        }


//        return "redirect:/index";
    }







}
