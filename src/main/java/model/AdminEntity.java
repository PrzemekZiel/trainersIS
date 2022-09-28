package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Objects;

@Entity
@Table(name = "admin", schema = "trainers")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer adminId;

    @Column(name = "name")
    @Basic
    private String name;

    @Column(name = "surname")
    @Basic
    private String surname;

    @Column(name = "email")
    @Basic
    @Email
    private String email;

    @Column
    @Basic
    private String password;

    public AdminEntity() {
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminEntity that)) return false;
        return getAdminId().equals(that.getAdminId()) && getName().equals(that.getName()) && getSurname().equals(that.getSurname()) && getEmail().equals(that.getEmail()) && getPassword().equals(that.getPassword());

    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminId(), getName(), getSurname(), getEmail(), getPassword());

    }


}
