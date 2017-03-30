/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.contabilidad.pcga;






import j2o.software.kraken.db.facade.contabilidad.pcga.ClaseFacade;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("claseService")
public class ClaseService implements Serializable {

     @Inject
    ClaseFacade fachada;

    public ClaseFacade getFachada() {
        return fachada;
    }


     

    

  
}
