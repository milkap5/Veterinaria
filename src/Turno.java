import java.io.Serializable;
import java.util.Date;
public class Turno implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fecha;
    private Cliente cliente;
	private String motivoTurno; 

	
    public Turno() {
    }

    public Turno(Date fecha, Cliente cliente, String motivoTurno) {
        this.fecha = fecha;
        this.cliente = cliente;
       // this.animal=animal;
        this.motivoTurno = motivoTurno;
    }
    
    public Turno(Date Nuevafecha, String NuevoMotivo) {
    	this.fecha=Nuevafecha;
    	this.motivoTurno=NuevoMotivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getMotivoTurno() {
        return motivoTurno;
    }

    public void setMotivoTurno(String motivoTurno) {
        this.motivoTurno = motivoTurno;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "fecha:" + fecha +
                ", ID Cliente=" + cliente.getDni() + 
                ", Motivo del Turno='" + motivoTurno + '\'' +
                '}';
    }
}