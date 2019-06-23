package pl.bykowski.springbootcaffe.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cafeteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String adress;
    
    @OneToMany(mappedBy = "cafeteria")
    private Set<Coffee> coffees;

    public Cafeteria(String name, String adress, Set<Coffee> coffees) {
        this.name = name;
        this.adress = adress;
        this.coffees = coffees;
    }

    public Cafeteria() {
    }



    public Set<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Set<Coffee> coffees) {
        this.coffees = coffees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
