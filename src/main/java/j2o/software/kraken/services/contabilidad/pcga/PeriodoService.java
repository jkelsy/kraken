/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;




import j2o.software.kraken.db.facade.contabilidad.pcga.PeriodoFacade;
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
@Named("periodoService")
public class PeriodoService implements Serializable {

    @Inject
    PeriodoFacade fachada;

    public PeriodoFacade getFachada() {
        return fachada;
    }



    

     public List<Periodo> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return fachada.findByNamedQuery("Periodo.findAllByEmpresa", parameters);
    }

     public List<Periodo> findAllByEmpresaAndAnyoAndMes(Long empresa, String anyo, String mes) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("anyo", anyo);
        parameters.put("mes", mes);
        return fachada.findByNamedQuery("Modulo.findAllByEmpresaAndCodigo", parameters);
    }
}
