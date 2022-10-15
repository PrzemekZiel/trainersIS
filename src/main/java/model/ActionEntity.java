package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "action", schema = "trainers")
public class ActionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actionId")
    private Integer actionId;
    @Basic
    @Column(name = "adminEmail")
    @Email
    @NotNull
    private String adminEmail;

    @Basic
    @Column(name = "userIP")
    private String userIP;
    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name = "actionType")
    private ActionType actionType;
    @Basic
    @Column(name = "urlLink")
    private String urlLink;
    @Basic
    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column
    private Integer trainerId;
//TODO mapping, getters, setters, hash, equals, toString etc.

    public ActionEntity() {

    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIp) {
        this.userIP = userIp;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }
}
