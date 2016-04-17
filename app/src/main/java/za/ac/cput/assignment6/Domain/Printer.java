package za.ac.cput.assignment6.Domain;

import java.io.Serializable;

/**
 * Created by louisane Malu on 4/2/2016.
 */
//@Entity
public class Printer implements Serializable, Parts {
    private static final long serialVersionUID = 1L;
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String identification;
    private String name;
    //@Column(unique = true)
    private String taskNum;

    //@Embedded
    private Prints prints;

    private Printer(Builder b) {
        this.identification = b.identification;
        this.name = b.name;
        this.taskNum = b.taskNum;
        this.prints = b.prints;
    }
    private Printer() {
    }

    @Override
    public double price() {
        return 0;
    }
    public static class Builder {
        private String identification;
        private String name;
        private String taskNum;
        private Prints prints;

        public Builder(String taskNum) {
            this.taskNum = taskNum;
        }
        public Builder() {
        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder prints(Prints p) {
            prints = p;
            return this;
        }

        public Builder printer(Printer p) {
            identification = p.getId();
            name = p.getName();
            taskNum = p.getTaskId();
            prints = p.getPrints();
            return this;
        }

        public Printer build() {
            return new Printer(this);
        }
    }
    public String getId() {
        return identification;
    }
    public void setId(String id) {
        this.identification = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTaskId() {
        return taskNum;
    }
    public void setTaskId(String taskNum) {
        this.taskNum = taskNum;
    }

    public Prints getPrints() {
        return prints;
    }
    public void setPrints(Prints p) {
        prints = p;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Printer)) {
            return false;
        }
        Printer other = (Printer) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Photographer{" + "Id =" + identification+ ", Name =" + name + ", TaskID =" + taskNum + '}';
    }
}