package hgrup.trombi.dao;

import hgrup.trombi.entity.Person;
import hgrup.trombi.entity.PersonPhoto;

import java.util.List;

public interface PersonPhotoDao {
    void save(PersonPhoto user);
    List<PersonPhoto> list();
    List<PersonPhoto> getPersonPhotos(Person ps);
    PersonPhoto getPersonPhoto(Long photoId);
}
