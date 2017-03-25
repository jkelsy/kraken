package j2o.software.kraken.managed.contabilidad.pcga;


import j2o.software.kraken.configuracion.MiSesion;
import j2o.software.kraken.db.model.contabilidad.pcga.Periodo;
import j2o.software.kraken.services.contabilidad.pcga.PeriodoService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "periodoController")
@ViewScoped
public class PeriodoController implements Serializable {
private Date date1 = new Date();
    @Inject MiSesion miSession;
    
    @Inject
    private PeriodoService servicio;

    private List<Periodo> listaList;
    private List<Periodo> listaFiltradas;
    private Periodo nueva;

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

    public List<Periodo> getListaList() {
        return listaList;
    }

    public void setListaList(List<Periodo> listaList) {
        this.listaList = listaList;
    }

    public List<Periodo> getListaFiltradas() {
        return listaFiltradas;
    }

    public void setListaFiltradas(List<Periodo> listaFiltradas) {
        this.listaFiltradas = listaFiltradas;
    }

    public Periodo getNueva() {
        return nueva;
    }

    public void setNueva(Periodo nueva) {
        this.nueva = nueva;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

   
    
    
    public void inicio() {
        //nueva = new Empresa();
        
        System.err.println("MI EMPRESA."+miSession.getMiEmpresa().getId());
        
        listaList = servicio.findAllByEmpresa(miSession.getMiEmpresa().getId());
    }

    public void cargarCrear() {
        labelAccion = "Grabar";
        nueva = new Periodo();
        inicio();
    }

    public void cargarEditar() {
        labelAccion = "Actualizar";
        nueva = servicio.getFachada().find(id);

        inicio();

    }

    public void cargarListado() {
       listaList = servicio.getFachada().findAll();
       listaList = servicio.findAllByEmpresa(miSession.getMiEmpresa().getId());

    }

    public void cargarMostrar() {
        nueva = servicio.getFachada().find(id);
    }

    public String grabar() {

        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {

            
            nueva.setEmpresa(miSession.getMiEmpresa());

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
