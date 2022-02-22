package consultas;

import DAOModels.DAOCliente;
import VOModels.Clientes;

import java.util.List;

public class C08 {

    public DAOCliente c = new DAOCliente();

    public void getClientesLetra() {
        List<Clientes> clientesList = c.getClientesLetra();
        for (Clientes c: clientesList) {
            System.out.println(c.getNombre());
        }
    }

    public static void main(String[] args) {
        C08 c08 = new C08();
        c08.getClientesLetra();
    }
}
