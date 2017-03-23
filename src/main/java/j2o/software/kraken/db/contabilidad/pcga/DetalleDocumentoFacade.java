package j2o.software.kraken.db.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.contabilidad.pcga.DetalleDocumento;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("detalleDocumento")
public class DetalleDocumentoFacade extends AbstractFacade<DetalleDocumento, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDocumentoFacade() {
        super(DetalleDocumento.class);
    }

}
