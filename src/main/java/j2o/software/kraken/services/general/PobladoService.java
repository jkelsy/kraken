/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;

import j2o.software.kraken.db.facade.general.PobladoFacade;
import j2o.software.kraken.db.model.general.Poblado;
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
@Named("pobladoService")
public class PobladoService implements Serializable{
    @Inject
    private PobladoFacade fachada;

    public PobladoFacade getFachada() {
        return fachada;
    }

    
     
    public List<Poblado> findAllByMunicipio(Long municipio) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("municipio", municipio);
        return fachada.findByNamedQuery("Poblado.findAllByMunicipio", parameters);
    }
   
}
