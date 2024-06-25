package com.ipn.practicacrud.services;

import com.ipn.practicacrud.DTO.ProductosCategoriasDTO;
import com.ipn.practicacrud.models.Product;
import com.ipn.practicacrud.models.requestModels.RequestProduct;

import java.util.List;

public interface ProductService {
    List<ProductosCategoriasDTO> getAllProctCategory();

    List<Product> getAllProducts();

    Product saveProduct(RequestProduct product);

    Product updateProduct(int id, RequestProduct product);
    Boolean deleteProductById(int id);
}
