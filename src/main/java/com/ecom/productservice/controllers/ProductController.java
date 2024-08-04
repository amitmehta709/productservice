package com.ecom.productservice.controllers;

import com.ecom.productservice.exception.AuthencationException;
import com.ecom.productservice.exception.NotFoundException;
import com.ecom.productservice.models.Product;
import com.ecom.productservice.services.ProductService;
import com.ecom.productservice.services.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private TokenService tokenService;

    //When we have two implementation of an interface construction injection will have an ambiguity which service to use
    //we can solve it in two ways
    //1. By adding qualifier as shown below in parameter to provide implementation should used and use the same name for
    // service like @Service("selfProductService")
    //2. Mark the service primary by using @Primary annotation
//    public ProductController(@Qualifier("selfProductService") ProductService productService)
//    {
//        this.productService = productService;
//    }

    public ProductController(ProductService productService, TokenService tokenService)
    {
        this.productService = productService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@RequestHeader("token") String token,
                                                  @PathVariable("id") Long id)
                                throws NotFoundException, AuthencationException
    {
        if(!tokenService.validateToken(token))
        {
            throw new AuthencationException("Not Authorized due to invalid Token");
        }
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
    {
        //Add a method to Validate Request Body
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public Product updateProductById(@PathVariable("id") Long id, @RequestBody Product product)
            throws NotFoundException {
        return productService.updateProduct(id, product);
    }
}
