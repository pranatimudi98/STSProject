package com.telusko.demo.services;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.demo.dao.CourseDao;
import com.telusko.demo.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	public CourseServiceImpl()
	{
		
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long courseId)
	{
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course)
	{
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(Long parseLong)
	{
		//courseDao.delete(courseDao.getOne(parseLong));
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}
}
