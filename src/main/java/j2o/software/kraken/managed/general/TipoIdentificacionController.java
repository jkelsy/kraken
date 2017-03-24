package j2o.software.kraken.managed.general;


import j2o.software.kraken.db.model.general.TipoIdentificacion;
import j2o.software.kraken.services.general.TipoIdentificacionService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "tipoIdentificacionController")
@ViewScoped
public class TipoIdentificacionController implements Serializable {

    @Inject
    private TipoIdentificacionService  tipoIdentificacionService;

    private List<TipoIdentificacion> tipoIdentificacionList;
    private List<TipoIdentificacion> tipoIdentificacionFiltradas;
    private TipoIdentificacion nueva;

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

    public List<TipoIdentificacion> getTipoIdentificacionList() {
        return tipoIdentificacionList;
    }

    public void setTipoIdentificacionList(List<TipoIdentificacion> tipoIdentificacionList) {
        this.tipoIdentificacionList = tipoIdentificacionList;
    }

    
    public List<TipoIdentificacion> getTipoIdentificacionFiltradas() {
        return tipoIdentificacionFiltradas;
    }

    public void setTipoIdentificacionFiltradas(List<TipoIdentificacion> tipoIdentificacionFiltradas) {
        this.tipoIdentificacionFiltradas = tipoIdentificacionFiltradas;
    }

    public TipoIdentificacion getNueva() {
        return nueva;
    }

    public void setNueva(TipoIdentificacion nueva) {
        this.nueva = nueva;
    }
    
    
    
    public void inicio() {
        //nueva = new Empresa();
        tipoIdentificacionList = tipoIdentificacionService.getTipoIdentificacionFacade().findAll();
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new TipoIdentificacion();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = tipoIdentificacionService.getTipoIdentificacionFacade().find(id);

        inicio();

    }

    public void cargarListado() {
       tipoIdentificacionList = tipoIdentificacionService.getTipoIdentificacionFacade().findAll();
    }

    public void cargarMostrar() {
        nueva = tipoIdentificacionService.getTipoIdentificacionFacade().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                 tipoIdentificacionService.getTipoIdentificacionFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                tipoIdentificacionService.getTipoIdentificacionFacade().edit(nueva);
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

        return "/pages/configuracion/tipoIdentificacion/Listado?faces-redirect=true";

    }

    

}
