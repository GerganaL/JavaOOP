package LABSOLID.p05_DependencyInversion.p01_HelloWord;

import LABSOLID.p05_DependencyInversion.p03_Database.Courses;
import LABSOLID.p05_DependencyInversion.p03_Database.CoursesDatabase;
import LABSOLID.p05_DependencyInversion.p03_Database.Data;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Courses courses = new Courses(new Data());
        Courses courses2 = new Courses(new CoursesDatabase());


    }
}
