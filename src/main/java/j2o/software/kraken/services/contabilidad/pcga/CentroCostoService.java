/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;

import j2o.software.kraken.db.facade.contabilidad.pcga.CentroCostoFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.CentroCosto;
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
@Named("centroCostoService")
public class CentroCostoService implements Serializable {

    @Inject
    CentroCostoFacade centroCostoFacade;

    public CentroCostoFacade getCentroCostoFacade() {
        return centroCostoFacade;
    }

     public List<CentroCosto> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return centroCostoFacade.findByNamedQuery("CentroCosto.findAllByEmpresa", parameters);
    }

     public List<CentroCosto> findAllByEmpresaAndCodigo(Long empresa, String codigo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("codigo", codigo);
        return centroCostoFacade.findByNamedQuery("CentroCosto.findAllByEmpresaAndCodigo", parameters);
    }
}
