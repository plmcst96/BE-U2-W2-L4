package cristinapalmisani.BEU2W2L4.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("Elemento con id " + id + " non trovato!");
    }
}
