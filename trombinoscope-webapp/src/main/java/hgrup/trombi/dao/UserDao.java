package hgrup.trombi.dao;

import hgrup.trombi.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> list();
}
