package hgrup.trombi.service;

import hgrup.trombi.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}
