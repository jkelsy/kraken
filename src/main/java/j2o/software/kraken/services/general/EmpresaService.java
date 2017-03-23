/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;


import j2o.software.kraken.db.general.EmpresaFacade;
import java.io.Serializable;
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
    
    
    
    
}
