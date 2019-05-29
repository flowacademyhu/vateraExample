package hu.flowacademy.vatera.controller;

import hu.flowacademy.vatera.model.Bid;
import hu.flowacademy.vatera.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/save/{bidownerid}")
    public ResponseEntity<Bid> save(@RequestBody Bid bid,@PathVariable Integer bidownerid) {
        return ResponseEntity.ok(bidService.save(bid,bidownerid));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getall")
    public ResponseEntity<List<Bid>> getAll() {
        return ResponseEntity.ok(bidService.getAllUser());
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getby/{id}")
    public ResponseEntity<Bid> getByid(@PathVariable Integer id) {
        return ResponseEntity.ok(bidService.getById(id));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public ResponseEntity<Bid> updateUser(@RequestBody Bid badge) {
        return ResponseEntity.ok(bidService.update(badge));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bidService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getorder/{name}")
    public ResponseEntity<List<Bid>> listByNameOrder(@PathVariable String name) {
        return ResponseEntity.ok(bidService.listByNameOrder(name));
    }

}
