package ru.crud.app.service;

import ru.crud.app.model.UserEntity;

import java.util.List;

public interface UserService {
    void addUser(UserEntity usersEntity);
    void updateUser(UserEntity usersEntity);
    void removeUser(int id);
    UserEntity getUserById(int id);
    List<UserEntity> listUsers(int recordsPerPage, int page);
    List<UserEntity> searchUsers(String userName);
    int getNumberOfRecords();

}
