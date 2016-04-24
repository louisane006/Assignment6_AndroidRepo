package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/1/2016.
 */
//@Entity
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
   // @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long identification;
    private String name;
    private String surname;
    private String taskNumber;

    public Manager(Builder b){
        this.name = b.name;
        surname = b.surname;
        this.taskNumber  = b.taskNumber;
        this.identification = b.identification;
    }
    public static class Builder{
        private String name;
        private String surname;
        private String taskNumber;
        private Long identification;

        public Builder(String taskNumber) {
            this.taskNumber = taskNumber;
        }

        public Builder() {

        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder id(Long i){
            identification = i;
            return this;
        }
        public Builder manager(Manager m){
            identification = m.getId();
            name = m.getName();
            surname = m.getSurname();
            taskNumber = m.getTaskNumber();
            return this;
        }
        public Manager build(){
            return new Manager(this);
        }

        public Builder taskNum(String string) {
            return this;
        }

        public Builder copy(Manager value) {
            this.identification = value.identification;
            this.name=value.name;
            this.surname=value.surname;
            this.taskNumber= value.taskNumber;
            return  this;
        }
    }
    public Long getId() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber){
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Manager[ identification =" + identification + " ]";
    }

}