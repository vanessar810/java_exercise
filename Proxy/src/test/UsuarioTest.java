package test;

import model.Tipo;
import model.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ProxyCancion;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
 @Test
@DisplayName("Usuario free no puede descargar canciones")
void testearUsuarioFree(){
     Usuario  usuario = new Usuario(1, Tipo.Free);
     ProxyCancion proxyCancion = new ProxyCancion();
     String response = "No eres premium, suscribite";
     assertEquals(response,proxyCancion.Descargar(usuario));
 }
    @Test
    @DisplayName("Usuario premium puede descargar canciones")
    void testearUsuarioPremium(){
        Usuario  usuario = new Usuario(1, Tipo.Premium);
        ProxyCancion proxyCancion = new ProxyCancion();
        String response = "Descargando canción";
        assertEquals(response,proxyCancion.Descargar(usuario));
    }
}
