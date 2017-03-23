package j2o.software.kraken.db.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.general.Empresa;
import j2o.software.kraken.db.AbstractFacade;

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
