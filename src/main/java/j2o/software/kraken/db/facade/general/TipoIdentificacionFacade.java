package j2o.software.kraken.db.facade.general;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.model.general.TipoIdentificacion;
import j2o.software.kraken.db.facade.AbstractFacade;

@Stateless
@Named("tipoIdentificacion")
public class TipoIdentificacionFacade extends AbstractFacade<TipoIdentificacion, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIdentificacionFacade() {
        super(TipoIdentificacion.class);
    }

}
