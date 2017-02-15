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


//测试数据库连接
public class StudentTest {
	
	private static Logger logger = Logger.getLogger(StudentTest.class);
	private SqlSession sqlSession = null;//打开数据库连接
	private StudentMapper studentMapper = null; //映射器
	private GradeMapper gradeMappere = null;
	@Before   //测试方法执行之前调用
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		studentMapper = sqlSession.getMapper(StudentMapper.class);
		gradeMappere = sqlSession.getMapper(GradeMapper.class);
	}

	@After    //测试方法执行之后调用
	public void tearDown() throws Exception {
		sqlSession.close();
	}

	/*@Test      //查找学生     一对一关联映射
	public void tesSelectStudentWithAddress(){
		logger.info("查找学生(带地址)");
		Student student = studentMapper.selectStudentWithAddress(1);
		System.out.println(student);
		
	}*/
	
	/*@Test      //查找学生     一对多关联映射
	public void tesSelectGradeWithStudent(){
		logger.info("查找学生(带地址)");
		Grade grade = gradeMappere.findById(1);
		System.out.println(grade);
		List<Student> studentList = grade.getStudents();
		for(Student student:studentList){
			System.out.println(student);
		}
	}*/
	@Test
	public void tesSelectStudentWithAddressAndGrade(){
		logger.info("查找学生(带地址)");
		Student student = studentMapper.selectStudentByGradeIdAndAddress(1);
		System.out.println(student);
		
	}
}
