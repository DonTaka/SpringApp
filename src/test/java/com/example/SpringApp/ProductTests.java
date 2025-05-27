package com.example.SpringApp;

import com.example.SpringApp.Model.Product;
import com.example.SpringApp.Repository.ProductRepository;
import com.example.SpringApp.Services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTests {

    @Autowired
    ProductRepository productRepository;

    @MockitoBean
    ProductService productServiceMock;

    @Test
    @DisplayName("FindAll Test")
    void testProductServiceMock() {
        List<Product> productos = productRepository.findAll();
        assertNotNull(productos);
        assertEquals(1, productos.size());
    }

    @Test
    @DisplayName("Rectificar precio producto")
    void testFindProduct(){
        Product prueba = productRepository.findById(1).get();
        assertNotNull(prueba);
        assertEquals(259990,prueba.getPrice());
    }

}
