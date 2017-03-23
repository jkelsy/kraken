package j2o.software.kraken.db.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.contabilidad.pcga.DetalleSaldoTercero;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("detalleSaldoTercero")
public class DetalleSaldoTerceroFacade extends AbstractFacade<DetalleSaldoTercero, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleSaldoTerceroFacade() {
        super(DetalleSaldoTercero.class);
    }

}
