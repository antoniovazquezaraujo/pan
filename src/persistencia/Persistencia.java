package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Persistencia {
	private static EntityManagerFactory emf;

	private static EntityManager em;

	public static void start() {
		emf = Persistence.createEntityManagerFactory("panaderia");
	}

	public static void stop() {
		if (emf != null) {
			if (em != null) {
				em.close();
			}
			emf.close();
		}
	}

	public static void createEM() {
		if (em == null) {
			em = emf.createEntityManager();
			em.setFlushMode(FlushModeType.AUTO);
		}
	}

	public static void add(Object data) {
		createEM();
		try {
			em.getTransaction().begin();
			em.persist(data);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public static void remove(Object data) {
		createEM();
		try {
			em.getTransaction().begin();
			em.remove(data);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public static void save(Object data) {
		createEM();
		try {
			em.getTransaction().begin();
			em.merge(data);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public static Object load(Class c, Object key) {
		createEM();
		Object ret = em.find(c, key);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public static List load(Class c) {
		createEM();
		Query q = em.createQuery("SELECT c from " + c.getSimpleName() + " c");
		List ret = q.getResultList();
		return ret;
	}

	public static List load(String query) {
		createEM();
		Query q = em.createQuery(query);
		List ret = q.getResultList();
		return ret;
	}

	public static Query createQuery(String s) {
		return em.createQuery(s);
	}

}
