/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.managed.general;

import j2o.software.kraken.db.general.Tercero;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author jkelsy
 */
@Named(value = "terceroController")
@ViewScoped
public class TerceroController implements Serializable{

    /**
     * Creates a new instance of TerceroController
     */
    private Tercero nuevo;

    public Tercero getNuevo() {
        return nuevo;
    }

    public void setNuevo(Tercero nuevo) {
        this.nuevo = nuevo;
    }
    
    
    
}
