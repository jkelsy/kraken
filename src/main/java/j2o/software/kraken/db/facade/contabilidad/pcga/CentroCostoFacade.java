package j2o.software.kraken.db.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.contabilidad.pcga.CentroCosto;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("centroCosto")
public class CentroCostoFacade extends AbstractFacade<CentroCosto, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CentroCostoFacade() {
        super(CentroCosto.class);
    }

}
