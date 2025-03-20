package service;

import model.Usuario;

public class ServicioDescarga implements PremiumService{
    @Override
    public String Descargar(Usuario usuario) {
        return  "Descargando canción";
    }
}
