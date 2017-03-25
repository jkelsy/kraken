package j2o.software.kraken.managed.contabilidad.pcga;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.Modulo;
import j2o.software.kraken.services.contabilidad.pcga.ModuloService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "moduloController")
@ViewScoped
public class ModuloController implements Serializable {

    @Inject MiSesion miSession;
    
    @Inject
    private ModuloService  moduloService;

    private List<Modulo> moduloList;
    private List<Modulo> moduloFiltradas;
    private Modulo nueva;

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

    public List<Modulo> getModuloList() {
        return moduloList;
    }

    public void setModuloList(List<Modulo> moduloList) {
        this.moduloList = moduloList;
    }

    public List<Modulo> getModuloFiltradas() {
        return moduloFiltradas;
    }

    public void setModuloFiltradas(List<Modulo> moduloFiltradas) {
        this.moduloFiltradas = moduloFiltradas;
    }

    public Modulo getNueva() {
        return nueva;
    }

    public void setNueva(Modulo nueva) {
        this.nueva = nueva;
    }

    

   
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        System.err.println("MI EMPRESA."+miSession.getMiEmpresa().getId());
        
        moduloList = moduloService.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new Modulo();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = moduloService.getModuloFacade().find(id);

        inicio();

    }

    public void cargarListado() {
       moduloList = moduloService.getModuloFacade().findAll();
       moduloList = moduloService.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = moduloService.getModuloFacade().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            nueva.setEmpresa(miSession.getMiEmpresa());

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                 moduloService.getModuloFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                moduloService.getModuloFacade().edit(nueva);
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
