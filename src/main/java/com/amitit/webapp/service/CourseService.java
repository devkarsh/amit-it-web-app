package com.amitit.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amitit.webapp.Dto.BatchDTO;
import com.amitit.webapp.Dto.CourseDTO;
import com.amitit.webapp.Dto.CourseResponseDTO;
import com.amitit.webapp.Dto.SyllabusDTO;
import com.amitit.webapp.Dto.VideoDTO;
import com.amitit.webapp.customException.CheckCourse;
import com.amitit.webapp.customException.CourseDelectionException;
import com.amitit.webapp.entity.Batch;
import com.amitit.webapp.entity.Course;
import com.amitit.webapp.entity.Syllabus;
import com.amitit.webapp.entity.Video;
import com.amitit.webapp.repository.CourseRepository;



@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseResponseDTO addCourse(CourseDTO dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());

        // Map syllabus
        if (dto.getSyllabus() != null) {
            Syllabus s = new Syllabus();
            s.setFilePath(dto.getSyllabus().getFilePath());
         // s.setFilePath(dto.getSyllabus().getFilepath());
           //s.setName(dto.getSyllabus().getName()); 
            course.setSyllabus(s);
        }
       
        List<Video> videoList = new ArrayList<>();
        if (dto.getVideos() != null) {
            for (VideoDTO videoDTO : dto.getVideos()) {
                Video v = new Video();
                v.setName(videoDTO.getName());
                v.setDate(videoDTO.getDate());
                v.setSize(videoDTO.getSize());
                v.setDuration(videoDTO.getDuration());
                v.setLocation(videoDTO.getLocation());
                v.setCourse(course);
                videoList.add(v);
            }
        }
        course.setVideos(videoList);

        // Map batches
        List<Batch> batchList = new ArrayList<>();
        if (dto.getBatches() != null) {
            for (BatchDTO batchDTO : dto.getBatches()) {
                Batch b = new Batch();
                b.setName(batchDTO.getName());
                b.setStartDate(batchDTO.getStartDate());
                b.setEndDate(batchDTO.getEndDate());
                b.setTime(batchDTO.getTime());
                b.setFees(batchDTO.getFee());
                b.setSeats(batchDTO.getSeats());
                b.setCourse(course);
                batchList.add(b);
            }
        }
        course.setBatches(batchList);
         //store course data
        courseRepository.save(course);
        return convertToDTO(course);
    }

    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> responseList = new ArrayList<>();
        for (Course course : courses) {
            responseList.add(convertToDTO(course));
        }
        return responseList;
    }

    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CheckCourse("Course not found with ID: " + id));
        return convertToDTO(course);
    }

    public void deleteCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CheckCourse("Course not found with ID: " + id));

        if (course.getBatches() != null && !course.getBatches().isEmpty()) {
            throw new CourseDelectionException("Cannot delete course with existing batches");
// CourseDelectionException("Cannot delete course with existing batches.");
        }

        courseRepository.deleteById(id);
    }

    private CourseResponseDTO convertToDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getCid());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        dto.setDuration(course.getDuration());

        
        if (course.getSyllabus() != null) {
            SyllabusDTO s = new SyllabusDTO();
            s.setFilePath(course.getSyllabus().getFilePath());
           // s.setName(course.getSyllabus().getName());
           
            dto.setSyllabus(s);
        }

        

        // Batches
        List<BatchDTO> batchDTOList = new ArrayList<>();
        if (course.getBatches() != null) {
            for (Batch b : course.getBatches()) {
                BatchDTO batchDTO = new BatchDTO();
                batchDTO.setName(b.getName());
                batchDTO.setStartDate(b.getStartDate());
                batchDTO.setEndDate(b.getEndDate());
                batchDTO.setTime(b.getTime());
                batchDTO.setFee(b.getFees());
                batchDTO.setSeats(b.getSeats());
                batchDTOList.add(batchDTO);
            }
        }
        dto.setBatches(batchDTOList);

        return dto;
    }
}
