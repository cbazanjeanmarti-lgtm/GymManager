package factory;

public class UsuarioFactory {
    public static Usuario crearUsuario(String tipo, String id, String nombre, String email, String extra) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de usuario no puede ser nulo.");
        }
        switch (tipo.trim().toUpperCase()) {
            case "CLIENTE":
                return new Cliente(id, nombre, email, extra);
            case "ENTRENADOR":
                return new Entrenador(id, nombre, email, extra);
            default:
                throw new IllegalArgumentException("Tipo de usuario no reconocido: " + tipo);
        }
    }
}
