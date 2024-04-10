import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ManejadorUsuario {
    private final HashMap<String, Usuario> usuarios;

    public ManejadorUsuario() {
        this.usuarios = new HashMap<>();
    }

    public void AgregarUsuario(String nombre, String correo, String contrasena) {
        try{
            if (usuarios.containsKey(correo)) {
                throw new Exception("El correo ya está registrado.");
            }
            Usuario usuario = new Usuario(nombre, correo, encriptarSHA256(contrasena));
            usuarios.put(correo, usuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String ObtenerUsuario(String correo) {
        if (!usuarios.containsKey(correo)) {
            return "El usuario no existe.";
        }else {
            return usuarios.get(correo).toString();
        }
    }

    public static String encriptarSHA256(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
