/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.configuracion;

import j2o.software.kraken.services.general.ConfiguracionService;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jdmp
 */
@Named(value = "configuracionController")
@ViewScoped
public class ConfiguracionController  implements Serializable {
     @Inject
     ConfiguracionService configuracionService;



    public void handleFileUpload(FileUploadEvent event){
        UploadedFile file = event.getFile();        
        
        if(file.getContents().length != 0){
                configuracionService.cargarDivipola(file);
        }        
    }
    
}
