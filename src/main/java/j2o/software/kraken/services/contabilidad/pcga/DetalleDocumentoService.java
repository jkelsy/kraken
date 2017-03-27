/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;

import j2o.software.kraken.db.facade.contabilidad.pcga.DetalleDocumentoFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.DetalleDocumento;
import j2o.software.kraken.db.model.contabilidad.pcga.Periodo;
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
@Named("detalleDocumentoService")
public class DetalleDocumentoService implements Serializable {

    @Inject
    DetalleDocumentoFacade fachada;

    public List<DetalleDocumento> findAllByTipoDocumento(Long tipoDocumento) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tipoDocumento", tipoDocumento);
        return fachada.findByNamedQuery("DetalleDocumento.findAllByTipoDocumento", parameters);
    }

    public List<DetalleDocumento> findAllByPlanUnicoCuentas(Long planUnicoCuentas) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("planUnicoCuentas", planUnicoCuentas);
        return fachada.findByNamedQuery("DetalleDocumento.findAllByPlanUnicoCuentas", parameters);
    }

    public List<DetalleDocumento> findAllByNaturaleza(Long naturaleza) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("naturaleza", naturaleza);
        return fachada.findByNamedQuery("DetalleDocumento.findAllByNaturaleza", parameters);
    }

    public List<DetalleDocumento> findAllByTipoDocumentoAndPlanUnicoCuentasAndNaturaleza(Long tipoDocumento, Long planUnicoCuentas, Long naturaleza) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tipoDocumento", tipoDocumento);
        parameters.put("planUnicoCuentas", planUnicoCuentas);
        parameters.put("naturaleza", naturaleza);
        return fachada.findByNamedQuery("DetalleDocumento.findAllByTipoDocumentoAndPlanUnicoCuentasAndNaturaleza", parameters);
    }
}
