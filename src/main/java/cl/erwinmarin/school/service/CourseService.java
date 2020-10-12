package cl.erwinmarin.school.service;

import cl.erwinmarin.school.model.Course;
import cl.erwinmarin.school.repository.CourseRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public ArrayList<Course> findAll(){
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public Optional<Course> findAllById(Long id){
        return courseRepository.findById(id);
    }

    public void deleteById(Long id)
    {
        courseRepository.deleteById(id);
    }

    public boolean updateById(long id, Course course){
        Optional<Course> courseData = courseRepository.findById(id);

        if (courseData.isPresent()) {
            Course _course = courseData.get();
            _course.setCode(course.getCode());
            _course.setName(course.getName());
            _course.setStudent(course.getStudent());
            courseRepository.save(_course);
            return true;
        }
        else {
            return false;
        }
    }

}
