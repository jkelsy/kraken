package j2o.software.kraken.managed.general;

import j2o.software.kraken.db.model.general.Empresa;
import j2o.software.kraken.db.model.general.Representante;
import j2o.software.kraken.db.model.general.TipoIdentificacion;
import j2o.software.kraken.services.general.EmpresaService;
import j2o.software.kraken.services.general.RepresentanteService;
import j2o.software.kraken.services.general.TipoIdentificacionService;
import java.io.Serializable;
import java.util.ArrayList;
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
    @Inject
    private TipoIdentificacionService tipoIdentificacionService;
    @Inject
    private RepresentanteService representanteService;

    private List<Empresa> empresas;
    private List<Empresa> empresasFiltradas;
    private Empresa nueva;

    private Long id; //id empresa seleccionada utilizado para mostrar o editar las empresas

    String labelAccion;

    private List<TipoIdentificacion> tipoIdentificacionList;

    private List<Representante> representanteList;

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

    public List<TipoIdentificacion> getTipoIdentificacionList() {
        return tipoIdentificacionList;
    }

    public void setTipoIdentificacionList(List<TipoIdentificacion> tipoIdentificacionList) {
        this.tipoIdentificacionList = tipoIdentificacionList;
    }


    public List<Representante> getRepresentanteList() {
        return representanteList;
    }

    public void setRepresentanteList(List<Representante> representanteList) {
        this.representanteList = representanteList;
    }

    public void inicio() {
        //nueva = new Empresa();
        empresas = empresaService.getEmpresaFacade().findAll();
        tipoIdentificacionList = tipoIdentificacionService.getTipoIdentificacionFacade().findAll();

      
        if (nueva != null) {
            representanteList = representanteService.findAllByEmpresa(nueva.getId());
        }

    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new Empresa();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = empresaService.getEmpresaFacade().find(id);

        inicio();

    }

    public void cargarListado() {
        empresas = empresaService.getEmpresaFacade().findAll();
        inicio();
    }

    public void cargarMostrar() {
        nueva = empresaService.getEmpresaFacade().find(id);
        inicio();
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

            for (Representante rep : representanteService.findAllByEmpresa(nueva.getId())) {
                representanteService.getRepresentanteFacade().remove(rep);
            }
            
            
            
            if (representanteList != null) {
                for (Representante rep : representanteList) {
                    Representante r = new Representante();
                    r.setIdentificacion(rep.getIdentificacion());
                    r.setNombres(rep.getNombres());
                    r.setApellidos(rep.getApellidos());
                    r.setTipoIdentificacion(rep.getTipoIdentificacion());
                    r.setEmpresa(nueva);
                    representanteService.getRepresentanteFacade().create(r);
                }

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
    
    public void agregarRepresentante(){
        Representante rep = new Representante();
        if(representanteList == null){
            representanteList = new ArrayList<Representante>();
        }
        representanteList.add(rep);
    }
    

}
