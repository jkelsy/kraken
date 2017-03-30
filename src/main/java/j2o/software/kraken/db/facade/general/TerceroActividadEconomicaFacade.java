package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.TerceroActividadEconomica;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("terceroActividadEconomica")
public class TerceroActividadEconomicaFacade extends AbstractFacade<TerceroActividadEconomica, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerceroActividadEconomicaFacade() {
        super(TerceroActividadEconomica.class);
    }

}
