package hu.flowacademy.vatera.repository;

import hu.flowacademy.vatera.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("FROM Product product WHERE product.name = ?1")
    public Optional<Product> findByName(String name);
}
