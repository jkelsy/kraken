package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.ActividadEconomica;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("actividadEconomica")
public class ActividadEconomicaFacade extends AbstractFacade<ActividadEconomica, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadEconomicaFacade() {
        super(ActividadEconomica.class);
    }

}
