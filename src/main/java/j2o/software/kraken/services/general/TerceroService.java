/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;

import j2o.software.kraken.db.facade.general.TerceroFacade;
import j2o.software.kraken.db.model.general.Tercero;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("terceroService")
public class TerceroService implements Serializable {

    @Inject
    TerceroFacade terceroFacade;

    public TerceroFacade getTerceroFacade() {
        return terceroFacade;
    }

    
    
    public List<Tercero> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return terceroFacade.findByNamedQuery("Tercero.findAllByEmpresa", parameters);
    }

    public List<Tercero> findAllByEmpresaAndIdentificacion(Long empresa, String identificacion) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("identificacion", identificacion);
        return terceroFacade.findByNamedQuery("Tercero.findAllByEmpresaAndIdentificacion", parameters);
    }

}
