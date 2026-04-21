package vitorino.pedro.hashcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitorino.pedro.hashcode.entity.UserModel;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);
}
