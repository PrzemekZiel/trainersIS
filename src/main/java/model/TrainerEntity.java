package model;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;
import java.util.Objects;

@Entity
@Table(appliesTo = "trainer")
public class TrainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trainerId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String phone;

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

    public TrainerEntity() {
    }

    public TrainerEntity(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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
