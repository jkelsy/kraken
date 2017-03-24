package j2o.software.kraken.db.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.contabilidad.pcga.Modulo;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("modulo")
public class ModuloFacade extends AbstractFacade<Modulo, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ModuloFacade() {
        super(Modulo.class);
    }

}
