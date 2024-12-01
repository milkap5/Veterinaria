import java.io.Serializable;
import java.util.Date;

public class ProcedimientosMedicos implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date fecha;
    private String tipoProcedimiento;  // por ej "vacunacion" , "cirugia" etc
    private String descripcion;         // detalles del procedimiento

    public ProcedimientosMedicos() {
    	
    }
    public ProcedimientosMedicos(Date fecha, String tipoProcedimiento, String descripcion) {
        this.fecha = fecha;
        this.tipoProcedimiento = tipoProcedimiento;
        this.descripcion = descripcion;
    }

    // getters y setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoProcedimiento() {
        return tipoProcedimiento;
    }

    public void setTipoProcedimiento(String tipoProcedimiento) {
        this.tipoProcedimiento = tipoProcedimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Fecha: " + fecha.toString() + ", Procedimiento: " + tipoProcedimiento + ", Descripción: " + descripcion;
    }
}
