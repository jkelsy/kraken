package j2o.software.kraken.db.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.general.Representante;
import j2o.software.kraken.db.AbstractFacade;

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
