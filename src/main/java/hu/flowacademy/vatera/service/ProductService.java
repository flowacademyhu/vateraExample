package hu.flowacademy.vatera.service;

import hu.flowacademy.vatera.model.Product;
import hu.flowacademy.vatera.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        if (!productRepository.findByName(product.getName()).isEmpty()) {
            throw new RuntimeException("this badge name alredy exists");
        }
        return productRepository.save(product);
    }
    public Product update(Product product) {
        if (productRepository.findById(product.getId()).isEmpty()) {
            return save(product);
        }
        return productRepository.save(product);
    }

    public List<Product> getAllUser() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        if (productRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Badge not found");
        }
        productRepository.deleteById(id);
    }


}
