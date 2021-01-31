package se.lexicon.course_manager_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.course_manager_assignment.data.dao.CourseCollectionRepository;
import se.lexicon.course_manager_assignment.data.dao.StudentCollectionRepository;
import se.lexicon.course_manager_assignment.data.service.course.CourseManager;
import se.lexicon.course_manager_assignment.data.service.course.CourseService;
import se.lexicon.course_manager_assignment.dto.forms.CreateCourseForm;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class CourseManagerAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseManagerAssignmentApplication.class, args);
        System.out.println();
        Collection<Course> courses = new ArrayList<>();
        Collection<Student> students = new ArrayList<>();

        StudentCollectionRepository scr  = new StudentCollectionRepository(students);
        CourseCollectionRepository ccr = new CourseCollectionRepository(courses);

        //Creating Student
        System.out.println("Creating new student");
        System.out.println(scr.createStudent("Simon","simon@test.com","Gothenberg"));
        System.out.println(scr.createStudent("ahmad","ahmad@test.se","malmö"));
        System.out.println(scr.createStudent("ahmad","ahmad@test.se","malmö"));
        System.out.println(scr.createStudent("Mehrdad","Mehrdad@test.com","stockholm"));
//
//        //Finding by Email
//        System.out.println("Finding by Email");
//        System.out.println(scr.findByEmailIgnoreCase("ahmad@test.com"));
//
//        //Finding by name
//        System.out.println("Finding by Name");
//        System.out.println(scr.findByNameContains("ahmad"));
//
//        //Finding by ID
//        System.out.println("Finding by ID");
//        System.out.println(scr.findById(3));
//
//        //Finding All
//        System.out.println("Finding All");
//        System.out.println(scr.findAll());
//
//        //Delete Student
//        System.out.print("Delete Student : ");
//        Student student5 ;
//        student5 = scr.createStudent("Simon","simon@test.com","Gothenberg");
//        System.out.println(scr.removeStudent(student5));


        System.out.println("------------------------------------------------------------------------------------");


        //Creating course
        System.out.println("Creating courses");
        System.out.println(ccr.createCourse("Java",LocalDate.of(2021,12,1),12));
        System.out.println(ccr.createCourse("Python",LocalDate.of(2021,3,6),9));
        System.out.println(ccr.createCourse("C#",LocalDate.of(2021,6,9),11));

        //Finding by date before
        System.out.println("Find by date before  "+ccr.findByDateBefore(LocalDate.of(2021,7,30)));
        //Finding by date after
        System.out.println("Find by date after  "+ccr.findByDateAfter(LocalDate.of(2021,7,30)));
        //Find by student ID
        System.out.println(ccr.findByStudentId(2));



//        CourseManager cm = new CourseManager();
//        CreateCourseForm form = new CreateCourseForm(1,"Python",LocalDate.of(2020,5,11),5);
//        System.out.println("Creating course form "+cm.create(form));
//        System.out.println("Searching by Course Name"+cm.searchByCourseName("Python"));
//        System.out.println("Searching by date Before "+cm.searchByDateBefore(LocalDate.of(2021,1,1)));


}

}
