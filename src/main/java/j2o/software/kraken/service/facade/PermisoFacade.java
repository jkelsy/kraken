package j2o.software.kraken.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import j2o.software.kraken.db.Permiso;
import j2o.software.kraken.service.facade.AbstractFacade;

@Stateless
@Named("permiso")
public class PermisoFacade extends AbstractFacade<Permiso> {

    @PersistenceContext(unitName = "KrakenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisoFacade() {
        super(Permiso.class);
    }

}
