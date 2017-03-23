package j2o.software.kraken.db.seguridad;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.seguridad.Usuario;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("usuario")
public class UsuarioFacade extends AbstractFacade<Usuario, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

}
