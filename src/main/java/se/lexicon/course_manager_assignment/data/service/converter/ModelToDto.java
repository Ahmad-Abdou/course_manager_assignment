package se.lexicon.course_manager_assignment.data.service.converter;

import org.springframework.stereotype.Component;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;


import java.util.*;

@Component
public class ModelToDto implements Converters {
    @Override
    public StudentView studentToStudentView(Student student) {
        List<Student> studentList = new ArrayList<>();
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o1.getName().compareTo(o2.getName());
            }
        });
        return null;
    }

    @Override
    public CourseView courseToCourseView(Course course) {
        List<Course> courseList = new ArrayList<>();
        Collections.sort(courseList, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {

                return o1.getCourseName().compareTo(o2.getCourseName());
            }
        });

        return null;
    }

    @Override
    public List<CourseView> coursesToCourseViews(Collection<Course> courses) {
        List<Course> coursesList = new ArrayList<>();

        Collections.sort(coursesList, new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return 0;
            }
        });

        return null;
    }

    @Override
    public List<StudentView> studentsToStudentViews(Collection<Student> students) {
        return null;
    }
}
