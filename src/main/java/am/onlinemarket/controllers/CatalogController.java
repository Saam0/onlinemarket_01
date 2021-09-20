package am.onlinemarket.controllers;

import am.onlinemarket.models.Catalog;
import am.onlinemarket.models.Product;
import am.onlinemarket.services.CatalogService;
import am.onlinemarket.services.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @Autowired
    ProductService productService;

    @Autowired
    Logger logger;

    @GetMapping()
    public String getMenu(Model model) {


        List<Catalog> list = catalogService.findAllCatalog();

        model.addAttribute("catalogList", list);
        return "index";
    }

    @GetMapping("/show")
    public String getProducts(Model model,
                               @RequestParam(value = "productType") String productType) {


        List<Product> productList = productService.findByType(productType);
        model.addAttribute("productList", productList);

        return "index";
    }

/*    @PostMapping("/show")
    public String showProducts(){

    }*/


}
