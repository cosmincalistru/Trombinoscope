package hgrup.trombi.dao.impl;

import hgrup.trombi.dao.PersonDao;
import hgrup.trombi.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public Person getPerson(Long id) {
        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public List<Person> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<Person> query = sessionFactory.getCurrentSession().createQuery("from Person");
        return query.getResultList();
    }
}
