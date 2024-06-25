package com.ipn.practicacrud.controllers;


import com.ipn.practicacrud.DTO.ProductosCategoriasDTO;
import com.ipn.practicacrud.models.Category;
import com.ipn.practicacrud.models.Product;
import com.ipn.practicacrud.models.requestModels.RequestProduct;
import com.ipn.practicacrud.services.CategoryService;
import com.ipn.practicacrud.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/product")
public class ProductoController {
    @Autowired
    private ProductService productService;

    @GetMapping("/categoryProduct")
    public List<ProductosCategoriasDTO> getAllCategories(){
        return productService.getAllProctCategory();
    }

    @GetMapping
    public List<Product> getAllProducts() { return productService.getAllProducts(); }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody RequestProduct product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public  ResponseEntity<Product> updateProduct(@PathVariable("id") int id , @RequestBody RequestProduct product){
        Product currentProduct = productService.updateProduct(id,product);
        if(currentProduct == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id")int id){
        boolean isProductDelete = productService.deleteProductById(id);
        if(isProductDelete)
            return new ResponseEntity<>("Registro eliminado correctamente", HttpStatusCode.valueOf(204));
        else
            return new ResponseEntity<>("Registro no fue eliminado",HttpStatus.NOT_FOUND);

    }
}
