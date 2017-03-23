/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;


import j2o.software.kraken.db.general.TipoIdentificacion;
import j2o.software.kraken.db.general.TipoIdentificacionFacade;
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
@Named("tipoIdentificacionService")
public class TipoIdentificacionService implements Serializable{
    @Inject TipoIdentificacionFacade tipoIdentificacionFacade;

    public TipoIdentificacionFacade getTipoIdentificacionFacade() {
        return tipoIdentificacionFacade;
    }

    public List<TipoIdentificacion> findAllByCodigo(String codigo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codigo", codigo);
        return tipoIdentificacionFacade.findByNamedQuery("TipoIdentificacion.findAllByCodigo", parameters);
    }
    
    
    
}
