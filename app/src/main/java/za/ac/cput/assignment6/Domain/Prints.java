package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/2/2016.
 */
//@Embeddable
public class Prints implements Serializable, Task {
    private Printer printer;
    private String desc;
   // @OneToMany
    //@JoinColumn(name = "prints_ID")
    private Customer customer;
    private String taskNum;
    private double price;

    public Prints() {
    }

    private Prints(Builder b){
        printer = b.printer;
        desc = b.desc;
        taskNum = b.taskNum;
        customer = b.customer;
        price = b.price;
    }

    public static class Builder{
        private Printer printer;
        private String desc;
        private String taskNum;
        private Customer customer;
        private double price;

        public Builder() {

        }
        public Builder printer(Printer p){
            printer = p;
            return this;
        }
        public Builder desc(String d){
            desc = d;
            return this;
        }
        public Builder taskId (String id){
            taskNum = id;
            return this;
        }
        public Builder customer(Customer cust){
            customer = cust;
            return this;
        }
        public Builder price(double price){
            this.price = price;
            return this;
        }
        public Builder prints(Prints p){
            printer = p.getPrinter();
            desc = p.getDesc();
            taskNum = p.getTaskId();
            customer = p.getCustomer();
            price = p.getPrice();
            return this;
        }
        public Prints build(){
            return new Prints(this);
        }
    }
    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public String getDesc() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

    public String getTaskId() {
        return taskNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setTaskId(String taskNum) {
        this.taskNum = taskNum;
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
        hash = 29 * hash + (this.desc != null ? this.desc.hashCode() : 0);
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
        final Prints other = (Prints) obj;
        if ((this.desc == null) ? (other.desc != null) : !this.desc.equals(other.desc)) {
            return false;
        }
        return true;
    }
    @Override
    public double cost() {
        return 0;
    }
    @Override
    public double price(int unitPrice, double jobDone) {
        return unitPrice * jobDone;
    }

    public String customerInformation(Customer c) {
        return c.getName() + " " + c.getSurname();
    }
}