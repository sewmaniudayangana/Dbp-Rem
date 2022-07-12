package controller;

import db.DbConnection;
import model.Studentmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataController implements StudentService {

    public List<String> getStudentIds() throws SQLException,ClassNotFoundException{
        ResultSet rst = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM  StudentF").executeQuery();
        List<String> ids = new ArrayList<>();
        while (rst.next()){
            ids.add(rst.getString(1)
            );
        }
        return ids;
    }


    @Override
    public boolean saveStudent(Studentmodel s) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO StudentF VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,s.getId());
        stm.setObject(2,s.getName());
        stm.setObject(3,s.getEmail());
        stm.setObject(4,s.getContact());
        stm.setObject(5,s.getAddress());
        stm.setObject(6,s.getNIC());
        return stm.executeUpdate()>0;

    }

    @Override
    public boolean updateStudent(Studentmodel s) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("UPDATE StudentF SET name=?,email=?,contact=?,address=?,NIC=? WHERE id=?");
        stm.setObject(1,s.getName());
        stm.setObject(2,s.getEmail());
        stm.setObject(3,s.getContact());
        stm.setObject(4,s.getAddress());
        stm.setObject(5,s.getNIC());
        stm.setObject(6,s.getId());

        return stm.executeUpdate()>0;
    }

    @Override
    public boolean deleteStudent(Studentmodel s) throws SQLException, ClassNotFoundException {
        if (DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM StudentF WHERE id='"+s+"'").executeUpdate()>0){
             return true;
        } else {
            return false;
        }
    }

    @Override
    public Studentmodel getStudent(Studentmodel s) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM StudentF WHERE id=?");
        stm.setObject(1,s);
        ResultSet rst = stm.executeQuery();
        if(rst.next()) {
            return  new Studentmodel(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)

            );
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Studentmodel> getAllStudent() throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT *FROM StudentF");
        ResultSet rst = stm.executeQuery();
        ArrayList<Studentmodel> students = new ArrayList<>();
        while (rst.next()){
            students.add(new Studentmodel(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)


            ));
        }
        return students;
    }
}
