package hu.flowacademy.vatera.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Bid {

    @Id
    @SequenceGenerator(name="bidIdGenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "bidIdGenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private int id;

    @Column
    private int bidvalue;

    @Column
    private String name;

    @Column
    private LocalDate bidtime;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product bidowner;

    public Bid() {
    }

    public Bid(int id, int bidvalue, String name, LocalDate bidtime) {
        this.id = id;
        this.bidvalue = bidvalue;
        this.name = name;
        this.bidtime = bidtime;
    }

    public Bid(int bidvalue, String name, LocalDate bidtime, Product bidowner) {
        this.bidvalue = bidvalue;
        this.name = name;
        this.bidtime = bidtime;
        this.bidowner = bidowner;
    }

    public Bid(int id, int bidvalue, String name, LocalDate bidtime, Product bidowner) {
        this.id = id;
        this.bidvalue = bidvalue;
        this.name = name;
        this.bidtime = bidtime;
        this.bidowner = bidowner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBidvalue() {
        return bidvalue;
    }

    public void setBidvalue(int bidvalue) {
        this.bidvalue = bidvalue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBidtime() {
        return bidtime;
    }

    public void setBidtime(LocalDate bidtime) {
        this.bidtime = bidtime;
    }

    public Product getBidowner() {
        return bidowner;
    }

    public void setBidowner(Product bidowner) {
        this.bidowner = bidowner;
    }
}
