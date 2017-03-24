/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;


import j2o.software.kraken.db.facade.general.EmpresaFacade;
import j2o.software.kraken.db.model.general.Empresa;
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
@Named("empresaService")
public class EmpresaService implements Serializable{
    @Inject EmpresaFacade empresaFacade;

    public EmpresaFacade getEmpresaFacade() {
        return empresaFacade;
    }
    
     public List<Empresa> findAllByIdentificacion(String identificacion) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("identificacion", identificacion);
        return empresaFacade.findByNamedQuery("Empresa.findAllByIdentificacion", parameters);
    }
    
    
}
