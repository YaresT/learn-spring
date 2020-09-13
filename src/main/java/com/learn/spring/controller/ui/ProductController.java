package com.learn.spring.controller.ui;

import com.learn.spring.entity.Product;
import com.learn.spring.repository.ProductRepository;
import com.learn.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("list", productRepository.findAll());

        return modelAndView;
    }

    @GetMapping(value = "/new")
    public ModelAndView createProduct() {
        return new ModelAndView("product/new", "product", new Product());
    }

    @GetMapping(value = "/edit")
    public ModelAndView editProduct(@RequestParam Integer id) {
        return new ModelAndView(
                "product/edit",
                "product",
                productService.getProductById(id)
        );
    }
}
