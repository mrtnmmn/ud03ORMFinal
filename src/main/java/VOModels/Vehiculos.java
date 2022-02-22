package VOModels;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vehiculos")
public class Vehiculos {

    @Id
    @Column(name = "veMatricula", length = 10, nullable = false)
    private String matricula;

    @Column(name = "veMarca", length = 20, nullable = false)
    private String marca;

    @Column(name = "veGrupo", nullable = false)
    private Grupo grupo;

    @Column(name = "vePlazas", nullable = false)
    private int plazas;

    @Column(name = "vePuertas", nullable = false)
    private int puertas;

    @Column(name = "veMaletero", nullable = false)
    private int maletero;

    @Column(name = "veEdad", nullable = false)
    private int edad;

    @ManyToOne
    @JoinColumn(name = "idOficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "vehiculo")
    private List<VehiculoCliente> vehiculoClienteList;

    private enum Grupo {
        A, B, C, D, E, F, G
    }

    public Vehiculos(String matricula, String marca, Grupo grupo, int plazas, int puertas, int maletero, int edad, Oficina oficina, List<VehiculoCliente> vehiculoClienteList) {
        this.matricula = matricula;
        this.marca = marca;
        this.grupo = grupo;
        this.plazas = plazas;
        this.puertas = puertas;
        this.maletero = maletero;
        this.edad = edad;
        this.oficina = oficina;
        this.vehiculoClienteList = vehiculoClienteList;
    }

    public Vehiculos() {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getMaletero() {
        return maletero;
    }

    public void setMaletero(int maletero) {
        this.maletero = maletero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }

    public List<VehiculoCliente> getVehiculoClienteList() {
        return vehiculoClienteList;
    }

    public void setVehiculoClienteList(List<VehiculoCliente> vehiculoClienteList) {
        this.vehiculoClienteList = vehiculoClienteList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculos vehiculos = (Vehiculos) o;
        return plazas == vehiculos.plazas && puertas == vehiculos.puertas && maletero == vehiculos.maletero && edad == vehiculos.edad && Objects.equals(matricula, vehiculos.matricula) && Objects.equals(marca, vehiculos.marca) && grupo == vehiculos.grupo && Objects.equals(oficina, vehiculos.oficina) && Objects.equals(vehiculoClienteList, vehiculos.vehiculoClienteList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, marca, grupo, plazas, puertas, maletero, edad, oficina, vehiculoClienteList);
    }

    @Override
    public String toString() {
        return "Vehiculos{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", grupo=" + grupo +
                ", plazas=" + plazas +
                ", puertas=" + puertas +
                ", maletero=" + maletero +
                ", edad=" + edad +
                ", oficina=" + oficina +
                ", vehiculoClienteList=" + vehiculoClienteList +
                '}';
    }
}
