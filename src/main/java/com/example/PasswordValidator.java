
package com.example;

public class PasswordValidator {

    public static boolean isValid(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula o vacía");
        }

        // Validar longitud
        if (password.length() < 8 || password.length() > 64) {
            return false;
        }

        // Validar que no tenga espacios al inicio o final
        if (password.startsWith(" ") || password.endsWith(" ")) {
            return false;
        }

        // Validar que no tenga múltiples espacios consecutivos
        if (password.contains("  ")) {
            return false;
        }

        // Expresiones regulares para requisitos
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasLowercase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_\\-+=\\{\\}\\[\\]|\\\\:;\"'<>,.?/].*");
        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }
}
