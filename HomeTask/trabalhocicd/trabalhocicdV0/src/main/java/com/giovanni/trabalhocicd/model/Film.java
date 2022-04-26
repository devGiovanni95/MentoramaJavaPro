package com.giovanni.trabalhocicd.model;


import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Film {

    @GeneratedValue
    @Id
    private int id;

   // @Column(name = "name");
    private String name;

   // @Column(name = "nota");
    private int note;

   // @Column(name = "Commit");
    private String commit;

   // @Column(name = "idUser");
    private int user;

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nota=" + note +
                ", commit='" + commit + '\'' +
                ", user=" + user +
                '}';
    }
}
