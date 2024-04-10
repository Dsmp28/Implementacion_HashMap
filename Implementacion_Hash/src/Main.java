
public class Main {
    public static void main(String[] args) {
        ManejadorUsuario manejadorUsuario = new ManejadorUsuario();
        manejadorUsuario.AgregarUsuario("Juan", "juan@example.com", "password123");
        manejadorUsuario.AgregarUsuario("Maria", "maria@example.com", "hello456");
        manejadorUsuario.AgregarUsuario("Pedro", "pedro@example.com", "abc789");
        manejadorUsuario.AgregarUsuario("Prueba", "prueba@example.com", "1234");

        System.out.println(manejadorUsuario.ObtenerUsuario("prueba@example.com"));
    }
}
