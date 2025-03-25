package dh.backend.test;

import dh.backend.model.Arbol;
import dh.backend.service.ArbolFactory;

public class ArbolFactoryTest {
    public static void main(String[] args) {
        for (int i=1;i <500;i++){
            Arbol arbol = ArbolFactory.plantarArbol("Ornamental");
            Arbol arbol2 = ArbolFactory.plantarArbol("Frutal");
        }
        System.out.println("cantidad de arboles creados: "+ Arbol.getContador());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
