package br.com.estudos.api_users.controller;

import br.com.estudos.api_users.controller.dto.UserRequestDTO;
import br.com.estudos.api_users.controller.dto.UserResponseDTO;
import br.com.estudos.api_users.model.User;
import br.com.estudos.api_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> get() {
        var users = this.userRepository.findAll().stream().map(user -> new UserResponseDTO(user.getName(), user.getEmail())).toList();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getBy(@PathVariable Long id) {
        var optional = this.userRepository.findById(id);

        if(optional.isEmpty())
            throw new RuntimeException("Usuário não existe");

        return ResponseEntity.ok(new UserResponseDTO(optional.get()));
    }

    @PostMapping
    public void post(@RequestBody UserRequestDTO userDTO) {
        var user = new User(userDTO);
        this.userRepository.save(user);
    }
}
