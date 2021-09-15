package am.onlinemarket.controllers;

import am.onlinemarket.models.Contact;
import am.onlinemarket.models.User;
import am.onlinemarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class CustomerController {

    @Autowired
    UserService userService;



//    @GetMapping("/index")
//    public String getRegNewUser(Model model){
//
//        System.out.println("+++++++++++++++===================");
////        model.addAttribute("userForm", new User());
//        return "index";
//    }


//    @GetMapping("")
//    public String getRegNewUsers(Model model){
//
//        System.out.println("----------------===================");
//        model.addAttribute("userForm", new User());
//        return "index";
//    }

    @GetMapping("/user/new")
    public String getRegNewUsers(Model model){

        System.out.println("----------------===================");
        model.addAttribute("userForm", new User());
        return "index";
    }


    @PostMapping("/user/new")
    public String postRegNewUser(Model model,
                             @ModelAttribute("userForm") User userForm,
                                 @ModelAttribute("contact") Contact contact,
                             @RequestParam(value = "confirmPass") String confirmPass){
        System.out.println("11111111111111111111+++++++++++++++++++++++++");

        System.out.println(contact.getPhones());
        System.out.println(contact.getCountry());
        userForm.setContact(contact);
        if (userForm.getPassword().equals(confirmPass)) {
            userService.save(userForm);
            System.out.println("11111111111111111111+++++++++++++++++++++++++");

            return "hello";
        }
        return "index";
    }








}
