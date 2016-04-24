package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/28/2016.
 */
public class Brand implements Serializable, Task{
    private Long id;
    private Designer des;
    private String description;
    private Customer customer;
    private double price;

    public Brand(Builder b){
        this.des = b.des;
        this.description = b.description;
        this.id = b.id;
        this.customer = b.customer;
        this.price = b.price;
    }

    @Override
    public double cost() {
        return 0;
    }
    public static class Builder {
        private Designer des;
        private String description;
        private Long id;
        private Customer customer;
        private double price;
        public Builder() {

        }

        public Builder designer(Designer e){
            this.des = e;
            return this;
        }
        public Builder description(String d){
            description = d;
            return this;
        }
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder customer(Customer cust){
            customer = cust;
            return this;
        }
        public Builder price(double p){
            price = p;
            return this;
        }
        public Builder brand(Brand brand){
            des = brand.getDesigner();
            description = brand.getDescription();
            id = brand.getId();
            customer = brand.getCustomer();
            price  = brand.getPrice();
            return this;
        }
        public Brand build(){
            return new Brand(this);
        }


        public Builder copy(Brand b) {
            des = b.getDesigner();
            description = b.getDescription();
            id = b.getId();
            customer = b.getCustomer();
            price = b.getPrice();
            return this;
        }
    }
    private Long Id() {
        return id;
    }

    public Designer getDesigner() {
        return des;
    }

    public void setEditor(Designer designer) {
        this.des = designer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Brand other = (Brand) obj;
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public double price(int unitPrice, double jobDone) {
        return unitPrice * jobDone;
    }

    public String customerIdentity(Customer c) {
        return c.getName() + " " + c.getSurname();
    }
}
