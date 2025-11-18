
import java.util.Scanner;
import model.Persona;
import controller.PersonaController;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PersonaController controller = new PersonaController();

        System.out.print("Ingrese cantidad de Personas del listado: ");
        int n = sc.nextInt();
        sc.nextLine();

        Persona[] personas = new Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese Persona:");
            System.out.print(" Nombre: ");
            String nombre = sc.nextLine();

            int edad;
            do {
                System.out.print(" Edad: ");
                edad = sc.nextInt();
                sc.nextLine();
                if (edad < 0) {
                    System.out.println("La edad no puede ser negativa. Intente de nuevo.");
                }
            } while (edad < 0);

            personas[i] = new Persona(nombre, edad);
        }

        // ORDENAR usando el controlador
        controller.ordenarPorEdad(personas);

        System.out.print("Valor la persona de la edad: ");
        int edadBuscada = sc.nextInt();

        int index = controller.busquedaBinaria(personas, edadBuscada);

        if (index == -1) {
            System.out.println("No existe una persona con la edad " + edadBuscada);
        } else {
            System.out.println("La persona con la edad " + edadBuscada +
                               " es " + personas[index].getNombre());
        }
    }
}

