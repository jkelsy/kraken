package j2o.software.kraken.managed.general;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.general.Tercero;
import j2o.software.kraken.services.general.TerceroService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "terceroController")
@ViewScoped
public class TerceroController implements Serializable {

    @Inject MiSesion miSession;
    
    @Inject
    private TerceroService  terceroService;

    private List<Tercero> terceroList;
    private List<Tercero> terceroFiltradas;
    private Tercero nueva;

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

    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    public List<Tercero> getTerceroFiltradas() {
        return terceroFiltradas;
    }

    public void setTerceroFiltradas(List<Tercero> terceroFiltradas) {
        this.terceroFiltradas = terceroFiltradas;
    }

    public Tercero getNueva() {
        return nueva;
    }

    public void setNueva(Tercero nueva) {
        this.nueva = nueva;
    }

    
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        
        terceroList = terceroService.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new Tercero();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = terceroService.getTerceroFacade().find(id);

        inicio();

    }

    public void cargarListado() {
       terceroList = terceroService.getTerceroFacade().findAll();
       terceroList = terceroService.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = terceroService.getTerceroFacade().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            nueva.setEmpresa(miSession.getMiEmpresa());

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                 terceroService.getTerceroFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                terceroService.getTerceroFacade().edit(nueva);
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
