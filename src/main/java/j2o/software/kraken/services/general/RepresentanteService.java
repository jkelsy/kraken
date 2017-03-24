/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;

import j2o.software.kraken.db.facade.general.RepresentanteFacade;
import j2o.software.kraken.db.model.general.Empresa;
import j2o.software.kraken.db.model.general.Representante;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("representanteService")
public class RepresentanteService implements Serializable {

    @Inject
    RepresentanteFacade representanteFacade;

    public RepresentanteFacade getRepresentanteFacade() {
        return representanteFacade;
    }

    public List<Representante> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return representanteFacade.findByNamedQuery("Representante.findAllByEmpresa", parameters);
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Editado", ((Representante) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cancelado", ((Representante) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
