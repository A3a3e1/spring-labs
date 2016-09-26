import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import lab.model.Country;
import lab.model.UsualPerson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:application-context.xml"})
public class SpringTCFAppTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "resources/application-context.xml";
	private AbstractApplicationContext context;

	@Autowired
	private UsualPerson person;

	private UsualPerson expectedPerson;
	

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(
				new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		person=context.getBean(UsualPerson.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setHeight(1.78F);
		person.setIsProgrammer(true);
		person.setName("John Smith");

		Country country = new Country();
		country.setId(1);
		country.setName("Ukraine");
		country.setCodeName("UA");

		person.setCountry(country);

		List<String> contacts = new ArrayList<String>();
		contacts.add("asd@asd.ru");
		contacts.add("+7-234-456-67-89");

		person.setContacts(contacts);

		return person;
	}

}
