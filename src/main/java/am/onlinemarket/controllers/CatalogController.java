package am.onlinemarket.controllers;

import am.onlinemarket.models.CartItem;
import am.onlinemarket.models.Catalog;
import am.onlinemarket.models.Product;
import am.onlinemarket.services.CartItemService;
import am.onlinemarket.services.CatalogService;
import am.onlinemarket.services.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class CatalogController {

    @Autowired
    CatalogService catalogService;

    @Autowired
    ProductService productService;

    @Autowired
    CartItemService cartItemService;

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

    @PostMapping("/add-cart")
    public String addCart(Model model,
//                          @ModelAttribute("pr")Product pr,
                          @RequestParam(value = "quantity")double quantity,
                          @RequestParam(value = "id")Long id){

        if (productService.findById(id).isPresent()){

            Product product = productService.findById(id).get();
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setProduct(product);
//            todo: cartItem-um user id-n avelacnel
        }

        logger.info("qanak ====== " +quantity);
        logger.info("id product ====== " +id);



        return "redirect:/show";


    }


}
