package j2o.software.kraken.managed.contabilidad.pcga;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.PlanUnicoCuentas;
import j2o.software.kraken.services.contabilidad.pcga.PucService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "pucController")
@ViewScoped
public class PucController implements Serializable {

    @Inject MiSesion miSession;
    
    @Inject
    private PucService  pucService;

    private List<PlanUnicoCuentas> pucList;
    private List<PlanUnicoCuentas> pucFiltradas;
    private PlanUnicoCuentas nueva;

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

    public List<PlanUnicoCuentas> getPucList() {
        return pucList;
    }

    public void setPucList(List<PlanUnicoCuentas> pucList) {
        this.pucList = pucList;
    }

    public List<PlanUnicoCuentas> getPucFiltradas() {
        return pucFiltradas;
    }

    public void setPucFiltradas(List<PlanUnicoCuentas> pucFiltradas) {
        this.pucFiltradas = pucFiltradas;
    }

    public PlanUnicoCuentas getNueva() {
        return nueva;
    }

    public void setNueva(PlanUnicoCuentas nueva) {
        this.nueva = nueva;
    }


   
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        System.err.println("MI EMPRESA."+miSession.getMiEmpresa().getId());
        
        pucList = pucService.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new PlanUnicoCuentas();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = pucService.getPucFacade().find(id);

        inicio();

    }

    public void cargarListado() {
       pucList = pucService.getPucFacade().findAll();
       pucList = pucService.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = pucService.getPucFacade().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            nueva.setEmpresa(miSession.getMiEmpresa());

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                 pucService.getPucFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                pucService.getPucFacade().edit(nueva);
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
