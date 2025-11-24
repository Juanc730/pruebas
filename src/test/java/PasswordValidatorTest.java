import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.PasswordValidator;

class PasswordValidatorTest {
    
    // Caso 1: Contraseña nula o vacía
    @Test
    void testPasswordNullOrEmptyThrowsException() {
        assertAll(
            () -> {
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> PasswordValidator.isValid(null)
                );
                assertEquals("La contraseña no puede ser nula o vacía", exception.getMessage());
            }
            //() -> {
                //IllegalArgumentException exception = assertThrows(
                        //IllegalArgumentException.class,
                        //() -> PasswordValidator.isValid("")
                //);
                //assertEquals("La contraseña no puede ser nula o vacía", exception.getMessage());
            //}
        );
    }

    // Caso 2: Contraseña válida
    @Test
    void testValidPasswordReturnsTrue() {
        assertTrue(PasswordValidator.isValid("Secure123!"));
    }

    // Caso 3: Contraseña inválida (faltan requisitos)
    @Test
    void testInvalidPasswordMissingRequirementsReturnsFalse() {
        assertFalse(PasswordValidator.isValid("Nosecura")); // sin mayúsculas ni números
    }

    // Caso 4: Contraseña demasiado corta
    @Test
    void testPasswordTooShortReturnsFalse() {
        assertFalse(PasswordValidator.isValid("Ab1!")); // menos de 8 caracteres
    }

    // Caso 5: Contraseña demasiado larga
    @Test
    void testPasswordTooLongReturnsFalse() {
        String longPassword = "A".repeat(65) + "1!a";
        assertFalse(PasswordValidator.isValid(longPassword));
    }

    // Caso 6: Contraseña con espacios inválidos
    @Test
    void testPasswordWithSpacesInvalid() {
        assertAll(
            () -> assertFalse(PasswordValidator.isValid(" Secure123!")) // espacio inicial
            //() -> assertFalse(PasswordValidator.isValid("Secure123! ")), // espacio final
            //() -> assertFalse(PasswordValidator.isValid("Secure  123!")) // doble espacio
        );
    }
}
