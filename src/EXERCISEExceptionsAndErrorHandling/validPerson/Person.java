package EXERCISEExceptionsAndErrorHandling.validPerson;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age){
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public void setFirstName(String firstName) {
        validateName(firstName,"first name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateName(lastName,"last name");
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age < 0 || age > 120){
            throw  new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private void validateName(String name, String param){
        if(name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("The " + param + " cannot be null or empty");
        }
    }
}
