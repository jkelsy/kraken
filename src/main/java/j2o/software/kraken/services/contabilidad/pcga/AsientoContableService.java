/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;


import j2o.software.kraken.db.facade.contabilidad.pcga.AsientoContableFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.AsientoContable;
import java.io.Serializable;
import java.util.Date;
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
@Named("asientoContableService")
public class AsientoContableService implements Serializable {

    @Inject
    private AsientoContableFacade fachada;

    public AsientoContableFacade getFachada() {
        return fachada;
    }
            

     public List<AsientoContable> findAllByEmpresa(Long empresa) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        return fachada.findByNamedQuery("AsientoContable.findAllByEmpresa", parameters);
    }
     
      public List<AsientoContable> findAllByEmpresaAndPeriodo(Long empresa, Long periodo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("periodo", periodo);
        return fachada.findByNamedQuery("AsientoContable.findAllByEmpresaAndPeriodo", parameters);
    }
     
     public List<AsientoContable> findAllByEmpresaAndTipoDocumento(Long empresa, Long tipoDocumento) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("tipoDocumento", tipoDocumento);
        return fachada.findByNamedQuery("AsientoContable.findAllByEmpresaAndTipoDocumento", parameters);
    }
     
     public List<AsientoContable> findAllByEmpresaAndPeriodoAndTipoDocumento(Long empresa,Long periodo, Long tipoDocumento) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("periodo", periodo);
        parameters.put("tipoDocumento", tipoDocumento);
        return fachada.findByNamedQuery("AsientoContable.findAllByEmpresaAndPeriodoAndTipoDocumento", parameters);
    }
     
     public List<AsientoContable> findAllByEmpresaAndFechaBetween(Date fechaInicio, Date fechaFin) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("fechaInicio", fechaInicio);
        parameters.put("fechaFin", fechaFin);
        return fachada.findByNamedQuery("AsientoContable.findAllByEmpresaAndFechaBetween", parameters);
    }
     
     public List<AsientoContable> findAllByEmpresaAndFecha(Long empresa, Date fecha) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("empresa", empresa);
        parameters.put("fecha", fecha);
        return fachada.findByNamedQuery("AsientoContable.findAllByEmpresaAndFecha", parameters);
    }
     
  

     
}
