package hgrup.trombi.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_PHOTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonPhoto {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column(name = "PHOTO")
    @Lob
    private byte[] photo;

    @Column(name = "URL")
    private String url;

    @Column(name = "FILENAME")
    private String fileName;
}
