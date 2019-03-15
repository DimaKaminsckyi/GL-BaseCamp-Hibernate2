package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Workers> workers;

    public Department() {
    }

    public Department(String name, Boolean status) {
        this.name = name;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setWorkers(List<Workers> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status ;
    }
}
