package co.com.calidad.screenplay.moduloCalidad.models;

import lombok.Data;

/**
 * Represents a login request containing the user's credentials.
 * This class is used to store the username and password needed to authenticate a user.
 * Lombok's @Data annotation is used to generate getters, setters, toString, equals, and hashCode methods automatically.
 */
@Data
public class Login {

    /**
     * The username of the user attempting to log in.
     * This is typically an email address or username used for authentication.
     */
    private String username;

    /**
     * The password of the user attempting to log in.
     * This is a sensitive field that should be handled securely.
     */
    private String password;
}
