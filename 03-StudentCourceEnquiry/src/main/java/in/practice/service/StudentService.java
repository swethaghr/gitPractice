package in.practice.service;

import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.practice.binding.Student;
import in.practice.entity.StudentEntity;
import in.practice.repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student s)
	{
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));
		repo.save(entity);
		return true;
	}
	
}
