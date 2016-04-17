package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/29/2016.
 */
//@Entity
public class Laptop implements Serializable, Parts {
    private static final long serialVersionUID = 1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private String name;
    private String code;
    private double price;

    private Laptop(Builder b) {
        this.identification = b.identification;
        this.code = b.code;
        this.name = b.name;
        this.price = b.price;
    }
    @Override
    public double price() {
        return 0;
    }
    public String custIdentity(Customer c) {
        return null;
    }

    public static class Builder {
        private String identification;
        private String name;
        private String code;
        private double price;

        public Builder() {

        }

        public Builder code(String c) {
            code = c;
            return this;
        }

        public Builder name(String n) {
            name = n;
            return this;
        }

        public Builder id(String i) {
            identification = i;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder laptop(Laptop laptop) {
            identification = laptop.getId();
            name = laptop.getName();
            code = laptop.getCode();
            price = laptop.getPrice();
            return this;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }

    public String getId() {
        return identification;
    }

    public void setId(String identification) {
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
        if (!(object instanceof Laptop)) {
            return false;
        }
        Laptop other = (Laptop) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Laptop{" + "id=" + identification + ", name=" + name + ", code=" + code + '}';
    }
}