package hgrup.trombi.service.impl;

import hgrup.trombi.dao.PersonDao;
import hgrup.trombi.dao.PersonPhotoDao;
import hgrup.trombi.dto.PersonDto;
import hgrup.trombi.dto.PersonPhotoDto;
import hgrup.trombi.entity.Person;
import hgrup.trombi.entity.PersonPhoto;
import hgrup.trombi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private PersonPhotoDao personPhotoDao;

    @Transactional
    public PersonDto save(PersonDto p) {
        Person entity = dtoToEntity(p);
        personDao.save(entity);
        return entityToDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PersonDto> list() {
        return personDao.list().stream().map(this::entityToDto).collect(toList());
    }

    @Transactional
    public PersonPhotoDto savePhoto(MultipartFile file, Long userId) {
        Person p = personDao.getPerson(userId);
        try {
            PersonPhoto photo = PersonPhoto.builder()
                    .person(p)
                    .fileName(file.getOriginalFilename())
                    .photo(file.getBytes())
                    .build();
            personPhotoDao.save(photo);
            return photoEntityToDto(photo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new PersonPhotoDto();
    }

    @Transactional(readOnly = true)
    public PersonPhotoDto getPhoto(Long photoId) {
        return photoEntityToDto(personPhotoDao.getPersonPhoto(photoId));
    }

    private Person dtoToEntity(PersonDto dto) {
        return Person.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .born(dto.getBorn())
                .build();
    }

    private PersonDto entityToDto(Person entity) {
        return PersonDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .born(entity.getBorn())
                .build();
    }

    private PersonPhotoDto photoEntityToDto(PersonPhoto entity) {
        return PersonPhotoDto.builder()
                .id(entity.getId())
                .fileName(entity.getFileName())
                .photo(entity.getPhoto())
                .personDto(entityToDto(entity.getPerson()))
                .build();
    }
}
