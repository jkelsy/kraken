/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;


import j2o.software.kraken.db.facade.contabilidad.pcga.TipoDocumentoFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.TipoDocumento;
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
@Named("tipoDocumentoService")
public class TipoDocumentoService implements Serializable {

    @Inject
    TipoDocumentoFacade tipoDocumentoFacade;

    public TipoDocumentoFacade getTipoDocumentoFacade() {
        return tipoDocumentoFacade;
    }


    

     public List<TipoDocumento> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return tipoDocumentoFacade.findByNamedQuery("TipoDocumento.findAllByEmpresa", parameters);
    }

     public List<TipoDocumento> findAllByEmpresaAndCodigo(Long empresa, String codigo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("codigo", codigo);
        return tipoDocumentoFacade.findByNamedQuery("TipoDocumento.findAllByEmpresaAndCodigo", parameters);
    }
}
