package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.Poblado;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("poblado")
public class PobladoFacade extends AbstractFacade<Poblado, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PobladoFacade() {
        super(Poblado.class);
    }

}
