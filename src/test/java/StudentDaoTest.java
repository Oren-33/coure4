import Dao.impl.StudentDao;
import Entity.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    StudentDao studentDao = new StudentDao();
    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("江涵");
        student.setId("4l");
        student.setPassword("12345");
        studentDao.save(student);
    }
    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setName("安洁莉特");
        student.setId("4l");
        studentDao.update(student);

    }
    @Test
    public void testCreateStudent2() {
        Student student = new Student();
        student.setName("艾琳");
        student.setId("1l");
        student.setPassword("12345");
        studentDao.update(student);
    }
    @Test
    public void testDeleteStudent() {
        studentDao.delete("1l");
    }
    @Test
    public void testFindUser() {
        Student s = studentDao.getOne("1l");
        System.out.println(s.getName());

    }
    @Test
    public void testSelectAll() {
        List<Student> list = studentDao.getAll();
        list.forEach(user->System.out.println(user.getName()));
    }
    @Test
    public void testLogin(){
        System.out.println(studentDao.Login("江涵","12345"));
    }




}
