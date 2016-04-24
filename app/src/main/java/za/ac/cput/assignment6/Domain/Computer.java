package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/29/2016.
 */
public class Computer implements Serializable, Parts{

    private static final long serialVersionUID = 1L;
    //@Id
   //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long identification;
    private String name;
    private String code;
    private double price;

    private Computer(Builder b){
        identification = b.identification;
        code = b.code;
        name = b.name;
        price = b.price;
    }
    @Override
    public double price() {
        return price;
    }

    public static class Builder{
        private Long identification;
        private String name;
        private String code;
        private double price;

        public Builder(){

        }

        public Builder code(String code){
            this.code= code;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder identification(Long identification){
            this.identification = identification;
            return this;
        }
        public Builder price(double price){
            this.price= price;
            return this;
        }
        public Builder computer(Computer comp){
            identification = comp.identification;
            name = comp.getName();
            code = comp.getCode();
            price = comp.getPrice();
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

        public Builder copy(Computer comp) {
            identification = comp.getIdentification();
            name = comp.getName();
            code= comp.getCode();
            price = comp.getPrice();
            return this;
        }
    }
    public Long getIdentification() {
        return identification;
    }

    public void setId(Long identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer other = (Computer) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Computer {" + "Identification=" + identification + ", Name =" + name + ", Code =" + code + '}';
    }

}
