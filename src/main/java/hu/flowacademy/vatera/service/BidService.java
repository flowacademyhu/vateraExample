package hu.flowacademy.vatera.service;

import hu.flowacademy.vatera.model.Bid;
import hu.flowacademy.vatera.model.Product;
import hu.flowacademy.vatera.repository.BidRepository;
import hu.flowacademy.vatera.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
@Transactional
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private ProductRepository productRepository;

    public Bid save(Bid bid) {
        if (productRepository.findById(bid.getBidowner().getId()).isEmpty()) {
            throw new RuntimeException("There is no product with this id");
        }
        Product product = productRepository.findById(bid.getBidowner().getId()).orElse(null);
        if (product.getUntil().isBefore(bid.getBidtime())) {
            throw new RuntimeException("Session ended");

        } if(bid.getBidvalue() < product.getMinimumprice()) {
            throw new RuntimeException("Bid is too small");

        }
        List<Bid> bids = bidRepository.listByProductName(bid.getBidowner().getName());
            if (bids.stream().map(a-> a.getBidvalue()).filter(a-> a > bid.getBidvalue()).count() > 0) {
                throw  new RuntimeException("Bid is toooooooo small");
            }
            return bidRepository.save(bid);

    }
    public Bid update(Bid bid) {
        if (bidRepository.findById(bid.getId()).isEmpty()) {
            return save(bid);
        }
        return bidRepository.save(bid);
    }

    public List<Bid> getAllUser() {
        return bidRepository.findAll();
    }

    public Bid getById(Integer id) {
        return bidRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        if (bidRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Bid not found");
        }
        Bid bid = bidRepository.findById(id).orElse(null);
        if (bid.getBidowner() == null) {
            bidRepository.deleteById(id);
        } else {
            throw new RuntimeException("You cant delete this bid");
        }
    }

    public List<Bid> listByNameOrder(String bidOwner) {
        return bidRepository.listByNameAscend(bidOwner);
    }
}
