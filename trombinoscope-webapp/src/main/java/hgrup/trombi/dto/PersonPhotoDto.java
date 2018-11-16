package hgrup.trombi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonPhotoDto {
    private Long id;
    private byte[] photo;
    private String fileName;
    private PersonDto personDto;
}
