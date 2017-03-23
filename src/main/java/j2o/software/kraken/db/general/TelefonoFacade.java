package j2o.software.kraken.db.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.general.Telefono;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("telefono")
public class TelefonoFacade extends AbstractFacade<Telefono, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonoFacade() {
        super(Telefono.class);
    }

}
