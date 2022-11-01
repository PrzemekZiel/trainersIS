package query;

import model.ActionType;

public class ActionCount {

    private ActionType actionType;
    private Integer sumOfActions;

    public ActionCount(ActionType actionType, Integer sumOfActions) {
        this.actionType = actionType;
        this.sumOfActions = sumOfActions;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public Integer getSumOfActions() {
        return sumOfActions;
    }

    public void setSumOfActions(Integer sumOfActions) {
        this.sumOfActions = sumOfActions;
    }

    @Override
    public String toString() {
        return "ActionCount{" +
                "actionType=" + actionType +
                ", sumOfActions=" + sumOfActions +
                '}';
    }
}
