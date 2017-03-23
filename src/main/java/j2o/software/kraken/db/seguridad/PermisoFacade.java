package j2o.software.kraken.db.seguridad;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.seguridad.Permiso;
import j2o.software.kraken.db.AbstractFacade;

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
