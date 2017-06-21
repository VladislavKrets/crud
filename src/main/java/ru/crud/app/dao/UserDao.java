package ru.crud.app.dao;

import ru.crud.app.model.UserEntity;

import java.util.List;


public interface UserDao {
    public void addUser(UserEntity usersEntity);
    public void updateUser(UserEntity usersEntity);
    public void removeUser(int id);
    public UserEntity getUserById(int id);
    public List<UserEntity> listUsers(int recordsPerPage, int page);
    public List<UserEntity> searchUsers(String userName);
    public int getNumberOfRecords();

}
