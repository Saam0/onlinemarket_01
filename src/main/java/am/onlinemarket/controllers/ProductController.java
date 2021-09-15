package am.onlinemarket.controllers;

import am.onlinemarket.models.Product;
import am.onlinemarket.models.ProductCategory;
import am.onlinemarket.models.Supplier;
import am.onlinemarket.services.ProductCategoryService;
import am.onlinemarket.services.ProductService;
import am.onlinemarket.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    ProductCategoryService productCategoryService;


    @GetMapping("/add")
    public String addProductGet(Model model) {
        System.out.println("getProduct++++++++++++++++++");

//        model.addAttribute("supplierForm", new Supplier());

        List<ProductCategory> productCategories = productCategoryService.findAllProductCategory();

        model.addAttribute("productCategory", productCategories);
        model.addAttribute("productForm", new Product());

        return "product/add_product";
    }


    @PostMapping("/add")
    public String addProductPost(Model model,
                                 @ModelAttribute("productForm") Product productForm,
                                 @RequestParam(value = "supplierName")String supplierName)

//                                 @RequestParam(value = "category")String category)
    {


//        System.out.println(category);

        if (!supplierService.findByName(supplierName).isPresent()){
            System.out.println("KKKKKKKKKKKK");
            Supplier supplier = new Supplier();
            supplier.setSupplierName(supplierName);
            supplierService.save(supplier);
            productForm.setSupplier(supplier);
        }


        Supplier supplier = supplierService.findByName(supplierName).get();
        productForm.setSupplier(supplier);

        productService.save(productForm);

        return "hello";
    }


    @GetMapping("/product-list")
    public String getAllProductList(Model model) {


        List<Product> products = productService.findAllProducts();

        model.addAttribute("productList", products);

        return "product/product_list";
    }

    @PostMapping("/product-list")
    public String dellProduct(Model model,
                              @RequestParam(value = "removeProduct") Long removeProduct) {
     productService.deleteProduct(removeProduct);

        return "redirect:/product/product-list";

    }

}
