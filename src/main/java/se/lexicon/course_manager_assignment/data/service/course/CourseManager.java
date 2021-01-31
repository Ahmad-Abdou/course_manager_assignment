package se.lexicon.course_manager_assignment.data.service.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.course_manager_assignment.data.dao.CourseDao;
import se.lexicon.course_manager_assignment.data.dao.StudentDao;
import se.lexicon.course_manager_assignment.data.service.converter.Converters;
import se.lexicon.course_manager_assignment.dto.forms.CreateCourseForm;
import se.lexicon.course_manager_assignment.dto.forms.UpdateCourseForm;
import se.lexicon.course_manager_assignment.dto.views.CourseView;
import se.lexicon.course_manager_assignment.dto.views.StudentView;
import se.lexicon.course_manager_assignment.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CourseManager  implements CourseService {

    private final CourseDao courseDao;
    private final StudentDao studentDao;
    private final Converters converters;
    List<CourseView>cva;


    @Autowired
    public CourseManager(CourseDao courseDao, StudentDao studentDao, Converters converters) {
        this.courseDao = courseDao;
        this.studentDao = studentDao;
        this.converters = converters;

    }


    @Override
    public CourseView create(CreateCourseForm form) {
        List<StudentView>studentViews = new ArrayList<>();
        studentViews.add(new StudentView(1,"ahmad","kyoub@asd.se","asd"));
        CourseView cv = new CourseView(form.getId(),form.getCourseName(),form.getStartDate(),form.getWeekDuration(),studentViews);
        cva.add(cv);
        return cv;
    }

    @Override
    public CourseView update(UpdateCourseForm form) {

        return null;
    }

    @Override
    public List<CourseView> searchByCourseName(String courseName) {
        List<CourseView> courseList = new ArrayList<>();
        for (CourseView courses : cva) {
            if (courseName.equalsIgnoreCase(courses.getCourseName())) {
                courseList.add(courses);
            }
        }
        return courseList;
    }

    @Override
    public List<CourseView> searchByDateBefore(LocalDate end) {
        List<CourseView> course = new ArrayList<>();
        for (CourseView courses : cva) {
            if (end.isBefore(courses.getStartDate())) {
                course.add(courses);
            }
        }
        return course;
    }

    @Override
    public List<CourseView> searchByDateAfter(LocalDate start) {
        return null;
    }

    @Override
    public boolean addStudentToCourse(int courseId, int studentId) {

        return false;
    }

    @Override
    public boolean removeStudentFromCourse(int courseId, int studentId) {
        return false;
    }

    @Override
    public CourseView findById(int id) {

        return null;
    }

    @Override
    public List<CourseView> findAll() {
        return null;
    }

    @Override
    public List<CourseView> findByStudentId(int studentId) {
        return null;
    }

    @Override
    public boolean deleteCourse(int id) {
        return false;
    }
}
