import java.io.*;
import java.util.*;

public class Guardar {

    // Método para guardar una lista de clientes en un archivo (serialización)
    public static void guardarClientes(List<Cliente> clientes, String ruta) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(clientes); // Serializa la lista de clientes
            System.out.println("Clientes guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes: " + e.getMessage());
        }
    }

    // Método para cargar una lista de clientes desde un archivo (deserialización)
    public static List<Cliente> cargarClientes(String ruta) {
        List<Cliente> clientes = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))) {
            clientes = (List<Cliente>) in.readObject(); // deserializa la lista de clientes
            System.out.println("Clientes cargados correctamente desde: " + ruta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los clientes: " + e.getMessage());
        }
        return clientes != null ? clientes : new ArrayList<>();
    }

    // metodo para guardar una lista de animales en un archivo (serialización)
    public static void guardarAnimales(List<Animal> animales, String ruta) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(animales); // Serializa la lista de animales
            System.out.println("Animales guardados correctamente en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar los animales: " + e.getMessage());
        }
    }

    // Método para cargar una lista de animales desde un archivo (deserialización)
    public static List<Animal> cargarAnimales(String ruta) {
        List<Animal> animales = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ruta))) {
            animales = (List<Animal>) in.readObject(); // Deserializa la lista de animales
            System.out.println("Animales cargados correctamente desde: " + ruta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los animales: " + e.getMessage());
        }
        return animales != null ? animales : new ArrayList<>();
    }
}
