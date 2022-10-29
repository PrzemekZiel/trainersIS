package service;

import dao.ActionDao;
import dto.ActionDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import model.ActionEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequestScoped
public class ActionService {

    @Inject
    ActionDao actionDao;

    private static ActionDto actionDto (ActionEntity actionEntity) {
        ActionDto actionDto = new ActionDto();
        actionDto.setActionId(actionEntity.getActionId());
        actionDto.setUserIP(actionEntity.getUserIP());
        actionDto.setActionType(actionEntity.getActionType());
        actionDto.setDate(actionEntity.getDate());
        actionDto.setUrlLink(actionEntity.getUrlLink());
        actionDto.setAdminEmail(actionEntity.getAdminEmail());

        return actionDto;
    }

    public List<ActionDto> findAllActions() {
        return actionDao.findAllActions().stream()
                .map(ActionService::actionDto)
                .collect(toList());
    }

}
