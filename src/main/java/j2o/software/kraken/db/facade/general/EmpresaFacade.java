package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.Empresa;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("empresa")
public class EmpresaFacade extends AbstractFacade<Empresa, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }

}
