package lab.mvc.form.bean;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class CountryFormBean {

    public CountryFormBean(){}

    @NotEmpty(message="first name must be not null")
    @Size(min = 2, max = 20)
    private String name;

    @NotEmpty (message="last name must be not null")
    @Size(min = 2, max = 30)
    private String codeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return "Country [name=" + name + ", codeName=" + codeName + "]";
    }
}
