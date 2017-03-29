package j2o.software.kraken.managed.contabilidad.pcga;

import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.AsientoContable;
import j2o.software.kraken.db.model.contabilidad.pcga.CentroCosto;
import j2o.software.kraken.db.model.contabilidad.pcga.DetalleAsiento;
import j2o.software.kraken.db.model.contabilidad.pcga.Naturaleza;
import j2o.software.kraken.db.model.contabilidad.pcga.Periodo;
import j2o.software.kraken.db.model.contabilidad.pcga.TipoDocumento;
import j2o.software.kraken.db.model.general.Tercero;
import j2o.software.kraken.services.contabilidad.pcga.AsientoContableService;
import j2o.software.kraken.services.contabilidad.pcga.CentroCostoService;
import j2o.software.kraken.services.contabilidad.pcga.DetalleAsientoService;
import j2o.software.kraken.services.contabilidad.pcga.NaturalezaService;
import j2o.software.kraken.services.contabilidad.pcga.PeriodoService;
import j2o.software.kraken.services.contabilidad.pcga.TipoDocumentoService;
import j2o.software.kraken.services.general.TerceroService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "asientoContableController")
@ViewScoped
public class AsientoContableController implements Serializable {

    @Inject
    private MiSesion miSession;

    @Inject
    private AsientoContableService servicio;

    private List<AsientoContable> listaList;
    private List<AsientoContable> listaFiltradas;
    private AsientoContable nueva;

    @Inject
    private TipoDocumentoService tipoDocumentoService;
    private List<TipoDocumento> tipoDocumentoList;

    @Inject
    private PeriodoService periodoService;
    private List<Periodo> periodoList;

    private Long id; //id empresa seleccionada utilizado para mostrar o editar las empresas

    @Inject
    private DetalleAsientoService detalleService;
    private List<DetalleAsiento> detalleList;

    @Inject
    private TerceroService terceroService;
    private List<Tercero> terceroList;
    
    @Inject
    private CentroCostoService centroCostoService;
    private List<CentroCosto> centroCostoList;
    
     @Inject
    private NaturalezaService naturalezaService;
    private List<Naturaleza> naturalezaList;
    
    
    
    String labelAccion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelAccion() {
        return labelAccion;
    }

    public void setLabelAccion(String labelAccion) {
        this.labelAccion = labelAccion;
    }

    public List<TipoDocumento> getTipoDocumentoList() {
        return tipoDocumentoList;
    }

    public void setTipoDocumentoList(List<TipoDocumento> tipoDocumentoList) {
        this.tipoDocumentoList = tipoDocumentoList;
    }

    public List<AsientoContable> getListaList() {
        return listaList;
    }

    public void setListaList(List<AsientoContable> listaList) {
        this.listaList = listaList;
    }

    public List<AsientoContable> getListaFiltradas() {
        return listaFiltradas;
    }

    public void setListaFiltradas(List<AsientoContable> listaFiltradas) {
        this.listaFiltradas = listaFiltradas;
    }

    public AsientoContable getNueva() {
        return nueva;
    }

    public void setNueva(AsientoContable nueva) {
        this.nueva = nueva;
    }

    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    public List<DetalleAsiento> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<DetalleAsiento> detalleList) {
        this.detalleList = detalleList;
    }

    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    public List<CentroCosto> getCentroCostoList() {
        return centroCostoList;
    }

    public void setCentroCostoList(List<CentroCosto> centroCostoList) {
        this.centroCostoList = centroCostoList;
    }

    public List<Naturaleza> getNaturalezaList() {
        return naturalezaList;
    }

    public void setNaturalezaList(List<Naturaleza> naturalezaList) {
        this.naturalezaList = naturalezaList;
    }

    
    
    
    
    public void inicio() {
        //nueva = new Empresa();

        tipoDocumentoList = tipoDocumentoService.findAllByEmpresa(miSession.getMiEmpresa().getId());
        periodoList = periodoService.findAllByEmpresa(miSession.getMiEmpresa().getId());
        
        naturalezaList = naturalezaService.getFachada().findAll();
        terceroList = terceroService.findAllByEmpresa(miSession.getMiEmpresa().getId());
        centroCostoList = centroCostoService.findAllByEmpresa(miSession.getMiEmpresa().getId());

        if (nueva != null) {
            detalleList = detalleService.findAllByAsientoContable(nueva.getId());
        }

    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new AsientoContable();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = servicio.getFachada().find(id);
        inicio();

    }

    public void cargarListado() {
        listaList = servicio.getFachada().findAll();
        listaList = servicio.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = servicio.getFachada().find(id);
    }

    public String grabar() {
        System.err.println("Iniciando grabacion");
        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            nueva.setEmpresa(miSession.getMiEmpresa());

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                servicio.getFachada().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                servicio.getFachada().edit(nueva);
            }

            for (DetalleAsiento det : detalleService.findAllByAsientoContable(nueva.getId())) {
                detalleService.getFachada().remove(det);
            }

            if (detalleList != null) {
                System.err.println("Iniciando lista detalle" + detalleList.size());
                for (DetalleAsiento det : detalleList) {
                    DetalleAsiento d = new DetalleAsiento();
                    d.setAsientoContable(nueva);
                    d.setValorDebito(det.getValorDebito());
                    d.setValorCredito(det.getValorCredito());
                    d.setDescrpcion(det.getDescrpcion());
                    d.setValorBase(det.getValorBase());
                    d.setValorTasa(det.getValorTasa());
                    d.setTercero(det.getTercero());
                    d.setCentroCosto(det.getCentroCosto());
                    d.setNaturaleza(det.getNaturaleza());
                    detalleService.getFachada().create(d);
                }

            }

            // MENSAJE
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", mensaje));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al actualizar el registro"));
            System.err.println("ERRRO AL GRABAR" + e);
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

        return "Listado?faces-redirect=true";

    }

    public void agregarDetalle() {
        DetalleAsiento rep = new DetalleAsiento();
        if (detalleList == null) {
            detalleList = new ArrayList<DetalleAsiento>();
        }
        detalleList.add(rep);
    }

}
