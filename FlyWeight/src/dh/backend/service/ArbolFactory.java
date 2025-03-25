package dh.backend.service;

import dh.backend.model.Arbol;

import java.util.HashMap;

public class ArbolFactory {
    private static HashMap<String, Arbol> JardinArboles = new HashMap<>();
    public static Arbol plantarArbol(String tipo){
        Arbol arbol = JardinArboles.get(tipo);
        if(arbol == null){
            switch (tipo){
                case "Ornamental":{
                    arbol = new Arbol(tipo, 200,400,"verde");
                    break;
                }
                case "Frutal":{
                    arbol = new Arbol(tipo,500,300,"rojo");
                    break;
                }
                case "Floral":{
                    arbol = new Arbol(tipo,100,200,"celeste");
                    break;
                }
                default:
                    System.out.println("No existe el tipo de arbol");
            }
            System.out.println("Arbol creado "+ arbol);
            JardinArboles.put(tipo, arbol);
        } else {
            System.out.println("Arbol encontrado " + arbol);
        }
        return arbol;
    }
}
