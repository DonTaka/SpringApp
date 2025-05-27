package com.example.SpringApp;

import com.example.SpringApp.Controller.ProductController;
import com.example.SpringApp.Model.Product;
import com.example.SpringApp.Repository.ProductRepository;
import com.example.SpringApp.Services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
//Asignamos Anotacion para autoconfiguracion del mockMVC
@AutoConfigureMockMvc
class ProductTests {

    @Autowired
    ProductRepository productRepository;

    //Generamos un mockMVC que nos permitira realizar consultas HTTPMethod
    @Autowired
    MockMvc mockMvc;

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
        assertEquals(359990,prueba.getPrice());
    }

    @Test
    @DisplayName("Test controller")
    void testController()  {
        //Indicamos que el retorno de listarProductos se identificara con el valor ingresado en thenReturn
        when(productServiceMock.listarProductos()).thenReturn("Lista completa");

        //Bloque Try Except/Catch
        //Nos permite probar una funcionalidad de codigo o un segmento de codigo y si este falla
        //Se captura por medio de Catch(Exception var) y ejecuta un control de error
        try{
            //MockMvc Nos permite realizar consultas HTTPMethod
            //perform nos permite ejecutar dichas llamadas y luego ingresamos el metodo HTTP correspondiente
            //adicionalmente podemos agregar parametros u variables adicionales de ser requerido
            //Finalmente andExcept nos permite indicar que esperamos de dicha respuesta HTTP
            //Tanto codigo como contenido
            mockMvc.perform(get("/products"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Lista completa"));

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            fail();
        }
    }

}
