package am.onlinemarket.controllers;

import am.onlinemarket.models.Product;
import am.onlinemarket.models.ProductCategory;
import am.onlinemarket.models.Supplier;
import am.onlinemarket.services.ProductCategoryService;
import am.onlinemarket.services.ProductService;
import am.onlinemarket.services.SupplierService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    Logger logger;

    @Value("${static.img.path}")
    private String imagePath;


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
                                 @ModelAttribute("supplier") Supplier supplier,
                                 @RequestParam("file") MultipartFile file)  throws IOException{


        logger.info("file ====" + file.getName());

        if (!file.isEmpty()){
            File imageDir = new File(imagePath);
            if (!imageDir.exists()){
                imageDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(imagePath + "/" + resultFileName));

            productForm.setImage(resultFileName);
        }

        logger.info("supplier name = " + supplier.getSupplierName());

//        Supplier supp = supplierService.save(supplier);
//        productForm.setSupplier(supp);


        if (!supplierService.findByName(supplier.getSupplierName()).isPresent()) {
            supplierService.save(supplier);
            productForm.setSupplier(supplier);

        }else {
//            Supplier newSupplier = supplierService.findByName(supplier.getSupplierName()).get();
            productForm.setSupplier(supplierService.findByName(supplier.getSupplierName()).get());
        }

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
