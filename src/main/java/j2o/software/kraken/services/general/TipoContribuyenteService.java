/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;




import j2o.software.kraken.db.facade.general.TipoContribuyenteFacade;
import j2o.software.kraken.db.model.general.TipoContribuyente;
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
@Named("tipoContribuyenteService")
public class TipoContribuyenteService implements Serializable {

    @Inject
    TipoContribuyenteFacade fachada;

    public TipoContribuyenteFacade getFachada() {
        return fachada;
    }

    

     public List<TipoContribuyente> findAllByCodigo(String codigo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codigo", codigo);
        return fachada.findByNamedQuery("TipoContribuyente.findAllByCodigo", parameters);
    }

}
