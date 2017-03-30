/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;







import j2o.software.kraken.db.facade.contabilidad.pcga.NaturalezaFacade;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("naturalezaService")
public class NaturalezaService implements Serializable {

    @Inject
    NaturalezaFacade fachada;

    public NaturalezaFacade getFachada() {
        return fachada;
    }

    

  
}
