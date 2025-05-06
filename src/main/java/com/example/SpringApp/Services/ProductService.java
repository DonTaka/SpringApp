package com.example.SpringApp.Services;

import com.example.SpringApp.Model.Product;
import com.example.SpringApp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //ADD
    public String agregarProducto(Product product){
        productRepository.save(product);
        return "Producto agregado con exito";
    }

    //GetALL
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

    //GetOnePerID
    public String obtenerProductoPorID(int id){
        String output="";
        if(productRepository.existsById(id)){
            Product  product = productRepository.findById(id).get();
            output+="ID Producto: "+product.getId()+"\n";
            output+="Nombre: "+product.getName()+"\n";
            output+="Descripcion: "+product.getDescription()+"\n";
            output+="Precio: $"+product.getPrice()+"\n";
            output+="Stock: "+product.getStock()+"\n";
            return output;
        }else{
            return "No se encuentra el producto";
        }
    }

    //Delete segun ID
    public String eliminarProducto(int id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Producto eliminado con exito";
        }else{
            return "No se encuentra el producto";
        }
    }

    //Actualizar producto
    public String actualizarProducto(int id,Product product){
        if(productRepository.existsById(id)){
            Product buscado =  productRepository.findById(id).get();
            buscado.setName(product.getName());
            buscado.setDescription(product.getDescription());
            buscado.setPrice(product.getPrice());
            buscado.setStock(product.getStock());
            productRepository.save(buscado);
            return "Producto actualizado con exito";
        }else{
            return  "No se encuentra el producto";
        }
    }
}
