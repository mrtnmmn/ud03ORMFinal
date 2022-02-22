package consultas;

import java.util.Scanner;

public class MainConsultas {

    public static Scanner ns = new Scanner(System.in);

    public static void main(String[] args) {

        int op;
        boolean cont = true;

        while(cont) {
            System.out.println("Seleccionar opcion: " +
                    "\n\t - 1: Generar un listado con todos los vehiculos de los grupos E, F y G" +
                    "\n\t - 2: Obtener total de dias e importe total por vehiculo (Orden: matricula)" +
                    "\n\t - 3: Listar los vehiculso que no hayan sido alquilados" +
                    "\n\t - 4: Obtener todos los datos de un coche determinado" +
                    "\n\t - 5: Insertar un alquiler" +
                    "\n\t - 6: Obtener un listado de los alquileres" +
                    "\n\t - 7: Listar vehiculos con un maletero y un numero de puertas determinado" +
                    "\n\t - 8: Listar los clientes cuyo nombre empiece por una letra dada" +
                    "\n\t - 9: Listar el alquiler mas caro" +
                    "\n\t - 10:Listar todos los vehiculos dada una combinacion de letras de matricula" +
                    "\n\t - 11:Realizar una consulta para eliminar un coche con una matricula dada" +
                    "\n\t - 12:Salir");

            op = ns.nextInt();

            switch (op) {
                case 1:
                    C01 c01 = new C01();
                    c01.listGrupos();
                    break;
                case 2:
                    C02 c02 = new C02();
                    c02.listPrecioYDias();
                    break;
                case 3:
                    C03 c03 = new C03();
                    c03.listNoAlquilados();
                    break;
                case 4:
                    C04 c04 = new C04();
                    c04.listAlquileresMatricula();
                    break;
                case 5:
                    C05 c05 = new C05();
                    c05.insertAlquiler();
                    break;
                case 6:
                    C06 c06 = new C06();
                    c06.listAlquileresOrder();
                    break;
                case 7:
                    C07 c07 = new C07();
                    c07.getPuertasMaletero();
                    break;
                case 8:
                    C08 c08 = new C08();
                    c08.getClientesLetra();
                    break;
                case 9:
                    C09 c09 = new C09();
                    c09.getCostesAltos();
                    break;
                case 10:
                    C10 c10 = new C10();
                    c10.getLetrasMatricula();
                    break;
                case 11:
                    C12 c12 = new C12();
                    c12.deleteCochePorMatricula();
                    break;
                case 12:
                    cont = false;
                    break;
            }
        }
    }
}
