package net.sb;

// Generated 29-nov-2010 23.51.06 by Hibernate Tools 3.4.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Configurazione.
 * @see net.sb.Configurazione
 * @author Hibernate Tools
 */
@Stateless
public class ConfigurazioneHome {

	private static final Log log = LogFactory.getLog(ConfigurazioneHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Configurazione transientInstance) {
		log.debug("persisting Configurazione instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Configurazione persistentInstance) {
		log.debug("removing Configurazione instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Configurazione merge(Configurazione detachedInstance) {
		log.debug("merging Configurazione instance");
		try {
			Configurazione result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Configurazione findById(Integer id) {
		log.debug("getting Configurazione instance with id: " + id);
		try {
			Configurazione instance = entityManager.find(Configurazione.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
