package com.java;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.java.mappers.GradeMapper;
import com.java.mappers.StudentMapper;
import com.java.model.Grade;
import com.java.model.Student;
import com.java.util.SqlSessionFactoryUtil;


//�������ݿ�����
public class StudentTest {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession = null;//�����ݿ�����
	private StudentMapper studentMapper = null; //ӳ����
	private GradeMapper gradeMappere = null;
	@Before   //���Է���ִ��֮ǰ����
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
		gradeMappere = sqlSession.getMapper(GradeMapper.class);
	}

	@After    //���Է���ִ��֮�����
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	/*@Test      //����ѧ��     һ��һ����ӳ��
	public void tesSelectStudentWithAddress(){
		logger.info("����ѧ��(����ַ)");
		Student student = studentMapper.selectStudentWithAddress(1);
		System.out.println(student);
		
	}*/
	
	/*@Test      //����ѧ��     һ�Զ����ӳ��
	public void tesSelectGradeWithStudent(){
		logger.info("����ѧ��(����ַ)");
		Grade grade = gradeMappere.findById(1);
		System.out.println(grade);
		List<Student> studentList = grade.getStudents();
		for(Student student:studentList){
			System.out.println(student);
		}
	}*/
	@Test
	public void tesSelectStudentWithAddressAndGrade(){
		logger.info("����ѧ��(����ַ)");
		Student student = studentMapper.selectStudentByGradeIdAndAddress(1);
		System.out.println(student);
		
	}
}
