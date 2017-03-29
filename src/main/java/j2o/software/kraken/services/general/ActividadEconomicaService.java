/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;




import j2o.software.kraken.db.facade.general.ActividadEconomicaFacade;
import j2o.software.kraken.db.model.general.ActividadEconomica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("actividadEconomicaService")
public class ActividadEconomicaService implements Serializable {

    @Inject
    ActividadEconomicaFacade fachada;

    public ActividadEconomicaFacade getFachada() {
        return fachada;
    }

    

     public List<ActividadEconomica> findAllByCodigo(String codigo) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codigo", codigo);
        return fachada.findByNamedQuery("ActividadEconomica.findAllByCodigo", parameters);
    }
     
     
     public void cargarActividadEconomica(UploadedFile archivo) { 
        System.out.println("Inicianco el cargue...");
        
        if (fachada.findAll().isEmpty()) {
            
            try (InputStream is = archivo.getInputstream()) {
                System.out.println("Lectura de archivo...");
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "ISO-8859-3"));
                String line;
                String[] record;

                br.readLine();//Descartar la fila donde están los encabezados.


                while ((line = br.readLine()) != null) {
                    record = line.split(";");
                    
                    String codigo = record[0];
                    String nombre = record[1];
                    
                    List<ActividadEconomica> acList = findAllByCodigo(record[0]);
                    
                    if (acList == null){
                        ActividadEconomica ac = new ActividadEconomica();
                        ac.setCodigo(codigo);
                        ac.setNombre(nombre);
                        fachada.create(ac);
                    }
                    
                }

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }

    }
     

}
