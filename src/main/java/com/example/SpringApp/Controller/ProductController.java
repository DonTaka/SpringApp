package com.example.SpringApp.Controller;

import com.example.SpringApp.Model.Product;
import com.example.SpringApp.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getProducts(){
        return productService.listarProductos();
    }

    @PostMapping
    public String postProduct(@RequestBody Product product){
        return productService.agregarProducto(product);
    }
}
