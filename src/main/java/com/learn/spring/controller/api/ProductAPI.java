package com.learn.spring.controller.api;

import com.learn.spring.entity.Product;
import com.learn.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/product")
public class ProductAPI {
    @Autowired
    ProductService productService;

    @PostMapping("/new")
    public String createProduct(@ModelAttribute("product") Product product) {
        System.out.println(product);
        productService.createProduct(product);

        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String removeProduct(@RequestParam("id") Integer id) {

        productService.removeProduct(id);

        return "redirect:/product";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product product) {

        productService.updateProduct(product);

        return "redirect:/product";
    }
}
