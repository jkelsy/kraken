package j2o.software.kraken.db.contabilidad.pcga;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.inject.Inject;
import j2o.software.kraken.db.contabilidad.pcga.TipoDocumento;
import j2o.software.kraken.db.AbstractFacade;

@Stateless
@Named("tipoDocumento")
public class TipoDocumentoFacade extends AbstractFacade<TipoDocumento, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDocumentoFacade() {
        super(TipoDocumento.class);
    }

}
