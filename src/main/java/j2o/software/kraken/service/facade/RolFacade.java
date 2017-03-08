package j2o.software.kraken.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import j2o.software.kraken.db.Rol;
import j2o.software.kraken.service.facade.AbstractFacade;

@Stateless
@Named("rol")
public class RolFacade extends AbstractFacade<Rol> {

    @PersistenceContext(unitName = "KrakenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

}
