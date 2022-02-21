package VOModels;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Oficina {

    @Id
    @Column(name = "idOficina")
    private int id;

    @Column(name = "ofDireccion")
    private String direccion;

    @Column(name = "ofCiudad")
    private String ciduad;

    @Column(name = "ofCodigoPostal")
    private int codigoPostal;

    @Column(name = "ofProvincia")
    private String provincia;

    @Column(name = "ofTelefono")
    private int telefono;

    @OneToMany(mappedBy = "oficina")
    private List<Vehiculos> listVehiculos = new ArrayList<>();

}
