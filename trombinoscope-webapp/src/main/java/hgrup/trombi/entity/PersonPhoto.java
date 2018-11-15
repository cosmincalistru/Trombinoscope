package hgrup.trombi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_PHOTOS")
@Getter
@Setter
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
}
