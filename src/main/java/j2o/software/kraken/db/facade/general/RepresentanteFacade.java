package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.Representante;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("representante")
public class RepresentanteFacade extends AbstractFacade<Representante, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepresentanteFacade() {
        super(Representante.class);
    }

}
