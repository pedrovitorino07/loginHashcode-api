package vitorino.pedro.hashcode.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitorino.pedro.hashcode.dto.LoginRequestDTO;
import vitorino.pedro.hashcode.dto.LoginResponseDTO;
import vitorino.pedro.hashcode.dto.UserDTO;
import vitorino.pedro.hashcode.dto.UserRequestDTO;
import vitorino.pedro.hashcode.service.UserService;

import java.util.List;

@Tag(name = "Users", description = "Endpoints para gerenciamento de usuários")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os usuários")
    @GetMapping
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Buscar usuário por ID")
    @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Criar novo usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(request));
    }

    @Operation(summary = "Realizar login do usuário")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso")
    @ApiResponse(responseCode = "400", description = "Senha inválida")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(service.login(request));
    }

    @Operation(summary = "Deletar usuário por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
