package hgrup.trombi.service;

import hgrup.trombi.dto.PersonDto;
import hgrup.trombi.dto.PersonPhotoDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    PersonDto save(PersonDto p);

    List<PersonDto> list();

    PersonPhotoDto savePhoto(MultipartFile file, Long id);

    PersonPhotoDto getPhoto(Long photoId);
}
