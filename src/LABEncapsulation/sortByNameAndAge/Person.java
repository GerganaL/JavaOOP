package LABEncapsulation.sortByNameAndAge;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() < 3){
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() < 3){
            throw new IllegalStateException("First name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age <= 0){
            throw  new IllegalStateException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public void setSalary(double salary) {
        if(salary < 460){
            throw new IllegalStateException("Salary cannot be less than 460 leva.");

        }
    }

    public void increaseSalary(double bonus) {
        if(getAge() < 30){
            this.salary = this.salary *(1.00 + bonus / 200);
        }else {
            this.salary = this.salary * (1.00 + bonus / 100);
        }
    }
//Asen Ivanov gets 2640.0 leva
    @Override
    public String toString() {
        return String.format("%s %s get %.2f leva",getFirstName(), getLastName(),getSalary());
    }

}
