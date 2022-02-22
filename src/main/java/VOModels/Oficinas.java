package VOModels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OFICINAS")
public class Oficinas {

    @Id
    @Column(name = "ofCodigo", nullable = false)
    private int id;

    @Column(name = "ofDireccion", length = 50, nullable = false)
    private String direccion;

    @Column(name = "ofCiudad", length = 20, nullable = false)
    private String ciduad;

    @Column(name = "ofCodigoPostal", nullable = false)
    private int codigoPostal;

    @Column(name = "ofProvincia", length = 20, nullable = false)
    private String provincia;

    @Column(name = "ofTelefono", nullable = false)
    private int telefono;

    @OneToMany(mappedBy = "oficinas")
    private List<Vehiculos> listVehiculos = new ArrayList<>();

    public Oficinas(int id, String direccion, String ciduad, int codigoPostal, String provincia, int telefono, List<Vehiculos> listVehiculos) {
        this.id = id;
        this.direccion = direccion;
        this.ciduad = ciduad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.telefono = telefono;
        this.listVehiculos = listVehiculos;
    }

    public Oficinas() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiduad() {
        return ciduad;
    }

    public void setCiduad(String ciduad) {
        this.ciduad = ciduad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Vehiculos> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculos> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oficinas oficina = (Oficinas) o;
        return id == oficina.id && codigoPostal == oficina.codigoPostal && telefono == oficina.telefono && Objects.equals(direccion, oficina.direccion) && Objects.equals(ciduad, oficina.ciduad) && Objects.equals(provincia, oficina.provincia) && Objects.equals(listVehiculos, oficina.listVehiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direccion, ciduad, codigoPostal, provincia, telefono, listVehiculos);
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", ciduad='" + ciduad + '\'' +
                ", codigoPostal=" + codigoPostal +
                ", provincia='" + provincia + '\'' +
                ", telefono=" + telefono +
                ", listVehiculos=" + listVehiculos +
                '}';
    }
}
