package VOModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VEHICULOSCLIENTES")
public class VehiculoClientes {

    @Id
    @Column(name = "vcId", nullable = false)
    private int id;

    @Column(name = "vcDias", nullable = false)
    private int dias;

    @Column(name = "vcSeguro", length = 20, nullable = false)
    private String seguro;

    @Column(name = "vcPrecio", nullable = false)
    private int precio;

    @ManyToOne
    @JoinColumn(name = "vcMatricula", nullable = false)
    private Vehiculos vehiculo;

    @ManyToOne
    @JoinColumn(name = "vcDni", nullable = false)
    private Clientes cliente;

    public VehiculoClientes(int id, String matricula, String dni, int dias, String seguro, int precio, Vehiculos vehiculo, Clientes cliente) {
        this.id = id;
        this.dias = dias;
        this.seguro = seguro;
        this.precio = precio;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public VehiculoClientes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoClientes that = (VehiculoClientes) o;
        return id == that.id && dias == that.dias && precio == that.precio && Objects.equals(seguro, that.seguro) && Objects.equals(vehiculo, that.vehiculo) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dias, seguro, precio, vehiculo, cliente);
    }

    @Override
    public String toString() {
        return "VehiculoClientes{" +
                "id=" + id +
                ", dias=" + dias +
                ", seguro='" + seguro + '\'' +
                ", precio=" + precio +
                ", vehiculo=" + vehiculo +
                ", cliente=" + cliente +
                '}';
    }
}
