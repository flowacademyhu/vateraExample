package hu.flowacademy.vatera.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Product {

    @Id
    @SequenceGenerator(name="idgenerator", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "idgenerator", strategy = GenerationType.SEQUENCE)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int minimumprice;

    @Column
    private LocalDate added;

    @Column
    private LocalDate until;

    @JsonIgnore
    @OneToMany(mappedBy = "bidowner", fetch = FetchType.LAZY)
    private Set<Bid> bids;

    public Product() {
    }

    public Product(String name, String description, int minimumprice, LocalDate added, LocalDate until) {
        this.name = name;
        this.description = description;
        this.minimumprice = minimumprice;
        this.added = added;
        this.until = until;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinimumprice() {
        return minimumprice;
    }

    public void setMinimumprice(int minimumprice) {
        this.minimumprice = minimumprice;
    }

    public LocalDate getAdded() {
        return added;
    }

    public void setAdded(LocalDate added) {
        this.added = added;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
        this.until = until;
    }
}
