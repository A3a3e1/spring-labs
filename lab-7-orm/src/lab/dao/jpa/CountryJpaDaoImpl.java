package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager entityManager = emf.createEntityManager();
		if (entityManager != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(country);
			tx.commit();
			entityManager.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {

		EntityManager entityManager = emf.createEntityManager();
		List<Country> countryList = null;
		if (entityManager != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			countryList = entityManager.createQuery("from Country", Country.class).getResultList();
			tx.commit();
			entityManager.close();
			return countryList;
		}
		return countryList;
	}

	@Override
	public Country getCountryByName(String name) {
		EntityManager entityManager = emf.createEntityManager();
		Country country = null;
		if (entityManager != null) {
			EntityTransaction tx = entityManager.getTransaction();
			tx.begin();
			country = entityManager.createQuery("SELECT c FROM Country c WHERE c.name LIKE :name", Country.class)
					.setParameter("name", name).getSingleResult();
			tx.commit();
			entityManager.close();
		}
		return country;
	}

}
