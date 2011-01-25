package net.sb;

// Generated 29-nov-2010 23.51.06 by Hibernate Tools 3.4.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Estrazioni.
 * @see net.sb.Estrazioni
 * @author Hibernate Tools
 */
@Stateless
public class EstrazioniHome {

	private static final Log log = LogFactory.getLog(EstrazioniHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Estrazioni transientInstance) {
		log.debug("persisting Estrazioni instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Estrazioni persistentInstance) {
		log.debug("removing Estrazioni instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Estrazioni merge(Estrazioni detachedInstance) {
		log.debug("merging Estrazioni instance");
		try {
			Estrazioni result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Estrazioni findById(Integer id) {
		log.debug("getting Estrazioni instance with id: " + id);
		try {
			Estrazioni instance = entityManager.find(Estrazioni.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
