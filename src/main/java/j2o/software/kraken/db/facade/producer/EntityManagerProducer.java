package j2o.software.kraken.db.facade.producer;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Producer for injectable EntityManager
 *
 */
public class EntityManagerProducer {

    @Produces
    @PersistenceContext(unitName = "KrakenPU")
    private EntityManager em;
}
