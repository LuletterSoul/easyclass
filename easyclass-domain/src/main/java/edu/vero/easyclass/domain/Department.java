package edu.vero.easyclass.domain;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    @GeneratedValue(generator = "depId", strategy = GenerationType.IDENTITY)
    private int depId;
    private String depName;

    @Id
    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
