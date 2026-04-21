package vitorino.pedro.hashcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vitorino.pedro.hashcode.dto.LoginRequestDTO;
import vitorino.pedro.hashcode.dto.LoginResponseDTO;
import vitorino.pedro.hashcode.dto.UserDTO;
import vitorino.pedro.hashcode.dto.UserRequestDTO;
import vitorino.pedro.hashcode.entity.UserModel;
import vitorino.pedro.hashcode.exception.InvalidPasswordException;
import vitorino.pedro.hashcode.exception.UserNotFoundException;
import vitorino.pedro.hashcode.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<UserDTO> findAll() {
        return repository.findAll().stream().map(UserDTO::from).toList();
    }

    public UserDTO findById(Long id) {
        UserModel user = repository.findById(id).orElseThrow(UserNotFoundException::new);

        return UserDTO.from(user);
    }

    public UserDTO save(UserRequestDTO request) {

        UserModel user = new UserModel();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        UserModel savedUser = repository.save(user);

        return UserDTO.from(savedUser);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        UserModel user = repository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        boolean valid = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!valid) {
            throw new InvalidPasswordException();
        }

        return new LoginResponseDTO("Login successful");
    }
}
