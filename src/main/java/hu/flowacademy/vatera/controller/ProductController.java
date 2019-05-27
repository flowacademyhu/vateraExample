package hu.flowacademy.vatera.controller;

import hu.flowacademy.vatera.model.Product;
import hu.flowacademy.vatera.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAllUser());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getby/{id}")
    public ResponseEntity<Product> getByid(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getById(id));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public ResponseEntity<Product> updateUser(@RequestBody Product product) {
        return ResponseEntity.ok(productService.update(product));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
