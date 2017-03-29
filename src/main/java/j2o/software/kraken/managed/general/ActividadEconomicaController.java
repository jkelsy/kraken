package j2o.software.kraken.managed.general;

import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.general.ActividadEconomica;
import j2o.software.kraken.services.general.ActividadEconomicaService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "actividadEconomicaController")
@ViewScoped
public class ActividadEconomicaController implements Serializable {

    @Inject
    private MiSesion miSession;

    @Inject
    private ActividadEconomicaService servicio;

    private List<ActividadEconomica> listaList;
    private List<ActividadEconomica> listaFiltradas;
    private ActividadEconomica nueva;

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

    public List<ActividadEconomica> getListaList() {
        return listaList;
    }

    public void setListaList(List<ActividadEconomica> listaList) {
        this.listaList = listaList;
    }

    public List<ActividadEconomica> getListaFiltradas() {
        return listaFiltradas;
    }

    public void setListaFiltradas(List<ActividadEconomica> listaFiltradas) {
        this.listaFiltradas = listaFiltradas;
    }

    public ActividadEconomica getNueva() {
        return nueva;
    }

    public void setNueva(ActividadEconomica nueva) {
        this.nueva = nueva;
    }

    public void inicio() {
        //nueva = new Empresa();

        listaList = servicio.getFachada().findAll();
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new ActividadEconomica();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = servicio.getFachada().find(id);

        inicio();

    }

    public void cargarListado() {
        listaList = servicio.getFachada().findAll();

    }

    public void cargarMostrar() {
        nueva = servicio.getFachada().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                servicio.getFachada().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                servicio.getFachada().edit(nueva);
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

    public void cargarActividadesEconomica(FileUploadEvent event) {
        UploadedFile file = event.getFile();

        if (file.getContents().length != 0) {
            servicio.cargarActividadEconomica(file);
        }
    }

}
