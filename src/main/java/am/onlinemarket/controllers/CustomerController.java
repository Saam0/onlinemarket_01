package am.onlinemarket.controllers;

import am.onlinemarket.models.Contact;
import am.onlinemarket.models.User;
import am.onlinemarket.services.ContactService;
import am.onlinemarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;


@Controller
@RequestMapping("")
public class CustomerController {

    @Autowired
    UserService userService;
    @Autowired
    ContactService contactService;

    @Autowired
    Logger logger;


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
    public String getRegNewUsers(Model model) {

        System.out.println("----------------===================");
        model.addAttribute("userForm", new User());
        return "index";
    }


    @PostMapping("/user/new")
    public String postRegNewUser(Model model,
                                 @ModelAttribute("userForm") User userForm,
                                 @ModelAttribute("contact") Contact contact,
                                 @RequestParam(value = "confirmPass") String confirmPass) {


        logger.info("contact = " + contact.getPhones());

        Contact cont = contactService.save(contact);
        System.out.println(contact.getPhones());
        System.out.println(contact.getCountry());
        userForm.setContact(cont);
        if (userForm.getPassword().equals(confirmPass)) {
            userService.save(userForm);

            return "hello";
        }
        return "index";
    }


}
