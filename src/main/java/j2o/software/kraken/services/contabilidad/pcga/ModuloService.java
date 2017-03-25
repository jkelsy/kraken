/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;




import j2o.software.kraken.db.facade.contabilidad.pcga.ModuloFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.Modulo;
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
@Named("moduloService")
public class ModuloService implements Serializable {

    @Inject
    ModuloFacade moduloFacade;

    public ModuloFacade getModuloFacade() {
        return moduloFacade;
    }

    

    

     public List<Modulo> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return moduloFacade.findByNamedQuery("Modulo.findAllByEmpresa", parameters);
    }

     public List<Modulo> findAllByEmpresaAndCodigo(Long empresa, String codigo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("codigo", codigo);
        return moduloFacade.findByNamedQuery("Modulo.findAllByEmpresaAndCodigo", parameters);
    }
}
