package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/1/2016.
 */
    //@Entity
    public class SmartScreen implements Serializable, Parts {
    private static final long serialVersionUID = 1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private String name;
    private String code;
    private double price;

    private SmartScreen(Builder b) {
        identification = b.identification;
        name = b.name;
        code = b.code;
        price = b.price;
    }
    @Override
    public double price() {
        return 0;
    }

    public static class Builder {
        private String identification;
        private String name;
        private String code;
        private double price;

        public Builder() {

        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(String i) {
            this.identification = i;
            return this;
        }

        public Builder costPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder smartboard(SmartScreen screen) {
            this.identification = screen.getIdentification();
            name = screen.getName();
            code = screen.getCode();
            price = screen.getPrice();
            return this;
        }
        public SmartScreen build() {
            return new SmartScreen(this);
        }
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

    public String getIdentification() {
        return identification;
    }

    public void setId(String identification) {
        this.identification = identification;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SmartScreen)) {
            return false;
        }
        SmartScreen other = (SmartScreen) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Smartboard{" + "id=" + identification + ", name=" + name + ", code=" + code + '}';
    }
}
