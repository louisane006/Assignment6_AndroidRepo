package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/2/2016.
 */
//@Entity
public class Ipad implements Serializable, Parts {
    private static final long serialVersionUID = 1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long identification;
    private String name;
    private String code;
    private double price;

    private Ipad(Builder b){
        name = b.name;
        code = b.code;
        identification = b.identification;
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
        public Builder code(String c){
            code = c;
            return this;
        }
        public Builder name(String n){
            name = n;
            return this;
        }
        public Builder id(Long i){
            identification = i;
            return this;
        }
        public Builder costPrice(double price){
            this.price = price;
            return this;
        }
        public Builder ipad(Ipad i){
            identification = i.getIdentification();
            name = i.getName();
            code = i.getCode();
            price = i.getPrice();
            return this;
        }
        public Ipad build(){
            return new Ipad(this);
        }

        public Builder copy(Ipad i) {
            identification = i.getIdentification();
            name = i.getName();
            code= i.getCode();
            price = i.getPrice();
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

        if (!(object instanceof Ipad)) {
            return false;
        }
        Ipad other = (Ipad) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "IPad{" + "Id =" + identification + ", Name =" + name + ", Code =" + code + '}';
    }
}
