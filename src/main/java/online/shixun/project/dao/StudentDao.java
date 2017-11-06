package online.shixun.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	private DataSource dataSource;
	
	private Connection getConnection(){
		Connection conn=DataSourceUtils.getConnection(dataSource);
		return conn;
	}
	/**
	 * 保存学生信息
	 * @param userName
	 * @return
	 * @throws SQLException
	 */
	public int addStudent(String userName) throws SQLException{
		int insertId=-1;
		/*
		 * 插入
		 */
		Connection conn=getConnection();
		String sql="insert into student (studentName) values(?) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, userName);
		ps.executeUpdate();

		//寻找id
		Connection conn1=getConnection();
		String sql1="select id from student where studentName=?";
		PreparedStatement ps1=conn1.prepareStatement(sql1);
		ps1.setString(1, userName);
		ResultSet rs=ps1.executeQuery();
		while(rs.next()){
			for(int i=1;i<2;i++){
				insertId=rs.getInt(i);
			}
		}
		return insertId;
	}
	
	public void addStudentScore(int studentId) throws SQLException{
		Connection conn=getConnection();
		String sql="insert into student_score values(1,?,'C语言',90) ";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, studentId);
		ps.executeUpdate();

		throw new RuntimeException();
	}
}
