package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 3/28/2016.
 */
public class Designer implements Serializable{

    private static final long serialVersionUID = 1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private String name;
    private String surname;
    private String taskNum;

   // @Embedded
    private Brochure broch;
    //@Embedded
    private Frame frame;

    /*@OneToOne
    @JoinColumn(name= "Designer_id")
    private Computer comp;*/

   // @OneToOne
    //@JoinColumn(name= "Designer_number")
    //private Laptop laptop;

    private Designer(Builder b){
        this.name = b.name;
        this.surname = b.surname;
        this.taskNum = b.taskNum;
        this.identification = b.identification;
        this.broch = b.broch;
        this.frame = b.frame;
        //this.laptop = b.laptop;
        //this.comp = b.comp;
    }
    public static class Builder{
        private String identification;
        private String name;
        private String surname;
        private String taskNum;
        private Brochure broch;
        private Frame frame;
        //private Laptop laptop;
        //private Computer comp;

        public Builder(String taskNum) {
            this.taskNum = taskNum;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder identification(String identification){
            this.identification = identification;
            return this;
        }
        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }
        /*public Builder laptop(Laptop laptop){
            this.laptop = laptop;
            return this;
        }*/
        /*public Builder computer(Computer comp){
            this.comp = comp;
            return this;
        }*/
        public Builder frame(Frame frame){
            this.frame = frame;
            return this;
        }
        public Builder brochure(Brochure broch){
            this.broch = broch;
            return this;
        }
        public Designer design(){
            return new Designer(this);
        }
        public Builder Designer(Designer designer){
            identification = designer.getIdentification();
            name = designer.getName();
            surname = designer.getSurname();
            taskNum = designer.getTaskNum();
            broch = designer.getBrochure();
            frame = designer.getFrame();
            /*comp = designer.getComputer();
            laptop = designer.getLaptop();*/
            return this;
        }
        public Designer build(){
            return new Designer(this);
        }
    }
    public void setIdentification(String identification) {
        this.identification = identification;
    }
    public String getIdentification() {
        return identification;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname() {
        return surname;
    }
    public void setTaskNumber(String taskNumber) {
        this.taskNum = taskNumber;
    }
    public String getTaskNum() {
        return taskNum;
    }
    public void setBrochure(Brochure broch) {
        this.broch = broch;
    }
    public Brochure getBrochure() {
        return broch;
    }
    public void setFrame(Frame frame) {
        this.frame = frame;
    }
    public Frame getFrame() {
        return frame;
    }
    /*public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
    public Laptop getLaptop() {
        return laptop;
    }
    public void setComputer(Computer comp) {
        this.comp = comp;
    }
    public Computer getComputer() {
        return comp;
    }*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Designer)) {
            return false;
        }
        Designer other = (Designer) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification)))
        {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Designer {" + "Identification =" + identification + ", Name =" + name + ", Surname =" + surname + ", Task Number =" + taskNum + '}';
    }
}
