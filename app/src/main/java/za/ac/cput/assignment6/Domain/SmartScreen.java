package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/1/2016.
 */

    public class SmartScreen implements Serializable, Parts {
    private static final long serialVersionUID = 1L;
    private Long identification;
    private String name;
    private String code;
    private double price;

    public SmartScreen(Builder b) {
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
        private Long identification;
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

        public Builder id(Long i) {
            this.identification = i;
            return this;
        }

        public Builder costPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder smartScreen(SmartScreen screen) {
            this.identification = screen.getIdentification();
            name = screen.getName();
            code = screen.getCode();
            price = screen.getPrice();
            return this;
        }
        public SmartScreen build() {
            return new SmartScreen(this);
        }

        public Builder copy(SmartScreen screen) {
            identification = screen.identification;
            name = screen.getName();
            code = screen.getCode();
            price = screen.getPrice();
            return this;
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

    public Long getIdentification() {
        return identification;
    }

    public void setId(Long identification) {
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
        return "SmartScreen{" + "id=" + identification + ", name =" + name + ", code =" + code + '}';
    }
}
