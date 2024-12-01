import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Animal implements Serializable, Comparable<Animal> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
    private String especie;
    private int edad;
    private List<ProcedimientosMedicos> historialMedico;  // relacion con los procedimientos médicos


    // constructor sin parmetros
    public Animal() {}

    // constructor con parametros
    public Animal(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.historialMedico = new ArrayList<>();  // inicializo la lista de procedimientos
    }
    
    // getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void agregarProcedimiento(ProcedimientosMedicos procedimiento) {
        this.historialMedico.add(procedimiento);
    }

    public List<ProcedimientosMedicos> getHistorialMedico() {
        return historialMedico;
    }


    //metodo tostring sobreescrito 
    @Override
    public String toString() {
        return "Animal [Nombre=" + nombre + ", Especie=" + especie + ", Edad=" + edad + " años]";
    }

    // compareto sobreescrito comparando edad
    @Override
    public int compareTo(Animal otro) {
        // ci la edad es la misma, no hay cambio
        if (this.edad == otro.edad) {
            return 0;
        }
        // ci este animal es mayor (edad mayor), devuelve un valor positivo
        else if (this.edad > otro.edad) {
            return 1;
        }
        // ci este animal es menor (edad menor), devuelve un valor negativo
        else {
            return -1;
        }
    }
    
}
