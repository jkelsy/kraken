/**
 * This file was generated by the JPA Modeler
 */ 

package j2o.software.kraken.db.contabilidad.pcga;

import j2o.software.kraken.db.general.Tercero;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class DetalleSaldoTercero implements Serializable { 

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Basic
    private double saldoAnterior;

    @Basic
    private double valorDB;

    @Basic
    private double valorCR;

    @Basic
    private double saldoFinal;

    @ManyToOne(targetEntity = ComprobanteSaldo.class)
    private ComprobanteSaldo comprobanteSaldo;

    @ManyToOne(targetEntity = Tercero.class)
    private Tercero tercero;

    @ManyToOne(targetEntity = PlanUnicoCuentas.class)
    private PlanUnicoCuentas planUnicoCuentas;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSaldoAnterior() {
        return this.saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getValorDB() {
        return this.valorDB;
    }

    public void setValorDB(double valorDB) {
        this.valorDB = valorDB;
    }

    public double getValorCR() {
        return this.valorCR;
    }

    public void setValorCR(double valorCR) {
        this.valorCR = valorCR;
    }

    public double getSaldoFinal() {
        return this.saldoFinal;
    }

    public void setSaldoFinal(double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public ComprobanteSaldo getComprobanteSaldo() {
        return this.comprobanteSaldo;
    }

    public void setComprobanteSaldo(ComprobanteSaldo comprobanteSaldo) {
        this.comprobanteSaldo = comprobanteSaldo;
    }

    public Tercero getTercero() {
        return this.tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

    public PlanUnicoCuentas getPlanUnicoCuentas() {
        return this.planUnicoCuentas;
    }

    public void setPlanUnicoCuentas(PlanUnicoCuentas planUnicoCuentas) {
        this.planUnicoCuentas = planUnicoCuentas;
    }


}
