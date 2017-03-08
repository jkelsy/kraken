package j2o.software.kraken.managed.general;

import j2o.software.kraken.db.contabilidad.pcga.Empresa;
import j2o.software.kraken.service.facade.contabilidad.pcga.EmpresaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


@Named(value = "empresaController")
@ViewScoped
public class EmpresaController implements Serializable{
    @Inject
    private EmpresaFacade empresaService;
    //@PersistenceContext(unitName = "KrakenPU")
    //private EntityManager em;      
        
    private List<Empresa> empresas;
    private List<Empresa> empresasFiltradas;
    private Empresa nueva;
    
    private Long id; //id empresa seleccionada utilizado para mostrar o editar las empresas
   
    public void inicio(){
        nueva = new Empresa();
        empresas = empresaService.findAll();
    }
    
    public void cargarCrear(){
        nueva = new Empresa();
    }
    
    public void cargarListado(){
        empresas = empresaService.findAll();
    }
    
    public void cargarMostrar(){
        nueva = empresaService.find(id);
    }
    
    public void cargarEditar(){
        nueva = empresaService.find(id);
    }

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
    
    public String crear(){
        empresaService.create(nueva);
        return "/pages/configuracion/empresa/empresaListado?faces-redirect=true";
    }
    
    public String editar(){
        empresaService.edit(nueva);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext context = FacesContext.getCurrentInstance();     
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito",  "Registro modificado con éxito"));
        return "/pages/configuracion/empresa/empresaListado?faces-redirect=true";
    }
}
