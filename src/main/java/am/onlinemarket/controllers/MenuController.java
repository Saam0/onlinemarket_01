package am.onlinemarket.controllers;

import am.onlinemarket.models.Menu;
import am.onlinemarket.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class MenuController {

    @Autowired
    MenuService menuService;

    @GetMapping()
    public String getMenu(Model model) {

        System.out.println("menuuuuuuuuu");

        List<Menu> list = menuService.findAllMenu();

        model.addAttribute("menuList", list);
        System.out.println(list.size());
        return "index";
    }

    @GetMapping("/show")
    public String showProducts(Model model,
                               @RequestParam(value = "productType") String productType) {

        System.out.println(productType);


        return "hello";
    }


}
