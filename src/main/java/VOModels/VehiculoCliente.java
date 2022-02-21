package VOModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VehiculoCliente")
public class VehiculoCliente {

    @Id
    @Column(name = "idVehiculoCliente", nullable = false)
    private int id;

    @Column(name = "vcDias", nullable = false)
    private int dias;

    @Column(name = "vcSeguro", length = 20, nullable = false)
    private String seguro;

    @Column(name = "vcPrecio", nullable = false)
    private int precio;

    @ManyToOne
    @JoinColumn(name = "veMatricula", nullable = false)
    private Vehiculos vehiculo;

    @ManyToOne
    @JoinColumn(name = "clDni", nullable = false)
    private Cliente cliente;

    public VehiculoCliente(int id, int dias, String seguro, int precio, Vehiculos vehiculo, Cliente cliente) {
        this.id = id;
        this.dias = dias;
        this.seguro = seguro;
        this.precio = precio;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    public VehiculoCliente() {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculoCliente that = (VehiculoCliente) o;
        return id == that.id && dias == that.dias && precio == that.precio && Objects.equals(seguro, that.seguro) && Objects.equals(vehiculo, that.vehiculo) && Objects.equals(cliente, that.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dias, seguro, precio, vehiculo, cliente);
    }

    @Override
    public String toString() {
        return "VehiculoCliente{" +
                "id=" + id +
                ", dias=" + dias +
                ", seguro='" + seguro + '\'' +
                ", precio=" + precio +
                ", vehiculo=" + vehiculo +
                ", cliente=" + cliente +
                '}';
    }
}
