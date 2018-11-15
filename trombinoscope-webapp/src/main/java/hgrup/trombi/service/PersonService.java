package hgrup.trombi.service;

import hgrup.trombi.dto.PersonDto;
import hgrup.trombi.dto.PersonPhotoDto;
import hgrup.trombi.entity.Person;
import hgrup.trombi.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    void save(PersonDto p);

    List<PersonDto> list();

    void savePhoto(MultipartFile file, Long id);

    PersonPhotoDto getPhoto(Long photoId);
}
