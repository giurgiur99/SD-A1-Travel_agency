package model;

import javax.persistence.*;
import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vacations")
public class Vacations {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String destination;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "packages_id", referencedColumnName = "id")
    private List<Packages> packagesArrayList = new ArrayList<Packages>();

    public Vacations(String destination) {
        this.destination = destination;
    }

    public Vacations(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public List<Packages> getPackagesArrayList() {
        return packagesArrayList;
    }
    public void setPackagesArrayList(List<Packages> packagesArrayList) {
        this.packagesArrayList = packagesArrayList;
    }

    public void addPackage(Packages packages){
        this.packagesArrayList.add(packages);
    }

    @Override
    public String toString() {
        return destination ;

    }
}
