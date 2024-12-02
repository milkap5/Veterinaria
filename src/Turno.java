import java.sql.Date;

public class Turno {
    private Date fecha;
    private Cliente cliente;
    private String motivoTurno; // Renamed variable for consistency and clarity

    public Turno() {
    }

    public Turno(java.util.Date fechaTurno, Cliente cliente, String motivoTurno) {
        this.fecha = (Date) fechaTurno;
        this.cliente = cliente;
        this.motivoTurno = motivoTurno;
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
		return "Turno [Fecha=" + fecha + ", cliente=" + cliente + ", motivo del turno=" + motivoTurno;
	
	

	}
}