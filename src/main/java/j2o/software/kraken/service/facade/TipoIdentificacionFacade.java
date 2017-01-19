package j2o.software.kraken.service.facade;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import j2o.software.kraken.db.TipoIdentificacion;
import j2o.software.kraken.service.facade.AbstractFacade;

@Stateless
@Named("tipoIdentificacion")
public class TipoIdentificacionFacade extends AbstractFacade<TipoIdentificacion> {

    @PersistenceContext(unitName = "KrakenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIdentificacionFacade() {
        super(TipoIdentificacion.class);
    }

}
