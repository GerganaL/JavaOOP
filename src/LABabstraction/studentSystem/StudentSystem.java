package LABabstraction.studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> students;

    public StudentSystem() {
        this.students = new HashMap<>();
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    public void checkForStudent(String[] input) {
        if (input[0].equals("Create")) {
            String name = input[1];
            int age = Integer.parseInt(input[2]);
            double grade = Double.parseDouble(input[3]);
            addNewStudent(name, age, grade);
        } else if (input[0].equals("Show")) {
            String name = input[1];
            if (contains(students,name)) {
                System.out.println(students.get(name).toString());
            }
        }
    }

    private void addNewStudent(String name, int age, double grade) {
        if (!contains(students, name)) {
            Student student = new Student(name, age, grade);
           addStudentToMap(name,student);
        }
    }

    private Student addStudentToMap(String name, Student student){
       return students.put(name,student);
    }

    private boolean contains(Map<String,Student> students, String name){
        return students.containsKey(name);
    }
}
