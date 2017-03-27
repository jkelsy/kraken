package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.Municipio;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("municipio")
public class MunicipioFacade extends AbstractFacade<Municipio, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }

}
