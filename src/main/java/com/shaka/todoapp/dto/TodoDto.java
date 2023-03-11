package com.shaka.todoapp.dto;

import com.shaka.todoapp.model.Todo;
import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private Long id;

    private String title;

    private String description;

    private ZonedDateTime createdDate;

    private boolean done;

    private boolean favorite;

    private CategoryDto category;

    public static TodoDto toEntity(TodoDto todoDto) {
        final Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setFavorite(todoDto.isFavorite());
        todo.setDone(todoDto.isDone());
        todo.setCreatedDate(ZonedDateTime.now());
//        todo.setCategory(CategoryDto.toEntity(todoDto.getCategory()));
        return todoDto;
    }

    public static TodoDto fromEntity(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .createdDate(todo.getCreatedDate())
                .done(todo.isDone())
                .favorite(todo.isFavorite())
//                .category(CategoryDto.fromEntity(todo.getCategory()))
                .build();
    }
}
