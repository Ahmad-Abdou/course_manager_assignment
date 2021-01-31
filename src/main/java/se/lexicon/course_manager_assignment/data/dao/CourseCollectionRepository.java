package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.model.Course;
import se.lexicon.course_manager_assignment.model.Student;

import java.time.LocalDate;
import java.util.*;


public class CourseCollectionRepository implements CourseDao{

    private Collection<Course> courses;


    public CourseCollectionRepository(Collection<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Course createCourse(String courseName, LocalDate startDate, int weekDuration) {
        Course course = new Course(courseName,startDate,weekDuration);
        courses.add(course);
        return course;
    }


    @Override
    public Course findById(int id) {
        for(Course course : courses){
            if(id == course.getId()){
                return course;
            }
        }
        return null;
    }

    @Override
    public Collection<Course> findByNameContains(String name) {
        List<Course> list = new ArrayList<>();
        for(Course course : courses){
            if(name.equalsIgnoreCase(course.getCourseName()) ){
                list.add(course);
            }
        }
        return list;
    }

    @Override
    public Collection<Course> findByDateBefore(LocalDate end) {
        List<Course> courseList = new ArrayList<>();
        for(Course course : courses){
            if(course.getStartDate().isBefore(end)){
                courseList.add(course);
            }
        }
        return courseList;

    }

    @Override
    public Collection<Course> findByDateAfter(LocalDate start) {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStartDate().isAfter(start)) {
                courseList.add(course);
            }
        }
        return courseList;
    }

    @Override
    public Collection<Course> findAll() {
        return courses;
    }

    @Override
    public Collection<Course> findByStudentId(int studentId) {
        List<Course> courseList = new ArrayList<>();
        for (Course course : courses) {
            if (course.getId() == studentId) {
                courseList.add(course);
            }
        }
        return courseList;
    }


    @Override
    public boolean removeCourse(Course course) {
        boolean delete = false;
        Iterator <Course>iterator = courses.iterator();
        while (iterator.hasNext()){
            Course output = iterator.next();
            if(output.equals(course))
            delete = true;
        }
        return delete;
    }

    @Override
    public void clear() {
        this.courses = new HashSet<>();
    }
}
