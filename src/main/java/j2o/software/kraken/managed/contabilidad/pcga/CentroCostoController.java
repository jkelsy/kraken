package j2o.software.kraken.managed.contabilidad.pcga;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.CentroCosto;
import j2o.software.kraken.services.contabilidad.pcga.CentroCostoService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "centroCostoController")
@ViewScoped
public class CentroCostoController implements Serializable {

    @Inject MiSesion miSession;
    
    @Inject
    private CentroCostoService  centroCostoService;

    private List<CentroCosto> centroCostoList;
    private List<CentroCosto> centroCostoFiltradas;
    private CentroCosto nueva;

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

    public List<CentroCosto> getCentroCostoList() {
        return centroCostoList;
    }

    public void setCentroCostoList(List<CentroCosto> centroCostoList) {
        this.centroCostoList = centroCostoList;
    }

    public List<CentroCosto> getCentroCostoFiltradas() {
        return centroCostoFiltradas;
    }

    public void setCentroCostoFiltradas(List<CentroCosto> centroCostoFiltradas) {
        this.centroCostoFiltradas = centroCostoFiltradas;
    }

    public CentroCosto getNueva() {
        return nueva;
    }

    public void setNueva(CentroCosto nueva) {
        this.nueva = nueva;
    }

   
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        System.err.println("MI EMPRESA."+miSession.getMiEmpresa().getId());
        
        centroCostoList = centroCostoService.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new CentroCosto();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = centroCostoService.getCentroCostoFacade().find(id);

        inicio();

    }

    public void cargarListado() {
       centroCostoList = centroCostoService.getCentroCostoFacade().findAll();
       centroCostoList = centroCostoService.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = centroCostoService.getCentroCostoFacade().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            nueva.setEmpresa(miSession.getMiEmpresa());

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                 centroCostoService.getCentroCostoFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                centroCostoService.getCentroCostoFacade().edit(nueva);
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
