package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.Direccion;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("direccion")
public class DireccionFacade extends AbstractFacade<Direccion, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }

}
