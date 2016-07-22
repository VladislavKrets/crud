package net.crudapp.dao;

import net.crudapp.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Slava on 19.07.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addUser(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(userEntity);
        logger.info("User added " + userEntity);
    }

    public void updateUser(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(userEntity);
        logger.info("User updated " + userEntity);

    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserEntity userEntity = getUserById(id);
        if (userEntity != null) {
            session.delete(userEntity);
        }
        logger.info("User deleted " + userEntity);
    }

    public UserEntity getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserEntity userEntity = (UserEntity) session.load(UserEntity.class, id);
        logger.info("User loaded " + userEntity);

        return userEntity;
    }

    public List<UserEntity> listUsers(int recordsPerPage, int page) {
        Session session = sessionFactory.getCurrentSession();
        List<UserEntity> userEntityList = session.createQuery("from UserEntity ")
                .setFirstResult(recordsPerPage*page)
                .setMaxResults(recordsPerPage)
                .list();
        for(UserEntity user: userEntityList){
            logger.info("User list " + user);
        }
        return userEntityList;
    }

    public List<UserEntity> searchUsers(String userName) {
        Session session = sessionFactory.getCurrentSession();
        List<UserEntity> userEntityList = session.createQuery("from UserEntity where name like :userName").setParameter("userName", "%" + userName + "%").list();
        for(UserEntity user: userEntityList){
            logger.info("User list " + user);
        }
        return userEntityList;
    }

    public int getNumberOfRecords() {
        Session session = sessionFactory.getCurrentSession();
        List<UserEntity> userEntityList = session.createQuery("from UserEntity ").list();
        return userEntityList.size();
    }

}
