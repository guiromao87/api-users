package br.com.estudos.api_users.controller.dto;

import br.com.estudos.api_users.model.User;

public record UserResponseDTO(String name, String email) {

    public UserResponseDTO(User user) {
        this(user.getName(),user.getEmail());
    }
}
