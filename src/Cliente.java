import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements Registrable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//relacon con mascota 
    private List<Animal> animales = new ArrayList<>();
    private List<Turno> turnos = new ArrayList<Turno>();
    
    public Cliente() {};

    
    // constructor con parametros
    public Cliente(String nombre, String dni, String direccion, String telefono) {
        super(nombre, dni, direccion, telefono); // llama al constructor de Persona
        this.animales = new ArrayList<>();
    }


	// getters y setters para lista de animales
    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    // mettodo para agregar un animal al cliente
    public void agregarAnimal(Animal animal) {
        this.animales.add(animal);
    }
    
    public List<Turno> getTurnos() {
        return turnos;
    }


    public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    
    @Override
    public void registrar() {
        System.out.println("El cliente " + getNombre() + " ha sido registrado.");
    }


    // metodo toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return super.toString() + " | Animales: " + animales.size();
    }

    
}
