package online.shixun.project.test;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import online.shixun.project.service.StudentService;

@Component
public class SpringTXTest {
	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application.xml");
		SpringTXTest st=ctx.getBean(SpringTXTest.class);
		st.testAddStudent();
		System.out.println("hello");
		((ClassPathXmlApplicationContext)ctx).close();
	}
	public void testAddStudent() throws SQLException{
		studentService.addStudent("小明");
	}
}
