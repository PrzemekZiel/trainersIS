package model;

import jakarta.inject.Named;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@Entity
@Named
@Table(name = "trainer", schema = "trainers")
@XmlRootElement
public class TrainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainerId;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Email(message = "Wrong email format!")
    @NotNull
    private String email;
    @NotNull
    private String phone;


    public TrainerEntity() {
    }

    public TrainerEntity(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainerEntity that)) return false;
        return trainerId.equals(that.trainerId) && name.equals(that.name) && surname.equals(that.surname) && email.equals(that.email) && phone.equals(that.phone);
    }

    @Override
    public int hashCode () {
        return Objects.hash(trainerId, name, surname, email, phone);
    }

}
