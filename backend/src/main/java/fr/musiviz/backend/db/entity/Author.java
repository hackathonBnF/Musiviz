package fr.musiviz.backend.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by kemkem on 11/25/17.
 */
@Entity
public class Author {
    private Long id;
    private String name;
    private String birthDate;

    public Author() {
    }

    public Author(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
