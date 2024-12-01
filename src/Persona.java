import java.io.Serializable;

abstract class Persona implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Propiedades privadas
    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;

    // Constructor sin parámetros
    public Persona() {}

    // Constructor con parámetros
    public Persona(String nombre, String dni,  String direccion, String telefono) {
        this.nombre = nombre;
        this.dni=dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para dirección
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Getter y Setter para teléfono
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString para representar el objeto como una cadena
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
}
