package net.crudapp.service;

import net.crudapp.model.UserEntity;

import java.util.List;

/**
 * Created by Slava on 19.07.2016.
 */
public interface UserService {
    public void addUser(UserEntity usersEntity);
    public void updateUser(UserEntity usersEntity);
    public void removeUser(int id);
    public UserEntity getUserById(int id);
    public List<UserEntity> listUsers(int recordsPerPage, int page);
    public List<UserEntity> searchUsers(String userName);
    public int getNumberOfRecords();

}
