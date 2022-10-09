package service;

import dao.TrainerDao;
import dto.TrainerDto;
import filter.LoginInterceptor;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptors;
import model.TrainerEntity;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
    @Interceptors(LoginInterceptor.class)
    public TrainerDto save(TrainerDto trainerDto) {
        TrainerEntity trainerEntity = trainerDao.save(dtoToTrainer(trainerDto));
        return trainerDto(trainerEntity);
    }

    public void delete(int trainerId) {
        trainerDao.delete(trainerId);
    }

    public void update(TrainerEntity trainerEntity) {
        trainerDao.update(trainerEntity);
    }

    public List<TrainerDto> findAllTrainers() {
        return trainerDao.findAll().stream()
                .map(TrainerService::trainerDto)
                .collect(toList());
    }

    public TrainerEntity findById(int trainerId) {
        return trainerDao.findById(trainerId);
    }

    public List<TrainerDto> findByText(String textToFind) {
        return trainerDao.findByText(textToFind).stream()
                .map(TrainerService::trainerDto)
                .collect(toList());
    }

}
