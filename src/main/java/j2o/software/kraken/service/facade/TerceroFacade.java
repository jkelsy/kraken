package j2o.software.kraken.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import j2o.software.kraken.db.Tercero;

@Stateless
@Named("tercero")
public class TerceroFacade extends AbstractFacade<Tercero, Long> {

    @PersistenceContext(unitName = "KrakenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroFacade() {
        super(Tercero.class);
    }

}
