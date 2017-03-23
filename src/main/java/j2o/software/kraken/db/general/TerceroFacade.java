package j2o.software.kraken.db.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.general.Tercero;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("tercero")
public class TerceroFacade extends AbstractFacade<Tercero, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroFacade() {
        super(Tercero.class);
    }

}
