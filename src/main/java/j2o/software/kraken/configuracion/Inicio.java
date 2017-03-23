/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.configuracion;

import j2o.software.kraken.db.general.TipoIdentificacion;
import j2o.software.kraken.services.general.TipoIdentificacionService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author jdmp
 */
@Startup
@Singleton
public class Inicio {
    @Inject TipoIdentificacionService tipoIdentificacionService;
    
    
    @PostConstruct
    public void iniciar() {
        /* PARA TIPO IDENTIFICACION */
        iniciarTipoIdentificacion();
        /* PARA TIPO IDENTIFICACION */
        

    }

     /* PARA TIPO IDENTIFICACION */
    public void iniciarTipoIdentificacion() {
        TipoIdentificacion tipoIdentificacionInstance;
        String[] listaTipoId1 = {"01", "02", "03", "04", "05", "06"};
        String[] listaTipoId2 = {"CC", "CE", "PAS", "RC", "NUIP", "NIT"};
        String[] listaTipoId3 = {"Cedula Ciudadania", "Cedula de Extrangeria", "Pasaporte", "Registro Civil", "Numero Unico Identificacion Personal", "Numero de Indetificacion Tributaria"};

        int i = 0;
        for (String item : listaTipoId1) {
            List<TipoIdentificacion> lista = tipoIdentificacionService.findAllByCodigo(item);
            if (lista == null || lista.isEmpty()) {
                tipoIdentificacionInstance = new TipoIdentificacion();
                tipoIdentificacionInstance.setCodigo(item);
                tipoIdentificacionInstance.setAbreviatura(listaTipoId2[i]);
                tipoIdentificacionInstance.setDescripcion(listaTipoId3[i]);

                tipoIdentificacionService.getTipoIdentificacionFacade().create(tipoIdentificacionInstance);
            }

            i++;
        }
    }

    /* PARA TIPO IDENTIFICACION */ 
}
