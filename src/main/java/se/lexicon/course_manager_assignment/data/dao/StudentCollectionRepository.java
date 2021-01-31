package se.lexicon.course_manager_assignment.data.dao;



import se.lexicon.course_manager_assignment.data.sequencers.StudentSequencer;
import se.lexicon.course_manager_assignment.model.Student;

import java.util.*;


public class StudentCollectionRepository implements StudentDao {

    private Collection<Student> students;

    public StudentCollectionRepository(Collection<Student> students) {
        this.students = students;
    }

    @Override
    public Student createStudent(String name, String email, String address) {
        Student student = new Student(name,email,address);
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmailIgnoreCase(String email) {
       for(Student student : students){
           if(email.equalsIgnoreCase(student.getEmail())){
               return student;
           }
       }
               return null;
    }

    @Override
    public Collection<Student> findByNameContains(String name) {
        List<Student> list = new ArrayList<>();
        for(Student student : students){
            if(name.equalsIgnoreCase(student.getName()) ){
            list.add(student);
            }
        }
        return list;
    }

    @Override
    public Student findById(int id) {
        for(Student student : students){
            if(id == student.getId()){
                return student;
            }
        }
        return null;
    }

    @Override
    public Collection<Student> findAll() {

        return students;
    }

    @Override
    public boolean removeStudent(Student student) {
       boolean delete = false;
        Iterator<Student> iterator = students.iterator();
        while(iterator.hasNext()){
            Student output = iterator.next();
            if(output.equals(student)){
                delete = true;
            }
        }
        return delete;
    }
    @Override
    public void clear() {
        this.students = new HashSet<>();
    }
}
