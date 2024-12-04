import java.io.Serializable;

abstract class Persona implements Serializable, Comparable<Persona>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Propiedades privadas
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;

    // Constructor sin parametros
    public Persona() {}

    // Constructor con parámetros
    public Persona(String nombre, String dni,  String direccion, String telefono) {
        this.nombre = nombre;
        this.dni=dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getter y Setter 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Metodo toString para representar el objeto como una cadena
    @Override
    public String toString() {
        return "Persona [Nombre=" + nombre + ", Dirección=" + direccion + ", Teléfono=" + telefono + "]";
    }

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	// compareto sobreescrito comparando nombre, orden alfabetico
    @Override
    public int compareTo(Persona otro) {
        // Comparar por edad
    	return this.nombre.compareTo(otro.nombre);
    
    }
}
