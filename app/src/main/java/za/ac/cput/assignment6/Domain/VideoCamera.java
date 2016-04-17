package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/1/2016.
 */
//@Entity
public class VideoCamera implements Serializable, Parts{
    private static final long serialVersionUID = 1L;
   // @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private String name;
    private String code;
    private double price;

    private VideoCamera(Builder b){
        this.identification = b.identification;
        this.code = b.code;
        this.name = b.name;
        this.price = b.price;
    }

   /* public double price(int unitPrice, double jobDone) {
        return 0;
    }

    public String custIdentity(Customer c) {
        return null;
    }*/

    @Override
    public double price() {
        return price;
    }

    public static class Builder{
        private String identification;
        private String name;
        private String code;
        private double price;

        public Builder() {

        }

        public Builder code(String c){
            code = c;
            return this;
        }
        public Builder name(String n){
            name = n;
            return this;
        }

        public Builder id(String i){
            identification = i;
            return this;
        }
        public Builder costPrice(double cost){
            price = cost;
            return this;
        }
        public Builder Videocamera(VideoCamera cam){
            identification = cam.getIdentification();
            name = cam.getName();
            code = cam.getCode();
            price = cam.getCostPrice();
            return this;
        }
        public VideoCamera build(){
            return new VideoCamera(this);
        }
    }

    public String getIdentification() {
        return identification;
    }

    public void setId(String id) {
        identification = id;
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

    public double getCostPrice() {
        return price;
    }

    public void setCostPrice(double price) {
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

        if (!(object instanceof VideoCamera)) {
            return false;
        }
        VideoCamera other = (VideoCamera) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VideoCamera{" + "identification =" + identification + ", name =" + name + ", code =" + code + '}';
    }


}
