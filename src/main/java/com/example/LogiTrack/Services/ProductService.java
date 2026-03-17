package com.example.LogiTrack.Services;

import com.example.LogiTrack.Models.Product;
import com.example.LogiTrack.Repositories.ProductRepositorie;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepositorie productRepositorie;

    public ProductService(ProductRepositorie productRepositorie)
    {
        this.productRepositorie = productRepositorie;
    }

    public Product addProduct(Product product)
    {
       return productRepositorie.save(product);
    }

    public List<Product> getAllProducts()
    {
        return productRepositorie.findAll();
    }

    public Optional<Product> getProduct(int id)
    {
        return productRepositorie.findById(id);
    }

    public void deleteProduct(int id)
    {
        productRepositorie.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category)
    {
        return productRepositorie.findProductsByCategory(category);
    }

    public List<Product> getProductsLessThan(BigDecimal price)
    {
        return productRepositorie.findProductLessThan(price);
    }


}
