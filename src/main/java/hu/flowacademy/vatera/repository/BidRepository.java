package hu.flowacademy.vatera.repository;

import hu.flowacademy.vatera.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository extends JpaRepository<Bid,Integer> {

    @Query("FROM Bid bid WHERE bid.name = ?1")
    public Optional<Bid> findByName(String name);

    /*@Query("FROM Bid bid WHERE bid.bidowner == ?1 ORDER BY bid.bidvalue")
    public List<Bid> listByNameAscend(String bidowner);*/
    @Query("FROM Bid bid WHERE bid.name = ?1 ORDER BY bid.bidvalue")
    public List<Bid> listByNameAscend(String bidowner);

    @Query("FROM Bid bid WHERE bid.bidowner.name = ?1")
    public List<Bid> listByProductName(String name);
}
