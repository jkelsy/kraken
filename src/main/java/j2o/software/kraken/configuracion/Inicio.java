/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.configuracion;

import j2o.software.kraken.db.model.contabilidad.pcga.CentroCosto;
import j2o.software.kraken.db.model.general.Empresa;
import j2o.software.kraken.db.model.general.TipoIdentificacion;
import j2o.software.kraken.services.contabilidad.pcga.CentroCostoService;
import j2o.software.kraken.services.general.EmpresaService;
import j2o.software.kraken.services.general.TipoIdentificacionService;
import java.sql.Date;
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

    @Inject
    TipoIdentificacionService tipoIdentificacionService;
    @Inject
    MiSesion miSesion;
    @Inject
    EmpresaService empresaService;
    @Inject
    CentroCostoService centroCostoService;

    @PostConstruct
    public void iniciar() {
        /* PARA TIPO IDENTIFICACION */
        iniciarTipoIdentificacion();
        /* PARA TIPO IDENTIFICACION */

        iniciarEmpresa();

       // Empresa emp = empresaService.getEmpresaFacade().find(1L);
       // miSesion.setMiEmpresa(emp);

        iniciarCentroCosto();
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
 /* PARA EMPRESA */
    public void iniciarEmpresa() {
        Empresa empresaInstance;
        String[] listaTipoId1 = {"9999999", "8888888", "7777777", "66666666"};
        String[] listaTipoId2 = {"Empresa1", "Empresa2", "Empresa3", "Empresa4"};
        String[] listaTipoId3 = {"Direccion1", "Direccion2", "Direccion3", "Direccion4"};

        int i = 0;
        for (String item : listaTipoId1) {
            List<Empresa> lista = empresaService.findAllByIdentificacion(item);
            if (lista == null || lista.isEmpty()) {
                empresaInstance = new Empresa();
                empresaInstance.setIdentificacion(item);
                empresaInstance.setNombre(listaTipoId2[i]);
                empresaInstance.setDireccion(listaTipoId3[i]);

                empresaService.getEmpresaFacade().create(empresaInstance);
            }

            i++;
        }
    }

    /* PARA EMPRESA */
 /* PARA EMPRESA */
    public void iniciarCentroCosto() {
        CentroCosto centroCostoInstance;
        String[] listaTipoId1 = {"9999999", "9999999", "9999999", "8888888", "7777777", "7777777"};
        String[] listaTipoId2 = {"E1-001", "E1-002", "E1-003", "E2-001", "E3-001", "E3-002"};
        String[] listaTipoId3 = {"Administracion", "Sistemas", "Auditoria", "Administracion", "Administracion", "Tesoreria"};
        String[] listaTipoId4 = {"Si", "Si", "No", "Si", "Si", "No"};
        String[] listaTipoId5 = {"1", "1", "2", "1", "1", "1"};
        String[] listaTipoId6 = {"10", "5", "1", "2", "3", "6"};

        int i = 0;
        for (String item : listaTipoId1) {
            Empresa emp = empresaService.findAllByIdentificacion(item).get(0);
            if (emp != null) {

                List<CentroCosto> lista = centroCostoService.findAllByEmpresaAndCodigo(emp.getId(), listaTipoId2[i]);
                if (lista == null || lista.isEmpty()) {

                    //Date f = new Date();
                    centroCostoInstance = new CentroCosto();
                    centroCostoInstance.setEmpresa(emp);
                    centroCostoInstance.setCodigo(listaTipoId2[i]);
                    centroCostoInstance.setNombre(listaTipoId3[i]);
                    centroCostoInstance.setPertenece(listaTipoId4[i]);
                    centroCostoInstance.setNivel(listaTipoId5[i]);
                    centroCostoInstance.setNivelFinal(listaTipoId6[i]);
                    //centroCostoInstance.setFecha(f);
                    centroCostoService.getCentroCostoFacade().create(centroCostoInstance);
                }

                i++;
            }
        }
    }

    /* PARA EMPRESA */
}
