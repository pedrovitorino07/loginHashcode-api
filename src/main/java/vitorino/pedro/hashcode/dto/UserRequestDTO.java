package vitorino.pedro.hashcode.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @NotBlank
    @Schema(description = "Nome do usuário", example = "Pedro")
    private String username;

    @Email
    @NotBlank
    @Schema(description = "Email do usuário", example = "pedro@email.com")
    private String email;

    @Size(min = 6)
    @Schema(description = "Senha do usuário", example = "123456")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
