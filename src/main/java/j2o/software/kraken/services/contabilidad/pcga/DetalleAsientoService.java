/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;

import j2o.software.kraken.db.facade.contabilidad.pcga.DetalleAsientoFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.DetalleAsiento;
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
@Named("detalleAsientoService")
public class DetalleAsientoService implements Serializable {

    @Inject
    private DetalleAsientoFacade fachada;

    public DetalleAsientoFacade getFachada() {
        return fachada;
    }

    public void setFachada(DetalleAsientoFacade fachada) {
        this.fachada = fachada;
    }

    public List<DetalleAsiento> findAllByTercero(Long tercero) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("tercero", tercero);
        return fachada.findByNamedQuery("DetalleAsiento.findAllByTercero", parameters);
    }

    public List<DetalleAsiento> findAllByAsientoContable(Long asientoContable) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("asientoContable", asientoContable);
        return fachada.findByNamedQuery("DetalleAsiento.findAllByAsientoContable", parameters);
    }

    public List<DetalleAsiento> findAllByCentroCosto(Long centroCosto) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("centroCosto", centroCosto);
        return fachada.findByNamedQuery("DetalleAsiento.findAllByCentroCosto", parameters);
    }

    public List<DetalleAsiento> findAllByNaturaleza(Long naturaleza) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("naturaleza", naturaleza);
        return fachada.findByNamedQuery("DetalleAsiento.findAllByNaturaleza", parameters);
    }

    public List<DetalleAsiento> findAllByAsientoContableAndTerceroAndCentroCostoAndNaturaleza(Long asientoContable, Long tercero, Long centroCosto, Long naturaleza) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("asientoContable", asientoContable);
        parameters.put("tercero", tercero);
        parameters.put("centroCosto", centroCosto);
        parameters.put("naturaleza", naturaleza);
        
        return fachada.findByNamedQuery("DetalleAsiento.findAllByAsientoContableAndTerceroAndCentroCostoAndNaturaleza", parameters);
    }

}
