package com.example.errorhandling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {

    @GetMapping("/products/{id}")
    public String getProductById() {
        throw new NullPointerException("OOPS bug");
    }
}
