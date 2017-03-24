package j2o.software.kraken.db.facade.seguridad;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.seguridad.Permiso;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("permiso")
public class PermisoFacade extends AbstractFacade<Permiso, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisoFacade() {
        super(Permiso.class);
    }

}
