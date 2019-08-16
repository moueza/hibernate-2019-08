package example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/** https://www.tutorialspoint.com/hibernate/hibernate_examples.htm */
//https://www.baeldung.com/hibernate-mappingexception-unknown-entity
//https://stackoverflow.com/questions/23554803/hibernate-serviceregistrybuilder-deprecated
public class Cause4MappingExceptionIntegrationTest {

	@Test
	public void givenEntityIsPersisted_thenException() throws IOException {
//SessionFactory sessionFactory = configureSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.saveOrUpdate(new Foo());

		session.saveOrUpdate(new Employee2());
session.getTransaction().commit();
	}

	private SessionFactory configureSessionFactory() throws IOException {
		Configuration configuration = new Configuration();
		// configuration.configure();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("hibernate-mysql.properties");
		Properties hibernateProperties = new Properties();
		hibernateProperties.load(inputStream);
		configuration.setProperties(hibernateProperties);

		// configuration.addAnnotatedClass(Foo.class);

//		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
//				.buildServiceRegistry();
//		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();

//		https://stackoverflow.com/questions/23554803/hibernate-serviceregistrybuilder-deprecatedreturn sessionFactory;
		return sf;
	}
}