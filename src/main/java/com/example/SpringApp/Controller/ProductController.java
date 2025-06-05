package com.example.SpringApp.Controller;

import com.example.SpringApp.Model.Product;
import com.example.SpringApp.Services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name="API Productos ",description = "Servicios disponibilizados para gestionar productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Obtener lista de productos",description = "Servicio de consulta productos disponibles en entorno")
    public String getProducts() {
        return productService.listarProductos();
    }

    @PostMapping
    public String postProduct(@RequestBody Product product) {
        return productService.agregarProducto(product);
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable int id) {
        return productService.obtenerProductoPorID(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id) {
        return productService.eliminarProducto(id);
    }

    @PutMapping("/{id}")
    public String updateProductById(@PathVariable int id, @RequestBody Product product) {
        return productService.actualizarProducto(id, product);
    }

}
