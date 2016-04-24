package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/29/2016.
 */
public class Brochure implements Serializable, Task{
    private Designer designer;
    private String desc;
    private Customer customer;
    private Long id;
    private double price ;

    private Brochure(Builder b){
        this.desc = b.desc;
        this.designer = b.designer;
        this.id = b.id;
        customer = b.customer;
        price = b.price;
    }
    public static class Builder{
        private Designer designer;
        private String desc;
        private Long id;
        private Customer customer;
        private double price;

        public Builder(){
        }
        public Builder designer(Designer designer){
            this.designer = designer;
            return this;
        }
        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }
        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder price(double price){
            this.price = price;
            return this;
        }
        public Builder copy(Brochure b){
            designer = b.getDesigner();
            desc = b.getDescription();
            id = b.getId();
            customer = b.getCustomer();
            price = b.getPrice();
            return this;
        }
        public Brochure build(){
            return new Brochure(this);
        }

    }
    public Designer getDesigner() {
        return designer;
    }
    public void setDesigner(Designer designer) {
        this.designer = designer;
    }
    public String getDescription() {
        return desc;
    }
    public void setDescription(String desc) {
        this.desc = desc;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setWorkID(Long id) {
        this.id= id;
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
        hash = 79 * hash + (this.desc != null ? this.desc.hashCode() : 0);
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
        final Brochure other = (Brochure) obj;
        if ((this.id == null) ? (other.desc!= null) : !this.desc.equals(other.id)) {
            return false;
        }
        return true;
    }
    public double cost() {
        return 0;
    }

    @Override
    public double price(int unitPrice, double jobDone) {
        this.price = unitPrice;
        return unitPrice * jobDone;
    }
    public String customerIdentity(Customer c) {
        return c.getName() + " " + c.getSurname();
    }
}
