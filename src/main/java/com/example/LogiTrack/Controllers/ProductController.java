package com.example.LogiTrack.Controllers;

import com.example.LogiTrack.Models.Product;
import com.example.LogiTrack.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("/new")
    public Product addNewProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAll()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @GetMapping("/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category)
    {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/{price}")
    public List<Product> getProductsByPrice(@PathVariable BigDecimal price)
    {
        return productService.getProductsLessThan(price);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
        return "Product deleted successfully.";
    }

}
