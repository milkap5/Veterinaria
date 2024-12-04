import java.io.*;
import java.util.*;

public class Guardar {

    // Metodo para guardar una lista de clientes en un archivo (serialización)
    public static void guardarClientes(List<Cliente> clientes, String ruta) {
    	
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(clientes); // Serializa la lista de clientes
            System.out.println("Clientes guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes: " + e.getMessage());
        }
    }
    
    //convierto errores en strings 
    //mejor manejo de errores 
    private static final String SUCCESS_MESSAGE = "Clientes cargados correctamente desde: ";
    private static final String ERROR_MESSAGE = "Error cargando clientes: ";

    public static List<Cliente> CargarCliente(String path) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return deserializeClients(in);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
            return new ArrayList<>();
        }
    }

    private static List<Cliente> deserializeClients(ObjectInputStream in) throws IOException, ClassNotFoundException {
        List<Cliente> clientes = (List<Cliente>) in.readObject();
        System.out.println(SUCCESS_MESSAGE + in);
        return clientes;
    }



    // metodo para guardar una lista de animales en un archivo (serializacion)
    public static void guardarAnimales(List<Animal> animales, String ruta) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(animales); // Serializa la lista de animales
            System.out.println("Animales guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar los animales: " + e.getMessage());
        }
    }

    // metodo para cargar una lista de animales desde un archivo (deserializacion)
    public static List<Animal> cargarAnimales(String ruta) {
        List<Animal> animales = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))) {
            animales = (List<Animal>) in.readObject(); // deserializa la lista de animales
            System.out.println("Animales cargados correctamente desde: " + ruta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los animales: " + e.getMessage());
        }
        return animales != null ? animales : new ArrayList<>();
    }
    
    public static List<Turno> cargarTurnos(String ruta){
    	List<Turno> turno=null; 
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))){
    		turno =(List<Turno>) in.readObject();
    		System.out.println("Se cargaron los turnos con éxito!");
    	}catch(IOException | ClassNotFoundException e) {
    		System.out.println("Error al cargar los turnos: "+e.getMessage());
    	}
    	return turno != null ? turno : new ArrayList<Turno>();
    }
    
    public static void guardarTurno(List<Turno> turno, String ruta){
    	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))){
    		out.writeObject(turno);
    		System.out.println("Se guardaron los turnos correctamente en:" +ruta);
    	}catch(IOException e) {
    		System.out.println("Hubo un error al guardar los turnos" +e.getMessage());
    	}
    }
    
    public static List<ProcedimientosMedicos> cargarProcedimientos(String ruta){
    	List<ProcedimientosMedicos> procedimiento=null;
    	try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))){
    		procedimiento =(List<ProcedimientosMedicos>) in.readObject();
    		System.out.println("Se cargaron los turnos con éxito!");
    	}catch(IOException | ClassNotFoundException e) {
    		System.out.println("Error al cargar los procedimientos: "+e.getMessage());
    	}
    	return procedimiento != null ? procedimiento : new ArrayList<ProcedimientosMedicos>();
    }
    
    public static void guardarProcedimiento(List<ProcedimientosMedicos> procedimientos, String ruta) {
    	try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))){
    		out.writeObject(procedimientos);
    		System.out.println("Se guardo el historial medico correctamente en:" +ruta);
    	}catch(IOException e) {
    		System.out.println("Hubo un error al guardar el historial medico" +e.getMessage());
    	}
    }
}
