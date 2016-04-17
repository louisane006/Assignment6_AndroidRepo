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
    private String identification;
    private String name;
    private String surname;
    private String taskNumber;
    //@OneToMany
    //@JoinColumn(name = "manager_id")
    private Task task;
    //@OneToOne
    //@JoinColumn(name = "manager_id")
    private SmartScreen screen;
    private Laptop laptop;

    private Manager(Builder b){
        this.name = b.name;
        surname = b.surname;
        this.taskNumber  = b.taskNumber;
        this.task = b.task;
        this.identification = b.identification;
        screen = b.screen;
        this.laptop = b.laptop;
    }
    public static class Builder{
        private String name;
        private String surname;
        private String taskNumber;
        private Task task;
        private SmartScreen screen;
        private Laptop laptop;
        private String identification;

        public Builder(String taskNumber) {
            this.taskNumber = taskNumber;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder task(Task task){
            this.task = task;
            return this;
        }
        public Builder id(String i){
            identification = i;
            return this;
        }
        public Builder smartscreen(SmartScreen s){
            this.screen = s;
            return this;
        }
        public Builder latop(Laptop p){
            laptop = p;
            return this;
        }
        public Builder manager(Manager m){
            identification = m.getId();
            screen = m.getScreen();
            name = m.getName();
            surname = m.getSurname();
            taskNumber = m.getTaskNumber();
            task = m.getTaskId();
            laptop= m.getLaptop();
            return this;
        }
        public Manager build(){
            return new Manager(this);
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

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    public Task getTaskId() {
        return task;
    }
    public void setTaskID(Task task) {
        this.task = task;
    }

    public SmartScreen getScreen() {
        return screen;
    }

    public void setBoard(SmartScreen board) {
        this.screen = board;
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