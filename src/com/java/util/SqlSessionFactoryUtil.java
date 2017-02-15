package com.java.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


//mybatis数据库连接工具
public class SqlSessionFactoryUtil {
	//单例的工厂
	private static SqlSessionFactory sqlSessionFactory;
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream inputStream = null;
			try {
				//输入流读取mybatis配置文件
				inputStream = Resources.getResourceAsStream("mybatis-config.xml");
				//获取配置文件的输入流
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;//返回一个工厂
	}

	//数据库连接
	public static SqlSession openSession(){
		return getSqlSessionFactory().openSession();
	}
}
