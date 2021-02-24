package LABabstraction.studentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s is %s years old.",getName(),getAge()));

        if (getGrade() >= 5.00) {
            output.append(" Excellent student.");
        } else if (getGrade() >= 3.50) {
           output.append(" Average student.");
        } else {
           output.append(" Very nice person.");
        }

        return output.toString();
    }
}
