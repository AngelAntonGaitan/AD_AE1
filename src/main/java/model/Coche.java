package model;
import lombok.*;


import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Coche implements Serializable {

    private final static long serialVersionUID = 123456L;
    private int id;
    private String matricula, marca, modelo, color;
    public Coche(String matricula, String marca, String modelo, String color) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

}
