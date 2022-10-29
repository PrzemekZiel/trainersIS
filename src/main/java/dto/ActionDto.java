package dto;

import model.ActionType;

import java.time.LocalDateTime;

public class ActionDto {

    private Integer actionId;
    private String userIP;
    private ActionType actionType;
    private String urlLink;
    private String adminEmail;
    private LocalDateTime date;

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String uesrIP) {
        this.userIP = uesrIP;
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

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ActionDto{" +
                "actionId=" + actionId +
                ", userIP='" + userIP + '\'' +
                ", actionType=" + actionType +
                ", urlLink='" + urlLink + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", date=" + date +
                '}';
    }
}
