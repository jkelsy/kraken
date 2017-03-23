package j2o.software.kraken.db.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.contabilidad.pcga.PlanUnicoCuentas;
import j2o.software.kraken.db.AbstractFacade;

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
