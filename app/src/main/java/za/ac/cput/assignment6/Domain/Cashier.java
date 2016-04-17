package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/29/2016.
 */
//@Entity
public class Cashier implements Serializable{

        private static final long serialVersionUID = 1L;
        //@Id
        //@GeneratedValue(strategy = GenerationType.AUTO)
        private String identification;
        private String name;
        private String surname;
        private String taskNumber;

        private Cashier(Builder b){
            this.name = b.name;
            this.surname = b.surname;
            this.taskNumber = b.taskNumber;
            this.identification = b.identification;
        }
        public static class Builder{
            private String name;
            private String surname;
            private String taskNumber;
            private String identification;

            public Builder(String num) {
                taskNumber = num;
            }
            public Builder name(String name){
                this.name = name;
                return this;
            }
            public Builder surname(String surname){
                this.surname = surname;
                return this;
            }
            public Builder identification(String i){
                identification = i;
                return this;
            }
            public Builder cashier(Cashier cashier){
                name = cashier.getName();
                surname = cashier.getSurname();
                taskNumber = cashier.getTaskNumber();
                identification = cashier.getIdentification();
                return this;
            }
            public Cashier build(){
                return new Cashier(this);
            }
        }
        public String getIdentification() {
            return identification;
        }
        public void setIdentification(String identification) {
            this.identification = identification;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSurname() {
            return surname;
        }
        public void setSurname(String surname) {
        this.surname = surname;
          }
        public String getTaskNumber() {
            return taskNumber;
        }
        public void setTaskNumber(String taskNumber) {
            this.taskNumber = taskNumber;
        }
        @Override
        public int hashCode() {
            int hash = 0;
            hash += (identification != null ? identification.hashCode() : 0);
            return hash;
        }
        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Cashier)) {
                return false;
            }
            Cashier other = (Cashier) object;
            if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Cashier[ id=" + identification + " ]";
        }
}
