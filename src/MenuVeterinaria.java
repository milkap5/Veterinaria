import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//Clase MENU VETERINARIA donde estan todos los metodos para realizar las operaciones ABM correctamente.
public class MenuVeterinaria extends Guardar{

private static List<Animal> animales = new ArrayList<>();
private static List<Cliente> clientes = new ArrayList<>();
private static List<String> turnos = new ArrayList<>(); // Lista de turnos como ejemplo
private static Scanner scanner = new Scanner(System.in);

public static void mostrarMenu() {
	
	//traigo los datos del archivo .dat CLIENTES 
	try{
	CargarCliente("clientes.dat");
	}catch(Exception e) {
		System.out.println("Error al cargar el archivo de clientes!"+e);
	}
	
    System.out.println("\n************Bienvenido a Veterinaria Patitas!************");
    System.out.println("Que querés hacer? Elegí una opcion:\n");
    System.out.println("1. Añadir Cliente");
    System.out.println("2. Otorgar un Turno");
    System.out.println("3. Listar Clientes");
    System.out.println("4. Procedimientos Médicos");
    System.out.println("5. Gestión de Turnos");
    System.out.println("6. Añadir mascota");
    System.out.println("7. Salir");
    System.out.print("Selecciona una opción: ");
}

public static int obtenerOpcion() {
    int opcion = -1;
    try {
        opcion = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingresá un número.");
    }
    return opcion;
}

public static void ejecutarOpcion(int opcion) {
    switch (opcion) {
        case 1:
            añadirCliente();
            break;
        case 2:
            otorgarTurno();
            break;
        case 3:
            listarClientes();
            break;
        case 4:
            registrarProcedimientoMedico();
            break;
        case 5:
            gestionTurnos();
            break;
        case 6:
        	añadirMascota();
        	break;
    	case 7:
        System.out.println("¡Gracias por venir a Veterinaria Patitas! Cerrando app...");
        System.out.println("¿Quieres guardar los cambios antes de salir? (s/n)");
        String salir = scanner.nextLine().toLowerCase();
        
        if (salir.equals("s")) {
            guardarClientes(clientes, "clientes.dat");  // Guardar antes de salir
            System.out.println("Saliendo del programa...");
            System.exit(0);//sale de la app
        }else {return;}
        break;
        default:
            System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }

public static void añadirCliente(){
    	
    System.out.println("\n************ Añadir Cliente ************");
    System.out.println("Por favor, a contnuacion ingrese los datos del cliente");
    
    try {
        String nombreStrg;
        String dniStrg;
        String direccionStrg;
        String telefonoStrg;

        System.out.print("Nombre: ");
        nombreStrg = scanner.nextLine().toUpperCase();
        System.out.println("DNI: ");
        dniStrg = scanner.nextLine().toUpperCase();
        System.out.print("Dirección: ");
        direccionStrg = scanner.nextLine().toUpperCase();
        System.out.print("Teléfono: ");
        telefonoStrg = scanner.nextLine().toUpperCase();

        Cliente cliente = new Cliente(nombreStrg, dniStrg, direccionStrg, telefonoStrg);

        // Ahora preguntamos si desea agregar mascotas
        String agregarMascotas;
        do {
            System.out.print("¿Desea agregar una mascota al cliente? (s/n): ");
            agregarMascotas = scanner.nextLine().toLowerCase();

            if (agregarMascotas.equals("s")) {
                System.out.print("Nombre de la mascota: ");
                String nombreMascota = scanner.nextLine();
                System.out.print("Qué animal es?(Gato, perro, cobayo..");
                String especieMascota = scanner.nextLine();
                System.out.print("Edad de la mascota: ");
                int edadMascota = Integer.parseInt(scanner.nextLine());

                Animal mascota = new Animal(nombreMascota, especieMascota, edadMascota);
                cliente.agregarAnimal(mascota);
            }
        } while (agregarMascotas.equals("s"));

        // verifico que el cliente tiene mascotas
        if (cliente.getAnimales().isEmpty()) {
            System.out.println("Este cliente no tiene mascotas.");
        } else {
            System.out.println("Mascotas agregadas al cliente.");
        }

        clientes.add(cliente);
        guardarClientes(clientes, "clientes.dat");  //guarda los cambios al archivo desp de agregar

        System.out.println("Cliente " + nombreStrg + " añadido correctamente.");
    } catch (Exception e) {
        System.out.println("Hubo un error. Intenta de nuevo.");
    }
}
/*
private static void guardarClientesEnArchivo() {
   try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
    // guardo la lista completa de clientes
    oos.writeObject(clientes);
    System.out.println("Clientes guardados correctamente en el archivo.");
  } catch (IOException e) {
        System.out.println("Hubo un error al guardar los datos de los clientes. " + e.getMessage());
    }
}
*/
//metodo que trae todos los clientes del archivo .dat 

    /*
    private static void cargarClientes() {
	File archivo = new File("clientes.dat");

// compruebo si el archivo existe
if (archivo.exists()) {
    //intento leer los clientes desde el archivo
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
        //compruebo si el archivo no está vacío
        if (archivo.length() == 0) {
            System.out.println("El archivo está vacío. No se cargaron clientes.");
            return;
        }

        //leo los clientes del archivo y asignarlos a la lista
        clientes = (List<Cliente>) ois.readObject();
        System.out.println("Clientes cargados correctamente desde el archivo.");

    } catch (EOFException e) {
        //caso en el q el archivo está vacío
        System.out.println("El archivo está vacío. No se pudieron cargar clientes.");
    } catch (IOException | ClassNotFoundException e) {
        //error general de lectura o de tipo de objeto
        System.out.println("Error al cargar los clientes desde el archivo. " + e.getMessage());
    }
} else {
    System.out.println("El archivo de clientes no existe.");
    }
}
*/
//TODO
    
    

    String[] fechasInvalidas = {
            "32/01/2023", "30/02/2023", "31/04/2023", "31/06/2023", "31/09/2023", "31/11/2023",
            "29/02/2021", // Año no bisiesto
            "31/02/2023", "31/02/2024", // Febrero no tiene 31 días
            "00/01/2023", "01/13/2023"  // Meses inválidos
    };    
    
    
    
public static void otorgarTurno(){

    System.out.println("\n************ Otorgar Turno ************ ");
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }

    System.out.println("Clientes registrados:");

    for (int i = 0; i < clientes.size(); i++) {
        System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
    }

    System.out.print("Selecciona el cliente para otorgar el turno: ");
    int indiceCliente = Integer.parseInt(scanner.nextLine()) - 1;

    if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
        System.out.println("Cliente no válido.");
        return;
    }
    //Guardar datos del cliente seleccionado

// Obtener el cliente seleccionado
    Cliente clienteSeleccionado = clientes.get(indiceCliente);
    
    //INGRESAR FECHA Y PARSEARLA 
    System.out.println("ingrese el motivo del turno");
    String motivo = scanner.nextLine();
    System.out.println("ingresar fecha en formato DD/MM/YYYY");
    System.out.println("DIA: ");
    String dia = scanner.nextLine();
    System.out.println("MES:")
    String mes = scanner.nextLine();
    System.out.println("AÑO:")
    String anio = scanner.nextLine();
    
    //Parseo
    
    try {
        // Create a date string from user inputs
        String fechaStr = dia + "/" + mes + "/" + anio;

        // Define the date format to parse
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Disable leniency to catch invalid dates

        // Convert string to date
        Date fechaTurno = dateFormat.parse(fechaStr);

        // Check if the date is valid by comparing it to the invalid dates array
        if (Arrays.asList(fechasInvalidas).contains(fechaStr)) {
            System.out.println("La fecha ingresada es inválida.");
        } else {
            System.out.println("Fecha del turno otorgado: " + fechaTurno);
            List<Turnos> turnos=new arraylist();
            Turnos turno=new Turnos(fechaTurno,clienteSeleccionado,motivo)
            turnos.add(turnos);
            System.out.println(turnos);
        }
    } catch (ParseException e) {
        System.out.println("Formato de fecha incorrecto. Por favor, intenta de nuevo.");
    }
    
  


    
}



//TODO
public static void listarClientes() {
    System.out.println("\n************ Listar Clientes ************");

    // verifico si la lista de clientes está vacía
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }

    // imprimo la lista de clientes
    for (int i = 0; i < clientes.size(); i++) {
        System.out.println((i + 1) + ". Cliente " + clientes.get(i));  //cliente con índice
    }

    // pido al usuario que seleccione un cliente
    System.out.print("\nSelecciona el número del cliente para modificar o eliminar (Presione 0 para cancelar): ");
    
    // guardo la entrada del usuario y validar que sea un numero entero
    int indiceCliente = -1;
    try {
        indiceCliente = Integer.parseInt(scanner.nextLine()) - 1; // resto 1 
    } catch (NumberFormatException e) {
        System.out.println("Por favor, ingresa un número válido.");
        return;
    }

    if (indiceCliente == -1) {
        return;  // si el usuaro ingreso cero cancelo
    }

    // verifico si el indice es valido
    if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
        System.out.println("Cliente no válido.");
        return;
    }

    //cliente seleccionado
    Cliente clienteSeleccionado = clientes.get(indiceCliente);
    System.out.println("\nCliente seleccionado: " + clienteSeleccionado);
    System.out.println("1. Modificar Cliente");
    System.out.println("2. Eliminar Cliente");
    System.out.print("Selecciona una opción: ");
    
    // guardo opcion del usuario
    int opcionModificar = -1;
    try {
        opcionModificar = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Opción no válida.");
        return;
    }

    
    switch (opcionModificar) {
        case 1:
            modificarCliente(clienteSeleccionado); 
            break;
        case 2:
            eliminarCliente(clienteSeleccionado); 
            break;
        default:
            System.out.println("Opción no válida.");
    }

    //cuadno se modificaron o eliminaron los clientes, guardo la lista actualizada
        guardarClientes(clientes, "clientes.dat");
    }

  
public static void modificarCliente(Cliente cliente) {
        System.out.println("\n************ Modificar Cliente ************");
    System.out.print("Nuevo nombre: ");
    String nombre = scanner.nextLine().toUpperCase();
    System.out.print("Nueva dirección: ");
    String direccion = scanner.nextLine().toUpperCase();
    System.out.print("Nuevo teléfono: ");
    String telefono = scanner.nextLine();
    
    cliente.setNombre(nombre);
    cliente.setDireccion(direccion);
    cliente.setTelefono(telefono);
    System.out.println("Cliente modificado correctamente.");
}

public static void eliminarCliente(Cliente cliente) {
    clientes.remove(cliente);
    System.out.println("Cliente eliminado correctamente.");
}

//TODO
public static void registrarProcedimientoMedico() {
    System.out.println("\n************ Procedimientos Médicos ************");
    System.out.println("Sobre que cliente y animal quiere ver procedimientos medicos?");
    
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }else {
    // listao clientes y sus animales
    for (int i = 0; i < clientes.size(); i++) {
        //si el cliente no tiene mascotas
        if(clientes.get(i).getAnimales().isEmpty()) {
        	System.out.println((i + 1) + ". " + "Cliente: "+clientes.get(i).getNombre()+" | No tiene mascotas");
        }else {
        	System.out.println((i + 1) + ". " + "Cliente: "+clientes.get(i).getNombre()+" | Animal: "+clientes.get(i).getAnimales());
        }
     }
    }
    
    System.out.print("Selecciona el animal (número): ");
    int indiceAnimalito = Integer.parseInt(scanner.nextLine()) - 1;
    
    if (indiceAnimalito < 0 || indiceAnimalito >= clientes.size()) {
        System.out.println("Cliente no válido.");
        return;
    }
//TODO
    File procedimientos = new File("procedimientos.dat");
 // compruebo si el archivo existe
    if (procedimientos.exists()) {
        //intento leer los clientes desde el archivo
    	System.out.println("\n************ Añadir Procedimiento Médico ************");
        try {
            System.out.print("Tipo de Procedimiento (Ejemplo: Vacunación, Cirugía): ");
            String tipoProcedimiento = scanner.nextLine();

            System.out.print("Descripción del Procedimiento: ");
            String descripcion = scanner.nextLine();

            // creo un objeto ProcedimientoMedico con la fecha actual
            ProcedimientosMedicos procedimiento = new ProcedimientosMedicos(new Date(), tipoProcedimiento, descripcion);

            // agrego el procedimiento al historial de la mascota
            ((Animal) animales).agregarProcedimiento(procedimiento);

            System.out.println("Procedimiento médico agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Hubo un error al agregar el procedimiento médico: " + e.getMessage());
        }
    } else {
        System.out.println("El archivo de procedimientos medicos no existe.");
        }
}


public static void gestionTurnos() {
    	
	System.out.println("\n************ Gestión de Turnos ************");
if (turnos.isEmpty()) {
	System.out.println("No hay turnos registrados.");
    return;
}

// Listar turnos
for (int i = 0; i < turnos.size(); i++) {
System.out.println((i + 1) + ". " + turnos.get(i));
}

System.out.print("Selecciona el turno para eliminar o modificar (0 para cancelar): ");
int indiceTurno = Integer.parseInt(scanner.nextLine()) - 1;

if (indiceTurno == -1) {
	return;
}

if (indiceTurno < 0 || indiceTurno >= turnos.size()) {
    System.out.println("Turno no válido.");
    return;
}

String turnoSeleccionado = turnos.get(indiceTurno);
System.out.println("\nTurno seleccionado: " + turnoSeleccionado);
System.out.println("1. Modificar Turno");
System.out.println("2. Eliminar Turno");
System.out.print("Selecciona una opción: ");

int opcionTurno = Integer.parseInt(scanner.nextLine());

switch (opcionTurno) {
    case 1:
        modificarTurno(indiceTurno);
        break;
    case 2:
        eliminarTurno(indiceTurno);
        break;
    default:
        System.out.println("Opción no válida.");
    }
}

//TODO !!!!!
public static void modificarTurno(int indiceTurno) {
    	
	System.out.println("\n************ Modificar Turno ************");
	System.out.print("Nueva fecha del turno (DD/MM/YYYY)");
	String nuevaFecha = scanner.nextLine();
	System.out.print("Nuevo motivo del turno: ");
	String nuevoMotivo = scanner.nextLine();
	
	String nuevoTurno = "Fecha: " + nuevaFecha + " | Motivo: " + nuevoMotivo;
	turnos.set(indiceTurno, nuevoTurno);
	System.out.println("Turno modificado correctamente.");
}

public static void eliminarTurno(int indiceTurno) {
    turnos.remove(indiceTurno);
    System.out.println("Turno eliminado correctamente.");
}
private static void añadirMascota() {
	
	if(clientes.isEmpty()) {
		System.out.println("Oops! No hay clientes en el archivo!");
		return;
	}
    System.out.println("\n************ Añadir Mascota ************");
    
    if (clientes.isEmpty()) {
        System.out.println("No hay clientes registrados. Primero tenes qeu añadir un cliente.");
        return;
    }

    // Listar clientes
    System.out.println("Clientes registrados:");
    for (int i = 0; i < clientes.size(); i++) {
        System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
    }

    System.out.print("Selecciona el cliente al que deseas agregar la mascota (número): ");
    int indiceCliente = Integer.parseInt(scanner.nextLine()) - 1;

    if (indiceCliente < 0 || indiceCliente >= clientes.size()) {
        System.out.println("Cliente no válido.");
        return;
    }

    Cliente clienteSeleccionado = clientes.get(indiceCliente);

    // ingreso datos de la mascota
    System.out.print("Nombre de la mascota: ");
    String nombreMascota = scanner.nextLine();
    System.out.print("Qué animal es?(Gato, perro, cobayos..");
    
    String especie = scanner.nextLine().toUpperCase();//despues de 20min me di cuenta q si no pongo
    												//toUpperCase la evaluacion me daba false en el try :D
    try{
    	AnimalesEnum animalito;
    	animalito=AnimalesEnum.valueOf(especie);
    	
    }catch(IllegalArgumentException e) {
    	System.out.println("Ingresaste un animal que no corresponde! Intenta de nuevo");
    	return;
    }
    
    System.out.print("Edad de la mascota: ");
    int edad = Integer.parseInt(scanner.nextLine());
    
    Animal mascota = new Animal(nombreMascota, especie, edad);
    clienteSeleccionado.agregarAnimal(mascota);
    guardarClientes(clientes,"clientes.dat");
    System.out.println("Mascota " + nombreMascota + " añadida correctamente a " + clienteSeleccionado.getNombre());
}

}