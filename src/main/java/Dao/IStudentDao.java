package Dao;

import Entity.Student;

public interface IStudentDao extends IBaseDao<Student> {
    boolean Login(String username,String password);
}
