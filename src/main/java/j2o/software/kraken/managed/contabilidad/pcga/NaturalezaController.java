package j2o.software.kraken.managed.contabilidad.pcga;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.Naturaleza;
import j2o.software.kraken.services.contabilidad.pcga.NaturalezaService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "naturalezaController")
@ViewScoped
public class NaturalezaController implements Serializable {

    @Inject MiSesion miSession;
    
    @Inject
    private NaturalezaService servicio;

    private List<Naturaleza> listaList;
    private List<Naturaleza> listaFiltradas;
    private Naturaleza nueva;

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

    public List<Naturaleza> getListaList() {
        return listaList;
    }

    public void setListaList(List<Naturaleza> listaList) {
        this.listaList = listaList;
    }

    public List<Naturaleza> getListaFiltradas() {
        return listaFiltradas;
    }

    public void setListaFiltradas(List<Naturaleza> listaFiltradas) {
        this.listaFiltradas = listaFiltradas;
    }

    public Naturaleza getNueva() {
        return nueva;
    }

    public void setNueva(Naturaleza nueva) {
        this.nueva = nueva;
    }

    
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        //System.err.println("MI EMPRESA."+miSession.getMiEmpresa().getId());
        
        //listaList = servicio.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new Naturaleza();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = servicio.getFachada().find(id);

        inicio();

    }

    public void cargarListado() {
       listaList = servicio.getFachada().findAll();
       //listaList = servicio.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = servicio.getFachada().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
           //nueva.setEmpresa(miSession.getMiEmpresa());

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

    

}
