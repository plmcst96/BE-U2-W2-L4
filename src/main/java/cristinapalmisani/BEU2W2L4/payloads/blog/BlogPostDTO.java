package cristinapalmisani.BEU2W2L4.payloads.blog;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.UUID;

public record BlogPostDTO(
        @NotEmpty(message = "Il campo nome è obbligatorio!")
        @Size(min = 3, max = 30, message = "Il nome deve essere composto da 3 caratteri minimi")
        String category,
        @NotEmpty(message = "Il campo titolo è obbligatorio!")
        @Size(min = 10, max = 20, message = "Il titolo deve essere composto da 10 caratteri minimi")
        String title,
        @NotEmpty(message = "Il campo contenuto è obbligatorio!")
        @Size(min = 10, max = 100, message = "Il contenuto deve essere composto da 10 caratteri minimi")
        String content,
        @NotEmpty(message = "Il campo del tempo di lettura è obbligatorio!")
        @Max(120)
        double readingTime,
        @NotNull
        UUID authorId,
        @NotNull
        String cover
) {

}
