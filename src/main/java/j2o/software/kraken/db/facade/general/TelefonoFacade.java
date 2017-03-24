package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.Telefono;
import j2o.software.kraken.db.facade.AbstractFacade;

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
