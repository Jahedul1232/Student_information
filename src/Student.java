
public class Student {

    private String id;
    private String name;
   
    private String email;
	private String cgpa;

    public Student() {
    }

    public Student(String id, String name, String cgpa,  String email) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
      
        this.email = email;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contactNo
     */
    public String getCgpa() {
        return cgpa;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    /**
     * @return the address
     */
   

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
