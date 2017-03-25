package j2o.software.kraken.managed.contabilidad.pcga;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.Modulo;
import j2o.software.kraken.db.model.contabilidad.pcga.TipoDocumento;
import j2o.software.kraken.services.contabilidad.pcga.ModuloService;
import j2o.software.kraken.services.contabilidad.pcga.TipoDocumentoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "tipoDocumentoController")
@ViewScoped
public class TipoDocumentoController implements Serializable {

    @Inject MiSesion miSession;
    
    @Inject
    private TipoDocumentoService tipoDocumentoService;

    private List<TipoDocumento> tipoDocumentoList;
    private List<TipoDocumento> tipoDocumentoFiltradas;
    private TipoDocumento nueva;

    @Inject ModuloService moduloService;
    private List<Modulo> moduloList;
    
    
    private Long id; //id empresa seleccionada utilizado para mostrar o editar las empresas

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

    public List<TipoDocumento> getTipoDocumentoFiltradas() {
        return tipoDocumentoFiltradas;
    }

    public void setTipoDocumentoFiltradas(List<TipoDocumento> tipoDocumentoFiltradas) {
        this.tipoDocumentoFiltradas = tipoDocumentoFiltradas;
    }

   

    public TipoDocumento getNueva() {
        return nueva;
    }

    public void setNueva(TipoDocumento nueva) {
        this.nueva = nueva;
    }

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

   
    
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        System.err.println("MI EMPRESA."+miSession.getMiEmpresa().getId());
        
        tipoDocumentoList = tipoDocumentoService.findAllByEmpresa(miSession.getMiEmpresa().getId());
        moduloList = moduloService.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new TipoDocumento();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = tipoDocumentoService.getTipoDocumentoFacade().find(id);

        inicio();

    }

    public void cargarListado() {
       tipoDocumentoList = tipoDocumentoService.getTipoDocumentoFacade().findAll();
       tipoDocumentoList = tipoDocumentoService.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = tipoDocumentoService.getTipoDocumentoFacade().find(id);
    }

    public String grabar() {
        System.err.println("Iniciando grabacion");
        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            nueva.setEmpresa(miSession.getMiEmpresa());

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                 tipoDocumentoService.getTipoDocumentoFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                tipoDocumentoService.getTipoDocumentoFacade().edit(nueva);
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

    

}
