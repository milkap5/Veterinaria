import java.time.LocalDate;

public class Turno {
    private LocalDate fecha;
    private Cliente cliente;
    private String motivoTurno; // Renamed variable for consistency and clarity

    public Turno() {
    }

    public Turno(LocalDate fecha, Cliente cliente, String motivoTurno) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.motivoTurno = motivoTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
                ", clienteId=" + cliente.getId() + // Using cliente.getId() for better encapsulation
                ", motivoTurno='" + motivoTurno + '\'' +
                '}';
    }
}