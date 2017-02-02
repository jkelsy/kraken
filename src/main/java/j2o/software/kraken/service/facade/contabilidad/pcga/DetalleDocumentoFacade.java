package j2o.software.kraken.service.facade.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import j2o.software.kraken.db.contabilidad.pcga.DetalleDocumento;
import j2o.software.kraken.service.facade.AbstractFacade;

@Stateless
@Named("detalleDocumento")
public class DetalleDocumentoFacade extends AbstractFacade<DetalleDocumento> {

    @PersistenceContext(unitName = "KrakenPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDocumentoFacade() {
        super(DetalleDocumento.class);
    }

}
