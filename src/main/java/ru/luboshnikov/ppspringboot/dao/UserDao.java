package ru.luboshnikov.ppspringboot.dao;



import ru.luboshnikov.ppspringboot.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();
    void save(User user);
    User showUser(int id);
    void editUser(User user);
    void deleteUser(int id);

}
