package cristinapalmisani.BEU2W2L4.payloads.author;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AuthorDTO(
        @NotEmpty(message = "Il campo è obbligatorio")
        @Size(max = 25, min = 3, message = "non può avere più di 25 caratteri e meno di 3 caratteri ")
        String name,
        String surname, String email, LocalDate birthDate, String avatar) {
}
