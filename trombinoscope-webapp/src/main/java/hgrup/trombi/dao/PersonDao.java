package hgrup.trombi.dao;

import hgrup.trombi.entity.Person;
import hgrup.trombi.entity.User;

import java.util.List;

public interface PersonDao {
    void save(Person user);
    List<Person> list();
    Person getPerson(Long id);
}
