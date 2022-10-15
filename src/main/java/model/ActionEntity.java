package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

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
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof ActionEntity)) return false;
        ActionEntity that = (ActionEntity) o;
        return Objects.equals(getActionId(), that.getActionId()) && Objects.equals(getAdminEmail(), that.getAdminEmail()) && Objects.equals(getUserIP(), that.getUserIP()) && Objects.equals(getActionType(), that.getActionType()) && Objects.equals(getUrlLink(), that.getUrlLink()) && Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActionId(), getAdminEmail(), getUserIP(), getActionType(), getUrlLink(), getDate());
    }

    @Override
    public String toString() {
        return "ActionEntity{" +
                "actionId=" + actionId +
                ", adminEmail='" + adminEmail + '\'' +
                ", userIP='" + userIP + '\'' +
                ", actionType=" + actionType +
                ", urlLink='" + urlLink + '\'' +
                ", date=" + date +
                '}';
    }


}
