package com.shaka.todoapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shaka.todoapp.model.Category;
import com.shaka.todoapp.model.User;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @JsonIgnore
    private List<Category> categories;

    public static UserDto toEntity(UserDto userDto) {
        final User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCategories(
                userDto.getCategories() != null ? userDto.getCategories().stream().map(category -> toEntity()).collect(Collectors.toList()) : null
        );
        return userDto;
    }

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .categories(
                        user.getCategories() != null ? user.getCategories().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()) : null
                )
                .build();
    }
}
