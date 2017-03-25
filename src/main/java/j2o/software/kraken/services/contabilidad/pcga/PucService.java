/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;

import j2o.software.kraken.db.facade.contabilidad.pcga.PlanUnicoCuentasFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.PlanUnicoCuentas;
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
@Named("pucService")
public class PucService implements Serializable {

    @Inject
    PlanUnicoCuentasFacade pucFacade;

    public PlanUnicoCuentasFacade getPucFacade() {
        return pucFacade;
    }

    

     public List<PlanUnicoCuentas> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return pucFacade.findByNamedQuery("PlanUnicoCuentas.findAllByEmpresa", parameters);
    }

     public List<PlanUnicoCuentas> findAllByEmpresaAndCuenta(Long empresa, String cuenta) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("cuenta", cuenta);
        return pucFacade.findByNamedQuery("PlanUnicoCuentas.findAllByEmpresaAndCuenta", parameters);
    }
}
