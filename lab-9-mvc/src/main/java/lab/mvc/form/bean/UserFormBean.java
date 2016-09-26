package lab.mvc.form.bean;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserFormBean {
	
	public UserFormBean(){}

	@NotEmpty (message="first name must be not null")
	@Size(min = 2, max = 20)
	private String firstName;

	@NotEmpty (message="last name must be not null")
	@Size(min = 2, max = 30)
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
