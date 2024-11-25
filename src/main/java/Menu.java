import controller.Concesionario;
import controller.GestorFicheros;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        GestorFicheros gf = new GestorFicheros();
        Concesionario concesionario = new Concesionario();
        //gf.escribirFichero(); Usado para crear el file coches.dat1G
        gf.leerFichero();

        int opcion = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(" ");
            System.out.println("GESTIÓN DE CONCESIONARIO");
            System.out.println(" ");
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por id");
            System.out.println("3. Consultar coche por id");
            System.out.println("4. Listado de coches");
            System.out.println("5. Exportar coches a archivo CSV");
            System.out.println("6. Terminar el programa");
            System.out.println("¿Qué opción quieres realizar?");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Añadir nuevo coche");
                    concesionario.agregarCoche(gf);
                    break;
                case 2:
                    System.out.println("Borrar coche por id");
                    concesionario.borrarCoche(gf);
                    break;
                case 3:
                    System.out.println("Consultar coche por id");
                    concesionario.consultarCoche(gf);
                    break;
                case 4:
                    System.out.println("Listado de coches");
                    concesionario.listadoCoches(gf);
                    break;
                case 5:
                    System.out.println("Exportar coches a archivo CSV");
                    gf.escribirFicheroCsv();
                    break;
            }
        } while (opcion != 6);
        System.out.println("Programa finalizado.");
    }
}
