package com.example.projectTestLibrary.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class Contact {
    @NotBlank
    @Pattern(regexp = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$", message = "W nazwie mogą być tylko litery")
    private String name;

    @NotBlank
    @Email(message = "To nie jest adres email lub błedny adres email")
    private String email;

    @NotBlank
    @Pattern(regexp = "(^\\+[0-9]{2}|^\\+[0-9]{2}\\(0\\)|^\\(\\+[0-9]{2}\\)\\(0\\)|^00[0-9]{2}|^0)([0-9]{9}$|[0-9\\-\\s]{10}$)",
            message = "To nie jest numer telefonu")
    private String phone;

    @NotBlank
    private String message;
}
