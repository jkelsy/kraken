/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;

import j2o.software.kraken.db.facade.general.TerceroActividadEconomicaFacade;
import j2o.software.kraken.db.model.general.TerceroActividadEconomica;
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
@Named("terceroActividadEconomicaService")
public class TerceroActividadEconomicaService implements Serializable {

    @Inject
    TerceroActividadEconomicaFacade fachada;

    public TerceroActividadEconomicaFacade getFachada() {
        return fachada;
    }

    public List<TerceroActividadEconomica> findAllByPrincipal(boolean principal) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("principal", principal);
        return fachada.findByNamedQuery("TerceroActividadEconomica.findAllByPrincipal", parameters);
    }

    public List<TerceroActividadEconomica> findAllByTerceroAndActividadEconomica(Long tercero, Long actividadEconomica) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tercero", tercero);
        parameters.put("actividadEconomica", actividadEconomica);
        return fachada.findByNamedQuery("TerceroActividadEconomica.findAllByTerceroAndActividadEconomica", parameters);
    }

    public List<TerceroActividadEconomica> findAllByTercero(Long tercero) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tercero", tercero);
        return fachada.findByNamedQuery("TerceroActividadEconomica.findAllByTercero", parameters);
    }

    public List<TerceroActividadEconomica> findAllByActividadEconomica(Long actividadEconomica) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("actividadEconomica", actividadEconomica);
        return fachada.findByNamedQuery("TerceroActividadEconomica.findAllByActividadEconomica", parameters);
    }

    public List<TerceroActividadEconomica> findAllByTerceroAndPrincipal(Long tercero, boolean principal) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tercero", tercero);
        parameters.put("principal", principal);
        return fachada.findByNamedQuery("TerceroActividadEconomica.findAllByTerceroAndPrincipal", parameters);
    }

    public List<TerceroActividadEconomica> findAllByTerceroAndActividadEconomicaAndPrincipal(Long tercero, Long actividadEconomica, boolean principal) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tercero", tercero);
        parameters.put("actividadEconomica", actividadEconomica);
        parameters.put("principal", principal);
        return fachada.findByNamedQuery("TerceroActividadEconomica.findAllByTerceroAndActividadEconomicaAndPrincipal", parameters);
    }

}
