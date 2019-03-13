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

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Workers> workers;

    public Department() {
    }

    public Department(String name, Boolean status) {
        this.name = name;
        this.status = status;
    }

    public void setWorkers(List<Workers> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
