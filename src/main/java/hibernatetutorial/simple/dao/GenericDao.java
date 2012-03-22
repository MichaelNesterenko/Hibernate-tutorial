package hibernatetutorial.simple.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public abstract class GenericDao<T, PkId extends Serializable> {
	private Session session;

	private Class<T> eClass;

	public GenericDao(final Session s, final Class<T> cls) {
		if (s == null) {
			throw new NullPointerException("Session can not be null");
		}
		if (cls == null) {
			throw new NullPointerException("Class can not be null");
		}
		session = s;
		eClass = cls;
	}

	protected Session getSession() {
		return session;
	}

	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public T get(PkId id) {
		return (T) getSession().get(eClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(final int startFrom, final int count) {
		String entityName = getSession().getSessionFactory().getClassMetadata(eClass).getEntityName();
		Query q = getSession().createQuery("from " + entityName);
		q.setFirstResult(startFrom);
		q.setMaxResults(count);
		return q.list();
	}

	public long getTotalCount() {
		String entityName = getSession().getSessionFactory().getClassMetadata(eClass).getEntityName();
		return (Long) getSession().createQuery("select count(*) from " + entityName).uniqueResult();
	}

}
