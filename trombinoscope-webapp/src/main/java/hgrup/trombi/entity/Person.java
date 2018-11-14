package hgrup.trombi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Persons")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "BORN")
    @Temporal(TemporalType.DATE)
    private Date born;

}
