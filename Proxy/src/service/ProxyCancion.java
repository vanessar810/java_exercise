package service;

import model.Tipo;
import model.Usuario;

public class ProxyCancion implements PremiumService {
    ServicioDescarga servicioDescarga;

    public ProxyCancion() {
        this.servicioDescarga = new ServicioDescarga();
    }

    @Override
    public String Descargar(Usuario usuario) {
       if(usuario.getTipo().equals(Tipo.Free)){
           return "No eres premium, suscribite";
       }
       else
           return servicioDescarga.Descargar(usuario);
    }
}
