package j2o.software.kraken.managed.general;

import j2o.software.kraken.db.general.Empresa;
import j2o.software.kraken.services.general.EmpresaService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "empresaController")
@ViewScoped
public class EmpresaController implements Serializable {

    @Inject
    private EmpresaService empresaService;

    private List<Empresa> empresas;
    private List<Empresa> empresasFiltradas;
    private Empresa nueva;

    private Long id; //id empresa seleccionada utilizado para mostrar o editar las empresas

    String labelAccion;

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public List<Empresa> getEmpresasFiltradas() {
        return empresasFiltradas;
    }

    public void setEmpresasFiltradas(List<Empresa> empresasFiltradas) {
        this.empresasFiltradas = empresasFiltradas;
    }

    public Empresa getNueva() {
        return nueva;
    }

    public void setNueva(Empresa nueva) {
        this.nueva = nueva;
    }

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

    public void inicio() {
        nueva = new Empresa();
        empresas = empresaService.getEmpresaFacade().findAll();
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new Empresa();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = empresaService.getEmpresaFacade().find(id);
    }

    public void cargarListado() {
        empresas = empresaService.getEmpresaFacade().findAll();
    }

    public void cargarMostrar() {
        nueva = empresaService.getEmpresaFacade().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            if (nueva.getId() == null) {
                mensaje = "Registro creado con exito";
                empresaService.getEmpresaFacade().create(nueva);
            } else {
                mensaje = "Registro Modificado con exito";
                empresaService.getEmpresaFacade().edit(nueva);
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

        return "/pages/configuracion/empresa/empresaListado?faces-redirect=true";

    }

    public String crear() {

        empresaService.getEmpresaFacade().create(nueva);
        return "/pages/configuracion/empresa/empresaListado?faces-redirect=true";
    }

    public String editar() {
        empresaService.getEmpresaFacade().edit(nueva);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Registro modificado con éxito"));
        return "/pages/configuracion/empresa/empresaListado?faces-redirect=true";
    }

}
