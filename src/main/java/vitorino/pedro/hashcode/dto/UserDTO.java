package vitorino.pedro.hashcode.dto;

import vitorino.pedro.hashcode.entity.UserModel;

public class UserDTO {

    private Long id;
    private String username;
    private String email;

    public UserDTO(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static UserDTO from(UserModel user) {
        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
