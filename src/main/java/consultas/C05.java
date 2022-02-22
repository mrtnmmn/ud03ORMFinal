package consultas;

import DAOModels.DAOCliente;
import DAOModels.DAOOficina;
import DAOModels.DAOVehiculoClientes;
import DAOModels.DAOVehiculos;
import VOModels.Clientes;
import VOModels.VehiculoClientes;
import VOModels.Vehiculos;
import conexion.Conexion;

import java.util.Scanner;

public class C05 {

    public Scanner ns = new Scanner(System.in);
    public DAOVehiculos v = new DAOVehiculos();
    public DAOOficina o = new DAOOficina();
    public DAOCliente c = new DAOCliente();
    public DAOVehiculoClientes vc = new DAOVehiculoClientes();

    public void insertAlquiler() {
        System.out.println("Insertando un alquiler :");
        System.out.print("\tInsertar la matricula del vehiculo (si no existiera se iniciara el proceso de insercion de un nuevo coche: ");

        VehiculoClientes vcFinal = new VehiculoClientes();

        String matricula = ns.nextLine();
        Vehiculos vFinal;

        if (v.comprobarMatricula(matricula).isEmpty()) {
            vFinal = insertNewVehiculo(matricula);
        } else {
            vFinal = v.getVehiculo(matricula);
        }

        vcFinal.setVehiculo(vFinal);

        System.out.print("\tInsertar el dni del cliente (si este no existe se iniciara el proceso de insercion de un nuevo cliente): ");

        String dni = ns.nextLine();
        Clientes cFinal;

        if (c.comprobarDNI(dni).isEmpty()) {
            cFinal = insertNewClientes(dni);
        } else {
            cFinal = c.getCliente(dni);
            System.out.println(cFinal);
        }

        vcFinal.setCliente(cFinal);

        System.out.print("\tInsertar los dias: ");
        vcFinal.setDias(ns.nextInt());
        ns.nextLine();


        System.out.print("\tInsertar seguro: ");
        vcFinal.setSeguro(ns.nextLine());
        ns.nextLine();

        System.out.print("\tInsertar precio: ");
        vcFinal.setPrecio(ns.nextInt());
        ns.nextLine();

        vc.insertAlquiler(vcFinal);
    }

    public Vehiculos insertNewVehiculo(String matricula) {

        Vehiculos v1 = new Vehiculos();

        v1.setMatricula(matricula);

        System.out.println("Creando un nuevo vehiculo con matricula " + matricula + ": ");
        System.out.print("\tInsertar marca: ");
        v1.setMarca(ns.nextLine());
        System.out.print("\tInsertar grupo: ");
        v1.setGrupo(Vehiculos.Grupo.valueOf(ns.nextLine()));
        System.out.print("\tInsertar plazas: ");
        v1.setPlazas(ns.nextInt());
        System.out.print("\tInsertar maletero: ");
        v1.setMaletero(ns.nextInt());
        System.out.print("\tInsertar edad: ");
        v1.setEdad(ns.nextInt());
        System.out.print("\tInsertar codigo de oficina: ");
        v1.setOficina(o.findOficina(ns.nextInt()));

        v.insertVehiculo(v1);

        return v1;

    }

    public Clientes insertNewClientes(String dni) {

        Clientes c1 = new Clientes();

        c1.setDni(dni);

        System.out.print("\tInserta el nombre: ");
        c1.setNombre(ns.nextLine());
        System.out.print("\tInserta la direccion: ");
        c1.setDireccion(ns.nextLine());
        System.out.print("\tInserta la ciudad: ");
        c1.setCiudad(ns.nextLine());
        System.out.print("\tInserta el codigo postal: ");
        c1.setCodigoPostal(ns.nextInt());
        System.out.print("\tInserta la provincia: ");
        c1.setProvincia(ns.nextLine());
        System.out.print("\tInsertar telefono: ");
        c1.setTelefono(ns.nextInt());
        System.out.println("\tInserta el numero de tarjeta: ");
        c1.setNumTarjeta(ns.nextLine());

        c.insertCliente(c1);

        return c1;
    }


    public static void main(String[] args) {
        C05 c05 = new C05();
        c05.insertAlquiler();
    }
}
