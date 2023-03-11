package com.shaka.todoapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private ZonedDateTime createdDate;

    private boolean done;

    private boolean favorite;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
