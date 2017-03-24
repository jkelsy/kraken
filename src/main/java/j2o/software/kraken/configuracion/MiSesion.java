/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.configuracion;

import j2o.software.kraken.db.model.general.Empresa;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("miSession")
public class MiSesion {

    private Empresa miEmpresa;

    public Empresa getMiEmpresa() {
        return miEmpresa;
    }

    public void setMiEmpresa(Empresa miEmpresa) {
        this.miEmpresa = miEmpresa;
    }

    public void preRenderView() {
        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();
        String path = context.getExternalContext().getRequestContextPath();
        if (miEmpresa == null) {
            //yourSessionBean.addPage("home");
            try {
                mensaje = "Debe seleccionar una empresa";
                FacesContext.getCurrentInstance().getExternalContext().redirect(path + "/pages/configuracion/empresa/seleccionaEmpresa.xhtml?faces-redirect=true");            
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", mensaje));
            } catch (Exception e) {
                // MENSAJE
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al actualizar el registro"));
                System.err.println("ERRRO AL GRABAR" + e);
            } finally {
                FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

            }

        }

    }

    public void seleccionarEmpresa(Empresa emp) {
        String mensaje = "";

        FacesContext context = FacesContext.getCurrentInstance();

        try {
            mensaje = "Empresa seleccionada con exito";
            miEmpresa = emp;

            // MENSAJE
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", mensaje));
        } catch (Exception e) {
            // MENSAJE
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error al actualizar el registro"));
            System.err.println("ERRRO AL GRABAR" + e);
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
        System.err.println("EmpresaSleccionada"+miEmpresa);
       // return "/";
    }

}
