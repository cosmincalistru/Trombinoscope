package hgrup.trombi.rest;

import hgrup.trombi.dto.PersonDto;
import hgrup.trombi.dto.PersonPhotoDto;
import hgrup.trombi.entity.Person;
import hgrup.trombi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

@RestController
@RequestMapping("person")
public class PersonRest {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public List<PersonDto> listPersons() {
        return personService.list();
    }

    @PostMapping("/")
    public void addPerson(@RequestBody PersonDto p) {
        System.out.println();

        personService.save(p);
    }

    @PostMapping("/{id}/photo/")
    public void addPhoto(@RequestParam("file") MultipartFile file, @PathVariable("id") Long personId) {
        personService.savePhoto(file, personId);
    }

    @GetMapping("/{userId}/photo/{photoId}")
    public void getPhoto(HttpServletResponse response, @PathVariable("userId") Long userId, @PathVariable("photoId") Long photoId) throws IOException {
        PersonPhotoDto photo = personService.getPhoto(photoId);

        String mimeType = URLConnection.guessContentTypeFromName(photo.getFileName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + photo.getFileName() + "\""));

        response.setContentLength(photo.getPhoto().length);

        InputStream inputStream = new ByteArrayInputStream(photo.getPhoto());

        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}
