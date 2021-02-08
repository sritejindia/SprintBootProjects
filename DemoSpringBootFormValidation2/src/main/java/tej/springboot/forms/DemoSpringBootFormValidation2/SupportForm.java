package tej.springboot.forms.DemoSpringBootFormValidation2;

import javax.validation.constraints.*;

public class SupportForm {

    @NotNull
    @Min(value = 10000, message = "Customer ID should be >=10000")
    private Long id;

    @NotNull
    @Size(min = 5, max = 20)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    private String gender;

    @NotNull
    private String membership;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9 ]{3,255}", message = "please enter only letters and numbers")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SupportForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", membership='" + membership + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
