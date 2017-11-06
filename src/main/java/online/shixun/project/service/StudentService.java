package online.shixun.project.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shixun.project.dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	@Transactional
	public void addStudent(String userName) throws SQLException{
		int studentId=studentDao.addStudent(userName);
		studentDao.addStudentScore(studentId);
	}
}
