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
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity(name="TipoIdentificacion")
@Table(name="gen_tipo_identificacion")
@NamedQuery(name="TipoIdentificacion.findAllByCodigo",query="Select t from TipoIdentificacion t where t.codigo=:codigo")
public class TipoIdentificacion implements Serializable { 

    @Column(name="ti_id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="ti_codigo")
    @Basic
    private String codigo;

    @Column(name="ti_abreviatura")
    @Basic
    private String abreviatura;

    @Column(name="ti_identificacion")
    @Basic
    private String descripcion;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAbreviatura() {
        return this.abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}