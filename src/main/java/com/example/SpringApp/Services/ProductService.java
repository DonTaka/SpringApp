package com.example.SpringApp.Services;

import com.example.SpringApp.Model.Product;
import com.example.SpringApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public String agregarProducto(Product product){
        productRepository.save(product);
        return "Producto agregado con exito";
    }
    public String listarProductos(){
        String output="";
        for(Product product:productRepository.findAll()){
            output+="ID Producto: "+product.getId()+"\n";
            output+="Nombre: "+product.getName()+"\n";
            output+="Descripcion: "+product.getDescription()+"\n";
            output+="Precio: $"+product.getPrice()+"\n";
            output+="Stock: $"+product.getStock()+"\n";
        }

        if(output.isEmpty()){
           return "No hay productos";
        }else{
           return output;
        }
    }
}
