package controller;

import model.Persona;

public class PersonaController {

    // Ordenar por edad (ascendente)
    public void ordenarPorEdad(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            for (int j = i + 1; j < personas.length; j++) {
                if (personas[i].getEdad() > personas[j].getEdad()) {
                    Persona aux = personas[i];
                    personas[i] = personas[j];
                    personas[j] = aux;
                }
            }
        }
    }

    // Búsqueda binaria con salida EXACTA como pide el docente
    public int busquedaBinaria(Persona[] personas, int edadBuscada) {
        int bajo = 0;
        int alto = personas.length - 1;
        int encontrado = -1;

        while (bajo <= alto) {

            // Imprimir subarreglo actual
            for (int i = bajo; i <= alto; i++) {
                System.out.print(personas[i].getEdad());
                if (i < alto) System.out.print(" | ");
            }
            System.out.println();

            int centro = (bajo + alto) / 2;
            int valorCentro = personas[centro].getEdad();

            System.out.println("bajo=" + bajo +
                               " alto=" + alto +
                               " centro=" + centro +
                               " valorCentro=" + valorCentro);

            if (valorCentro == edadBuscada) {
                System.out.println(" --> ENCONTRADO");
                encontrado = centro;

                // Buscar la primera persona con esa edad
                while (encontrado > 0 &&
                       personas[encontrado - 1].getEdad() == edadBuscada) {
                    encontrado--;
                }

                return encontrado;
            }

            if (edadBuscada > valorCentro) {
                System.out.println(" --> DERECHA");
                bajo = centro + 1;
            } else {
                System.out.println(" --> IZQUIERDA");
                alto = centro - 1;
            }

            System.out.println();
        }

        return -1;
    }
}
