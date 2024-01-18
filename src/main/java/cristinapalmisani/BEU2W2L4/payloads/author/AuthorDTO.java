package cristinapalmisani.BEU2W2L4.payloads.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AuthorDTO(
        @NotEmpty(message = "Il campo è obbligatorio")
        @Size(max = 25, min = 3, message = "non può avere più di 25 caratteri e meno di 3 caratteri ")
        String name,
        @NotEmpty(message = "Il campo è obbligatorio")
        @Size(max = 25, min = 3, message = "non può avere più di 25 caratteri e meno di 3 caratteri ")
        String surname,
        @NotEmpty(message = "Il campo è obbligatorio")
        @Email
        String email,
        @NotEmpty(message = "Il campo è obbligatorio")
        LocalDate birthDate,
        @NotEmpty(message = "Il campo è obbligatorio")
        String avatar) {
}
