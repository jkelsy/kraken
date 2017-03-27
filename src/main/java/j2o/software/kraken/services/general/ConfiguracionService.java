/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.services.general;

import j2o.software.kraken.db.facade.general.DepartamentoFacade;
import j2o.software.kraken.db.facade.general.MunicipioFacade;
import j2o.software.kraken.db.model.general.Departamento;
import j2o.software.kraken.db.model.general.Municipio;
import j2o.software.kraken.db.model.general.Poblado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author jdmp
 */
@Stateless
@Named("configuracionService")
public class ConfiguracionService {
     @Inject
    private DepartamentoFacade df;
    @Inject
    private MunicipioFacade mf;
    @Inject
    private PobladoService pobladoService;

       
    

     public void cargarDivipola(UploadedFile divipola) { 
        System.out.println("Inicianco el cargue...");
        
        if (df.findAll().isEmpty()) {
            System.out.println("En blanco..."+divipola);
            try (InputStream is = divipola.getInputstream()) {
                System.out.println("Lectura de archivo...");
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "ISO-8859-3"));
                String line;
                String[] record;

                br.readLine();//Descartar la fila donde están los encabezados.

                String[] recordInicial = br.readLine().split(";");
                String codDpto = recordInicial[0];
                String codMpio = recordInicial[1];

                Departamento departamento = new Departamento();
                departamento.setCodigo(codDpto);
                departamento.setNombre(recordInicial[3]);
                df.create(departamento);

                Municipio municipio = new Municipio();
                municipio.setCodigo(codMpio);
                municipio.setNombre(recordInicial[4]);
                municipio.setDepartamento(departamento);

                mf.create(municipio);

                Poblado poblado = new Poblado();
                poblado.setCodigo(recordInicial[2]);
                poblado.setNombre(recordInicial[5]);
                poblado.setMunicipio(municipio);
                pobladoService.getFachada().create(poblado);

                while ((line = br.readLine()) != null) {
                    record = line.split(";");
                    if(!codDpto.equals(record[0])){
                        codDpto = record[0];
                        departamento = new Departamento();
                        departamento.setCodigo(codDpto);
                        departamento.setNombre(record[3]);
                        df.create(departamento);
                    }
                    
                    if(!codMpio.equals(record[1])){
                        codMpio = record[1];
                        municipio = new Municipio();
                        municipio.setCodigo(codMpio);
                        municipio.setNombre(record[4]);
                        municipio.setDepartamento(departamento);
                        mf.create(municipio);
                    }
                    
                    poblado = new Poblado();
                    poblado.setCodigo(record[2]);
                    poblado.setNombre(record[5]);
                    poblado.setMunicipio(municipio);
                    pobladoService.getFachada().create(poblado);
                }

            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }

    }
   
}
