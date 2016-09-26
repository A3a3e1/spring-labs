import static org.junit.Assert.*;

import lab.model.Person;
import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.model.UsualPerson;
import lab.model.Country;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;
import java.util.ArrayList;

public class SimpleAppTest {
	
	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "resources/application-context.xml";

	private AbstractApplicationContext context;

	private UsualPerson expectedPerson;
	private Person person;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(
                new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		//TODO get UsualPerson from Context here
//		FYI: Another way to achieve the bean
		person = context.getBean(UsualPerson.class);
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
