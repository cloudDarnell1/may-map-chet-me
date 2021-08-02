package thaovan.lab8.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thaovan.lab8.entity.ProductsEntity;
import thaovan.lab8.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductRest {

    @Autowired
    private ProductsService productsService;

    @GetMapping(path = "/{productId}")
    public ResponseEntity findById(@PathVariable Integer productId) {
        ProductsEntity product = this.productsService.findById(productId);
        return ResponseEntity.ok(product);
    }
}
