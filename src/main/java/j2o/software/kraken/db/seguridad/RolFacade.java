package j2o.software.kraken.db.seguridad;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.seguridad.Rol;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("rol")
public class RolFacade extends AbstractFacade<Rol, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

}
