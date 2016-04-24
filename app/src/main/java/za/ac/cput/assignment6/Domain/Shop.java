package za.ac.cput.assignment6.Domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by louisane Malu on 4/2/2016.
 */

public class Shop implements Serializable, Parts{
    private static final long serialVersionUID = 1L;

    private Long identification;
    private double size;
    private String address;
    List<Parts> part;

    private Shop(Builder b){
        size = b.size;
        address = b.address;
        part = b.part;
        identification = b.identification;
    }

    @Override
    public double price() {
        return 0;
    }

    public static class Builder{
        private double size;
        private String address;
        private List<Parts> part;
        private Long identification;

        public Builder(String address) {
            this.address = address;
        }

        public Builder() {

        }

        public Builder size(double s){
            size = s;
            return this;
        }
        public Builder part(List<Parts> p){
            part = p;
            return this;
        }
        public Builder identification(Long identification){
            this.identification = identification;
            return this;
        }
        public Builder shop(Shop s){
            identification = s.getIdentification();
            address = s.getAddress();
            size= s.getSize();
            part = s.getPart();
            return this;
        }
        public Shop build(){
            return new Shop(this);
        }

        public Builder address(String a) {
            return this;
        }

        public Builder copy(Shop value) {

            this.identification = value.identification;
            this.size =value.size;
            this.address=value.address;
            this.part= value.part;
            return  this;
        }
        public Builder part(String string) {
            return this;
        }
    }
    public Long getIdentification() {
        return identification;
    }
    public void setId(Long identification) {
        this.identification = identification;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size= size;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Parts> getPart() {
        return part;
    }
    public void setPart(List<Parts> part) {
        this.part = part;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Shop)) {
            return false;
        }
        Shop other = (Shop) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Shop[ identification =" + identification + " ]";
    }
}
