/**
 * This file was generated by the JPA Modeler
 */ 

package j2o.software.kraken.db.model.general;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="gen_empresa")
@NamedQuery(name="Empresa.findAllByIdentificacion",query="Select e from Empresa e where e.identificacion =:identificacion")
public class Empresa implements Serializable { 

    @Column(name="emp_id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="emp_identicacion")
    @Basic
    private String identificacion;

    @Column(name="emp_nombre")
    @Basic
    private String nombre;

    @Column(name="emp_direccion")
    @Basic
    private String direccion;

    @Column(name="emp_relefono")
    @Basic
    private String telefono;

    @Column(name="emp_email")
    @Basic
    private String email;

    @ManyToOne(targetEntity = TipoIdentificacion.class)
    @JoinColumn(name="EMP_TI_ID")
    private TipoIdentificacion tipoIdentificacion;


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

    public TipoIdentificacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }


}