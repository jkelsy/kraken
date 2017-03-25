package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.TipoContribuyente;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("tipoContribuyente")
public class TipoContribuyenteFacade extends AbstractFacade<TipoContribuyente, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoContribuyenteFacade() {
        super(TipoContribuyente.class);
    }

}
