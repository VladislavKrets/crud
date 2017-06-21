package ru.crud.app.service;

import ru.crud.app.dao.UserDao;
import ru.crud.app.model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;



    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(UserEntity usersEntity) {
        userDao.addUser(usersEntity);
    }

    @Transactional
    public void updateUser(UserEntity usersEntity) {
        userDao.updateUser(usersEntity);
    }

    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Transactional
    public UserEntity getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public List<UserEntity> listUsers(int recordsPerPage, int page) {
        return userDao.listUsers(recordsPerPage, page);
    }

    @Transactional
    public List<UserEntity> searchUsers(String userName) {
        return userDao.searchUsers(userName);
    }
    @Transactional

    public int getNumberOfRecords() {
        return userDao.getNumberOfRecords();
    }

}
