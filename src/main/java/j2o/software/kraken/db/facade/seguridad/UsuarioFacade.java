package j2o.software.kraken.db.facade.seguridad;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.seguridad.Usuario;
import j2o.software.kraken.db.facade.AbstractFacade;

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
