import java.time.LocalDate;

public class Turno {
    private LocalDate fecha;
    private Cliente _cliente;
    private string motivoturno;

    public Turno(){}


    public Turno(LocalDate fecha, Cliente _cliente, string motivoturno) {
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.motivoturno = motivoturno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public string getMotivoturno() {
        return motivoturno;
    }

    public void setMotivoturno(string motivoturno) {
        this.motivoturno = motivoturno;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Turno{" +
                "fecha=" + fecha +
                ", clienteId=" + clienteId +
                ", motivoturno=" + motivoturno +
                '}';
    }
}