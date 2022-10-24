package dao;

import java.util.List;

public interface TrainerDaoInterface<T> {

T save (T t);

void update(T t);

void delete(int id);

T findById(int id);

List<T> findAll();

List<T> findByText(String text);

List<T> findByEmail(String text);

T findByEmailId(String text);
}

//TODO findByEmail returning Id

