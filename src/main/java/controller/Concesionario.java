package controller;

import model.Coche;

import java.util.Scanner;

public class Concesionario {

    Scanner sc = new Scanner(System.in);

    GestorFicheros ficheros = new GestorFicheros();


    public void agregarCoche (GestorFicheros ficheros) {
        Coche c = new Coche(0," "," "," "," ");
        System.out.println("Indica el id del coche que quieres agregar:");
        int idNuevo =(sc.nextInt());
        for (int i = 0; i < ficheros.getCoches().size(); i++) {
            if (ficheros.getCoches().get(i).getId() == idNuevo) {
                System.out.println("El id que has indicado ya existe y no puedes volver a utilizarlo. " +
                        "Proceso de añadir nuevo coche finalizado.");
                return;
            }else c.setId(idNuevo);
        }
        sc.nextLine();
        System.out.println("Indica la matricula del coche que quieres agregar:");
        String matriculaNueva=(sc.nextLine().toUpperCase());
        for (int i = 0; i < ficheros.getCoches().size(); i++) {
            if (ficheros.getCoches().get(i).getMatricula().equalsIgnoreCase(matriculaNueva)) {
                System.out.println("La matrícula que has indicado ya existe y no puedes volver a utilizarla. " +
                        "Proceso de añadir nuevo coche finalizado.");
                return;
            }else c.setMatricula(matriculaNueva);
        }
        System.out.println("Indica la marca del coche que quieres agregar:");
        c.setMarca(sc.nextLine().toUpperCase());
        System.out.println("Indica el modelo del coche que quieres agregar:");
        c.setModelo(sc.nextLine().toUpperCase());
        System.out.println("Indica el color del coche que quieres agregar:");
        c.setColor(sc.nextLine().toUpperCase());
        ficheros.getCoches().add(c);
        System.out.println("El coche ha sido agregado con estos datos: " + c.getId() + ", " + c.getMatricula()
                + ", " + c.getMarca() + ", " +c.getModelo() + ", " + c.getColor()+ "." );
        System.out.println("El ArrayList contiene " + ficheros.getCoches().size() +" coches.");

    }

    public void borrarCoche (GestorFicheros ficheros) {
        System.out.println("Indica el id del coche que quieres borrar:");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < ficheros.getCoches().size(); i++) {
            if (ficheros.getCoches().get(i).getId() == id) {
                ficheros.getCoches().remove(i);
                System.out.println("Coche eliminado correctamente.");
                return;
            }
        }
        System.out.println("No existe ningún coche con el id que has indicado. " +
                "Proceso de borrar coche finalizado.");
    }

    public void consultarCoche (GestorFicheros ficheros) {
        System.out.println("Indica el id del coche que quieres ver");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < ficheros.getCoches().size(); i++) {
            if (ficheros.getCoches().get(i).getId() == id) {
                System.out.println("Los datos del coche " + id + " son: " + ficheros.getCoches().get(i).getMatricula()
                        + " " + ficheros.getCoches().get(i).getMarca() + " " + ficheros.getCoches().get(i).getModelo()
                        + " " + ficheros.getCoches().get(i).getColor());
                return;
            }
        }
        System.out.println("No existe ningún coche con el id que has indicado." +
                "Proceso de consultar coche finalizado.");
    }

    public void listadoCoches(GestorFicheros ficheros) {
        if (ficheros.getCoches().isEmpty()){
            System.out.println("No hay ningún coche en el listado." +
                    "Proceso de listar coches finalizado.");
        }
        System.out.println("Los coches que hay en el listado son:");
        for (int i = 0; i < ficheros.getCoches().size(); i++) {
            System.out.println("Coche id: " + ficheros.getCoches().get(i).getId() + ", "
                    + "matricula: " + ficheros.getCoches().get(i).getMatricula() + ", "
                    +"marca: " + ficheros.getCoches().get(i).getMarca() + ", "
                    + "modelo: " + ficheros.getCoches().get(i).getModelo()  + ", "
                    + "color: " + ficheros.getCoches().get(i).getColor());
        }
        System.out.println("Listado de coches completado.");
    }

}

