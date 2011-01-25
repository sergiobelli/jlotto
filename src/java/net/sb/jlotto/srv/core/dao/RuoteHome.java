package net.sb;

// Generated 29-nov-2010 23.51.06 by Hibernate Tools 3.4.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Ruote.
 * @see net.sb.Ruote
 * @author Hibernate Tools
 */
@Stateless
public class RuoteHome {

	private static final Log log = LogFactory.getLog(RuoteHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Ruote transientInstance) {
		log.debug("persisting Ruote instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Ruote persistentInstance) {
		log.debug("removing Ruote instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Ruote merge(Ruote detachedInstance) {
		log.debug("merging Ruote instance");
		try {
			Ruote result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Ruote findById(Integer id) {
		log.debug("getting Ruote instance with id: " + id);
		try {
			Ruote instance = entityManager.find(Ruote.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
