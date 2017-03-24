package j2o.software.kraken.db.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.contabilidad.pcga.Periodo;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("periodo")
public class PeriodoFacade extends AbstractFacade<Periodo, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodoFacade() {
        super(Periodo.class);
    }

}
