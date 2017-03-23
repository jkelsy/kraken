package j2o.software.kraken.db.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.contabilidad.pcga.AsientoContable;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("asientoContable")
public class AsientoContableFacade extends AbstractFacade<AsientoContable, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsientoContableFacade() {
        super(AsientoContable.class);
    }

}
