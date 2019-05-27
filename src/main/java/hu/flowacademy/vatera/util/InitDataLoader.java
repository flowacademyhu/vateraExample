package hu.flowacademy.vatera.util;

import hu.flowacademy.vatera.model.Bid;
import hu.flowacademy.vatera.model.Product;
import hu.flowacademy.vatera.repository.BidRepository;
import hu.flowacademy.vatera.repository.ProductRepository;
import hu.flowacademy.vatera.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

@Component
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {

        bidRepository.save(new Bid(12,"Joska",LocalDate.now(),null));
        bidRepository.save(new Bid(1222,"Pecze",LocalDate.now(),null));
       InputStream productInput = new ClassPathResource(
                "product.txt").getInputStream();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(productInput))) {

            reader.lines().forEach(t -> {
                String[] attr = t.split(";");
                System.out.println("asasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+attr.length);
                productRepository.save(new Product(attr[0], attr[1], Integer.parseInt(attr[2]), LocalDate.parse(attr[3]), LocalDate.parse(attr[4])));
            });

        }

        InputStream bidInput = new ClassPathResource(
                "bid.txt").getInputStream();
        try (BufferedReader driverreader = new BufferedReader(
                new InputStreamReader(bidInput))) {

            driverreader.lines().forEach(t -> {
                String[] attr = t.split(";");
                Product owner = productRepository.findById(Integer.parseInt(attr[3])).orElse(null);
                bidRepository.save(new Bid(Integer.parseInt(attr[0]), attr[1], LocalDate.parse(attr[2]), owner));
            });

        }


    }
}
