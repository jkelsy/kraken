package j2o.software.kraken.db.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.contabilidad.pcga.PlanUnicoCuentas;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("planUnicoCuentas")
public class PlanUnicoCuentasFacade extends AbstractFacade<PlanUnicoCuentas, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanUnicoCuentasFacade() {
        super(PlanUnicoCuentas.class);
    }

}
