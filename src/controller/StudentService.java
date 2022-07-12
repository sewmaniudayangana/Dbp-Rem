package controller;



import model.Studentmodel;

import java.sql.SQLException;
import java.util.ArrayList;


public interface StudentService {
    public boolean saveStudent(Studentmodel s) throws SQLException,ClassNotFoundException;
    public boolean updateStudent(Studentmodel s) throws SQLException,ClassNotFoundException;
    public boolean deleteStudent(Studentmodel s) throws SQLException,ClassNotFoundException;
    public Studentmodel getStudent(Studentmodel s) throws SQLException,ClassNotFoundException;
    public ArrayList<Studentmodel>getAllStudent() throws SQLException,ClassNotFoundException;

}
