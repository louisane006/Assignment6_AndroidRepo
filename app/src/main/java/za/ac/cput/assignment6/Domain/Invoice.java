package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/29/2016.
 */
public class Invoice implements Serializable, Payment {

    private static final long serialVersionUID = 1L;
   // @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private int invoiceNum;
    //@OneToOne
    //@JoinColumn(name = "invoice_id")
    private Cashier cashier;

    private Invoice(Builder b){
        invoiceNum = b.invoiceNum;
        cashier = b.cashier;
        identification = b.identification;
    }
    @Override
    public String paymentType() {
        return null;
    }
    @Override
    public double costForEverything() {
        return 0;
    }

    public static class Builder{
        private int invoiceNum;
        private Cashier cashier;
        private String identification;

        public Builder(int invoiceNum) {
            this.invoiceNum = invoiceNum;
        }
        public Builder(){

        }

        public Builder cashier(Cashier cashier){
            this.cashier = cashier;
            return this;
        }
        public Builder invoiceNum(int invoiceNum){
            this.invoiceNum = invoiceNum;
            return this;
        }
        public Builder invoice(Invoice inv){
            cashier = inv.getCashier();
            invoiceNum = inv.getInvoiceNum();
            identification= inv.getIdentification();
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
          if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Invoice[ Identification =" + identification + " ]";
    }
}
