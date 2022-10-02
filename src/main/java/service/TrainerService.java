package service;

import dao.TrainerDao;
import dto.TrainerDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import model.TrainerEntity;

@RequestScoped
public class TrainerService {

    @Inject
    private TrainerDao trainerDao;

    private static TrainerDto trainerDto(TrainerEntity trainerEntity) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setTrainerId(trainerEntity.getTrainerId());
        trainerDto.setName(trainerEntity.getName());
        trainerDto.setSurname(trainerEntity.getSurname());
        trainerDto.setEmail(trainerEntity.getEmail());
        trainerDto.setPhone(trainerEntity.getPhone());

        return trainerDto;
    }

    private static TrainerEntity dtoToTrainer(TrainerDto trainerDto) {
        TrainerEntity trainerEntity = new TrainerEntity();
        trainerEntity.setName(trainerDto.getName());
        trainerEntity.setSurname(trainerDto.getSurname());
        trainerEntity.setEmail(trainerDto.getEmail());
        trainerEntity.setPhone(trainerDto.getPhone());

        return trainerEntity;
    }

    public TrainerDto save(TrainerDto trainerDto) {
        TrainerEntity trainerEntity = trainerDao.save(dtoToTrainer(trainerDto));
        return trainerDto(trainerEntity);
}

}
