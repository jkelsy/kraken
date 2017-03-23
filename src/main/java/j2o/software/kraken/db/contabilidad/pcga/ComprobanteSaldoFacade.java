package j2o.software.kraken.db.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.contabilidad.pcga.ComprobanteSaldo;
import j2o.software.kraken.db.AbstractFacade;

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
