package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/2/2016.
 */
//@Entity
public class Credit implements Serializable, Payment {

    private static final long serialVersionUID = 1L;
    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private double amount;
    private String name;
    private Credit(Builder b){
        identification = b.identification;
        name = b.name;
        amount = b.amount;
    }
    public static class Builder{
        private String identification;
        private double amount;
        private String name;

        public Builder(String name) {
            this.name = name;
        }

        public Builder amount(double a){
            amount = a;
            return this;
        }

        public Builder identification(String i){
            identification = i;
            return this;

        }
        public Builder credit(Credit c){
            amount = c.getAmount();
            name = c.getName();
            identification = c.getIdentification();
            return this;
        }
        public Credit build(){
            return new Credit(this);
        }
    }
    public String getIdentification() {
        return identification;
    }
    public void setId(String identification) {
        this.identification = identification;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Credit)) {
            return false;
        }
        Credit other = (Credit) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Credit[ Id =" + identification + " ]";
    }
    @Override
    public String paymentType() {
        return "Credit";
    }
    @Override
    public double costForEverything() {
        return 0;
    }
}