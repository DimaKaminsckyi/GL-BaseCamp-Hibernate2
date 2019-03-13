package entity;

import javax.persistence.*;

@Entity
@Table(name = "workers")
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "age")
    private int age;

    @Enumerated(value = EnumType.STRING)
    private Availability availability;

    @Column(name = "full_name")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Workers() {
    }

    public Workers(int age, Availability availability, String fullName) {
        this.age = age;
        this.availability = availability;
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "age=" + age +
                ", availability=" + availability +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
