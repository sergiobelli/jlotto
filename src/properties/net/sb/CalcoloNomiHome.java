package net.sb;

// Generated 29-nov-2010 23.51.06 by Hibernate Tools 3.4.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CalcoloNomi.
 * @see net.sb.CalcoloNomi
 * @author Hibernate Tools
 */
@Stateless
public class CalcoloNomiHome {

	private static final Log log = LogFactory.getLog(CalcoloNomiHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CalcoloNomi transientInstance) {
		log.debug("persisting CalcoloNomi instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CalcoloNomi persistentInstance) {
		log.debug("removing CalcoloNomi instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CalcoloNomi merge(CalcoloNomi detachedInstance) {
		log.debug("merging CalcoloNomi instance");
		try {
			CalcoloNomi result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CalcoloNomi findById(Integer id) {
		log.debug("getting CalcoloNomi instance with id: " + id);
		try {
			CalcoloNomi instance = entityManager.find(CalcoloNomi.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
