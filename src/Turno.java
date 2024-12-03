<<<<<<< HEAD
import java.time.LocalDate;
import java.util.Date;
=======
import java.sql.Date;

>>>>>>> 61e8d6521d73f18fb2ffdf88141a7d427b05ddf6
public class Turno {
    private Date fecha;
    private Cliente cliente;
    private String motivoTurno; // Renamed variable for consistency and clarity

    public Turno() {
    }

<<<<<<< HEAD

    public Turno(Date fecha, Cliente cliente, String motivoTurno) {
        this.fecha = fecha;
=======
    public Turno(java.util.Date fechaTurno, Cliente cliente, String motivoTurno) {
        this.fecha = (Date) fechaTurno;
>>>>>>> 61e8d6521d73f18fb2ffdf88141a7d427b05ddf6
        this.cliente = cliente;
        this.motivoTurno = motivoTurno;
    }

<<<<<<< HEAD
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
                "fecha=" + fecha +
                ", clienteId=" + cliente.getDni() + // Using cliente.getId() for better encapsulation
                ", motivoTurno='" + motivoTurno + '\'' +
                '}';
    }
=======
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
		return "Turno [Fecha=" + fecha + ", cliente=" + cliente + ", motivo del turno=" + motivoTurno;
	
	

	}
>>>>>>> 61e8d6521d73f18fb2ffdf88141a7d427b05ddf6
}