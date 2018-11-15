package hgrup.trombi.dao.impl;

import hgrup.trombi.dao.PersonPhotoDao;
import hgrup.trombi.entity.Person;
import hgrup.trombi.entity.PersonPhoto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PersonPhotoDaoImpl implements PersonPhotoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(PersonPhoto person) {
        sessionFactory.getCurrentSession().save(person);
        System.out.println(person.getId());
    }

    @Override
    public List<PersonPhoto> list() {
        @SuppressWarnings("unchecked")
        TypedQuery<PersonPhoto> query = sessionFactory.getCurrentSession().createQuery("from PersonPhoto");
        return query.getResultList();
    }

    @Override
    public PersonPhoto getPersonPhoto(Long photoId) {
        return sessionFactory.getCurrentSession().get(PersonPhoto.class, photoId);
    }

    @Override
    public List<PersonPhoto> getPersonPhotos(Person p) {
        @SuppressWarnings("unchecked")
        TypedQuery<PersonPhoto> query = sessionFactory.getCurrentSession().createQuery("from PersonPhoto where person = :p").setParameter("p", p);
        return query.getResultList();
    }
}
