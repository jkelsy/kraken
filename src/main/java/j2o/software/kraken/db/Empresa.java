/**
 * This file was generated by the JPA Modeler
 */ 

package j2o.software.kraken.db;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author  Orhenals
 */

@Entity
public class Empresa { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    private String identificacion;

    @Basic
    private String nombre;

    @Basic
    private String direccion;

    @Basic
    private String telefono;

    @Basic
    private String email;

    @OneToOne(targetEntity = Tercero.class)
    @JoinColumn(name="REPRESENTANTE_ID")
    private Tercero representante;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tercero getRepresentante() {
        return this.representante;
    }

    public void setRepresentante(Tercero representante) {
        this.representante = representante;
    }

}