package j2o.software.kraken.db.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.contabilidad.pcga.Naturaleza;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("naturaleza")
public class NaturalezaFacade extends AbstractFacade<Naturaleza, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NaturalezaFacade() {
        super(Naturaleza.class);
    }

}
