package com.example.primesourcetodo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(nullable=false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean complete;

}
