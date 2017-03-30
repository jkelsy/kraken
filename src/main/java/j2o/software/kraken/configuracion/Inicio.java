/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2o.software.kraken.configuracion;

import j2o.software.kraken.db.facade.seguridad.PermisoFacade;
import j2o.software.kraken.db.facade.seguridad.RolFacade;
import j2o.software.kraken.db.facade.seguridad.UsuarioFacade;
import j2o.software.kraken.db.model.contabilidad.pcga.CentroCosto;
import j2o.software.kraken.db.model.general.Empresa;
import j2o.software.kraken.db.model.general.TipoIdentificacion;
import j2o.software.kraken.db.model.seguridad.Permiso;
import j2o.software.kraken.db.model.seguridad.Rol;
import j2o.software.kraken.db.model.seguridad.Usuario;
import j2o.software.kraken.services.contabilidad.pcga.CentroCostoService;
import j2o.software.kraken.services.general.EmpresaService;
import j2o.software.kraken.services.general.TipoIdentificacionService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    @Inject 
    RolFacade rolService;
    @Inject
    UsuarioFacade usuarioService;
    @Inject
    PermisoFacade permisoService;

    @PostConstruct
    public void iniciar() {
        /* PARA TIPO IDENTIFICACION */
        iniciarTipoIdentificacion();
        /* PARA TIPO IDENTIFICACION */

        iniciarEmpresa();

       // Empresa emp = empresaService.getEmpresaFacade().find(1L);
       // miSesion.setMiEmpresa(emp);

        iniciarCentroCosto();
        
        iniciarSeguridadAdministrador();
        iniciarSeguridadContabilidad();
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

    /* SEGURIDAD */
    public void iniciarSeguridadAdministrador(){
        Rol rol = null;
        Usuario usuario = null;
        Permiso permiso = null;        

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nombre", "ADMIN");
        Optional<Rol> rolOptional = rolService.findSingleByNamedQuery("Rol.findByNombre", parameters, Rol.class);

        if (!rolOptional.isPresent()) {
            rol = new Rol();
            rol.setNombre("ADMIN");
            rolService.create(rol);

            parameters.clear();
            parameters.put("login", "admin");

            Optional<Usuario> usuarioOptional = usuarioService.findSingleByNamedQuery("Usuario.findByLogin", parameters, Usuario.class);
            if (!usuarioOptional.isPresent()) {
                MessageDigest md;
                String _password = "admin";
                try {
                    md = MessageDigest.getInstance("SHA-256");
                    byte[] passwordBytes = _password.getBytes();
                    byte[] hash = md.digest(passwordBytes);
                    String passwordHash = Base64.getEncoder().encodeToString(hash);
                    
                    usuario = new Usuario();
                    usuario.setLogin("admin");
                    usuario.setPassword(passwordHash);
                    usuario.setActivo(true);
                    
                    usuarioService.create(usuario);
                    
                } catch (NoSuchAlgorithmException ex) {
                    System.err.println(ex.getMessage());
                }                
            }

            parameters.clear();
            parameters.put("usuarioID", usuario.getId());
            parameters.put("rolID", rol.getId());
            Optional<Permiso> permisoOptional = permisoService.findSingleByNamedQuery("Permiso.findByUsuarioAndRol", parameters, Permiso.class);

            if (!permisoOptional.isPresent()) {
                permiso = new Permiso();
                permiso.setUsuario(usuario);
                permiso.setRol(rol);
                permisoService.create(permiso);
            }
        }
    }
    
    public void iniciarSeguridadContabilidad(){
        Rol rol = null;
        Usuario usuario = null;
        Permiso permiso = null;        

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("nombre", "CONTABILIDAD");
        Optional<Rol> rolOptional = rolService.findSingleByNamedQuery("Rol.findByNombre", parameters, Rol.class);

        if (!rolOptional.isPresent()) {
            rol = new Rol();
            rol.setNombre("CONTABILIDAD");
            rolService.create(rol);

            parameters.clear();
            parameters.put("login", "contabilidad");

            Optional<Usuario> usuarioOptional = usuarioService.findSingleByNamedQuery("Usuario.findByLogin", parameters, Usuario.class);
            if (!usuarioOptional.isPresent()) {
                MessageDigest md;
                String _password = "contabilidad";
                try {
                    md = MessageDigest.getInstance("SHA-256");
                    byte[] passwordBytes = _password.getBytes();
                    byte[] hash = md.digest(passwordBytes);
                    String passwordHash = Base64.getEncoder().encodeToString(hash);
                    
                    usuario = new Usuario();
                    usuario.setLogin("contabilidad");
                    usuario.setPassword(passwordHash);
                    usuario.setActivo(true);
                    
                    usuarioService.create(usuario);
                    
                } catch (NoSuchAlgorithmException ex) {
                    System.err.println(ex.getMessage());
                }                
            }

            parameters.clear();
            parameters.put("usuarioID", usuario.getId());
            parameters.put("rolID", rol.getId());
            Optional<Permiso> permisoOptional = permisoService.findSingleByNamedQuery("Permiso.findByUsuarioAndRol", parameters, Permiso.class);

            if (!permisoOptional.isPresent()) {
                permiso = new Permiso();
                permiso.setUsuario(usuario);
                permiso.setRol(rol);
                permisoService.create(permiso);
            }
        }
    }
}
