package j2o.software.kraken.db.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.contabilidad.pcga.ComprobanteSaldo;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("comprobanteSaldo")
public class ComprobanteSaldoFacade extends AbstractFacade<ComprobanteSaldo, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComprobanteSaldoFacade() {
        super(ComprobanteSaldo.class);
    }

}
