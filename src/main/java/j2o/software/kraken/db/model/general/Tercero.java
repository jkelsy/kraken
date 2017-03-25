/**
 * This file was generated by the JPA Modeler
 */ 

package j2o.software.kraken.db.model.general;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity(name="Tercero")
@Table(name="gen_tercero")
@NamedQueries({@NamedQuery(name="Tercero.findAllByEmpresaAndIdentificacion",query="Select t from Tercero t where t.empresa.id=:empresa and t.identificacion=:identificacion"),@NamedQuery(name="Tercero.findAllByEmpresa",query="Select t from Tercero t where t.empresa.id=:empresa")})
public class Tercero implements Serializable { 

    @Column(name="ter_id")
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="ter_identificacion")
    @Basic
    @NotNull
    private String identificacion;

    @Column(name="ter_digito_verificacion")
    @Basic
    private Long digitoVerificacion;

    @Column(name="ter_primer_nombre")
    @Basic
    private String primerNombre;

    @Column(name="ter_segundo_nombre")
    @Basic
    private String segundoNombre;

    @Column(name="ter_primer_apellido")
    @Basic
    private String primerApellido;

    @Column(name="ter_segundo_apellido")
    @Basic
    private String segundoApellido;

    @Column(name="ter_genero")
    @Basic
    private String genero;

    @Column(name="ter_email")
    @Basic
    private String email;

    @Column(name="ter_estado_civil")
    @Basic
    private String estadoCivil;

    @Column(name="ter_fecha_nacimiento")
    @Basic
    private Date fechaNacimiento;

    @Column(name="ter_fecha_creacion")
    @Basic
    private Date fechaCreacion;

    @ManyToOne(targetEntity = TipoIdentificacion.class)
    @JoinColumn(name="TER_TIPO_IDENTIFICACION_ID")
    private TipoIdentificacion tipoIdentificacion;

    @ManyToOne(targetEntity = Empresa.class)
    @JoinColumn(name="TER_EMPRESA_ID")
    private Empresa empresa;


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

    public Long getDigitoVerificacion() {
        return this.digitoVerificacion;
    }

    public void setDigitoVerificacion(Long digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public String getPrimerNombre() {
        return this.primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return this.primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return this.segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }


}
