package model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "packages")
public class Packages {

    public enum PackageStatus{
        NOT_BOOKED, IN_PROGRESS, BOOKED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private Date startDate, endDate;

    @Column
    private String extraDetails;

    @Column
    private int emptySpots;

    @Column
    @ColumnDefault("PackageStatus.NOT_BOOKED")
    private PackageStatus packageStatus;

    public Packages(){
    }

    public Packages(int price, String name, Date startDate, Date endDate, String extraDetails, int emptySpots, PackageStatus packageStatus) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.extraDetails = extraDetails;
        this.emptySpots = emptySpots;
        this.packageStatus = packageStatus;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getExtraDetails() {
        return extraDetails;
    }

    public void setExtraDetails(String extraDetails) {
        this.extraDetails = extraDetails;
    }

    public int getEmptySpots() {
        return emptySpots;
    }

    public void setEmptySpots(int emptySpots) {
        this.emptySpots = emptySpots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPackageStatus(PackageStatus packageStatus) {
        this.packageStatus = packageStatus;
    }

    public PackageStatus getPackageStatus() {
        return packageStatus;
    }

    @Override
    public String toString() {
        return name;

    }
}
