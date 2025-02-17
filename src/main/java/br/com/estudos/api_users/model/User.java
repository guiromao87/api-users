package br.com.estudos.api_users.model;

import br.com.estudos.api_users.controller.dto.UserRequestDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String document;

    public User() {}

    public User(UserRequestDTO userDTO) {
        this.setName(userDTO.name());
        this.setEmail(userDTO.email());
        this.setDocument(userDTO.document());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
