package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/28/2016.
 */
public class Frame implements Serializable, Task {

    private Designer designer;
    private String desc;
    private String taskNum;
    private Customer customer;

   //@JoinColumn( name ="FrameId" ,insertable=false, updatable=false)
    private double price;

    public Frame(Builder b){
        designer = b.designer;
        desc = b.desc;
        taskNum = b.taskNum;
        customer = b.customer;
        price = b.price;
    }
    public static class Builder {


        public Designer designer;
        public String desc;
        public String taskNum;
        public Customer customer;

        //@JoinColumn( name="FrameId" ,insertable=false, updatable=false)
        private double price;
        public Builder() {

        }
        public Builder designer(Designer designer){
            this.designer = designer;
            return this;
        }
        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }
        public Builder taskId(String taskNum){
            this.taskNum = taskNum;
            return this;
        }
        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }
        public Builder price(double price){
            this.price = price;
            return this;
        }
        public Builder frame(Frame frame){
            designer = frame.getDesigner();
            desc= frame.getDesc();
            taskNum = frame.getTaskId();
            customer = frame.getCustomer();
            price  = frame.getPrice();
            return this;
        }
        public Frame build(){
            return new Frame(this);
        }
    }
    public void setDesigner(Designer designer) {
        this.designer = designer;
    }
    public Designer getDesigner() {
        return designer;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    public void setTaskId(String taskNum) {
        this.taskNum = taskNum;
    }
    public String getTaskId() {
        return taskNum;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setCustomer(Customer cust) {
        this.customer = cust;
    }
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (this.desc != null ? this.desc.hashCode() : 0);
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

        final Frame other = (Frame) obj;
        if ((this.desc == null) ? (other.desc != null) : !this.desc.equals(other.desc)) {
            return false;
        }
        return true;
    }

    public double cost() {
        return 0;
    }

    //@Override
    public double price(int unitPrice, double jobDone) {
        return unitPrice * jobDone;
    }
    public String custIdentity(Customer c) {
        return c.getName() + " " + c.getSurname();
    }
}
