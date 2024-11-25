package controller;

import model.Coche;

import java.io.*;
import java.util.ArrayList;


public class GestorFicheros {

    File file = new File("src/main/resources/coches.dat");
    ObjectInputStream objectInputStream = null;
    ObjectOutputStream objectOutputStream = null;
    BufferedWriter bufferedWriter = null;
    private ArrayList<Coche> coches = new ArrayList();

    public void leerFichero () {
        boolean eof = false;
        if (file.exists()) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                Coche coche=null;
                while (!eof){
                    coche = (Coche) objectInputStream.readObject();
                getCoches().add(coche);
                System.out.println(getCoches().size());}
            }catch (EOFException e){
                eof = true;
            }catch (IOException e) {
                eof=true;
                //System.out.println("Error en la lectura del fichero " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    objectInputStream.close();
                    System.out.println("Se han añadido al listado " + getCoches().size() + " coches.");
                    System.out.println("Fichero cerrado");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            System.out.println("Creado ArrayList vacío con " + getCoches().size() +" coches.");
        }
    }
    //Cree este metodo para generar el file que se lee para cargar el array
    public void escribirFichero () {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true));
            objectOutputStream.writeObject(new Coche(1,"1234ABC","SEAT","LEON","BLANCO"));
            objectOutputStream.writeObject(new Coche(2,"2345DEF","CUPRA","FORMENTOR","GRIS"));
            objectOutputStream.writeObject(new Coche(3,"6789JIH","TESLA","MODEL 3","ROJO"));
            objectOutputStream.writeObject(new Coche(4,"0123KLM","BMW","X5","AZUL"));
        } catch (IOException e) {
            System.out.println("Error en la escritura");
        }finally {
            try {
                objectOutputStream.close();
                System.out.println("Fichero creado");
            } catch (IOException | NullPointerException e) {
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void escribirFicheroCsv () {
        File fileCsv = new File("src/main/resources/coches.csv");
        Coche c = new Coche(0," "," "," "," ");
        for (int i = 0; i < getCoches().size(); i++) {
            int idcsv = getCoches().get(i).getId();
            c.setId(idcsv);
            String matriculacsv = getCoches().get(i).getMatricula();
            c.setMatricula(matriculacsv);
            String marcacsv = getCoches().get(i).getMarca();
            c.setMarca(marcacsv);
            String modelocsv = getCoches().get(i).getModelo();
            c.setModelo(modelocsv);
            String colorcsv = getCoches().get(i).getColor();
            c.setColor(colorcsv);

            try {
                bufferedWriter = new BufferedWriter(new FileWriter(fileCsv, true));
                bufferedWriter.write((c.getId()+";"+c.getMatricula()+";"+c.getMarca()+";"+c.getModelo()+";"+c.getColor()));
                bufferedWriter.newLine();
            } catch (IOException e) {
                System.out.println("Error al escribir en el fichero");
            }finally {
                try {
                    bufferedWriter.close();
                } catch (IOException | NullPointerException e) {
                    System.out.println("Error en el cerrado");
                }
            }
        }System.out.println("Fichero coches.csv creado");

    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }
}
