/**
 * This file was generated by the JPA Modeler
 */ 

package j2o.software.kraken.db;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author  Orhenals
 */

@Entity
public class Telefono { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    private String numero;

    @Basic
    private String tipoTel;

    @ManyToOne(targetEntity = Tercero.class)
    private Tercero tercero;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoTel() {
        return this.tipoTel;
    }

    public void setTipoTel(String tipoTel) {
        this.tipoTel = tipoTel;
    }

    public Tercero getTercero() {
        return this.tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

}
