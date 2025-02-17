package br.com.estudos.api_users.repository;

import br.com.estudos.api_users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
