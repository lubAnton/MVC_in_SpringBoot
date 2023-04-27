package ru.luboshnikov.ppspringboot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.luboshnikov.ppspringboot.model.User;



import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public User showUser(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void editUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(showUser(id));
        entityManager.flush();
    }
}
