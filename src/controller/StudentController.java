package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Studentmodel;

import java.sql.SQLException;

public class StudentController {
    public TableView tblStudentDetails;
    public TableColumn colStudentName;
    public TableColumn colStudent;
    public TableColumn colStudentEmail;
    public TableColumn colStudentContact;
    public TableColumn colStudentAddress;
    public TableColumn colStudentNic;
    public TextField txtid;
    public TextField txtname;
    public TextField txtemail;
    public TextField txtcontact;
    public TextField txtaddress;
    public TextField txtnic;
    public Button btnSave;
    public Button Updatebtn;
    public Button deletebtn;

    public void SaveStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Studentmodel s1 = new Studentmodel(txtid.getText(),txtname.getText(),txtemail.getText(),txtcontact.getText(),txtaddress.getText(),txtnic.getText());

        if (new StudentDataController().saveStudent(s1))
             new Alert(Alert.AlertType.CONFIRMATION,"Saved...").show();
        else
            new Alert(Alert.AlertType.CONFIRMATION,"Try Again...").show();
    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Studentmodel s1 = new Studentmodel(txtid.getText(),txtname.getText(),txtemail.getText(),txtcontact.getText(),txtaddress.getText(),txtnic.getText());

        if (new StudentDataController().updateStudent(s1))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
       else
           new Alert(Alert.AlertType.CONFIRMATION,"Try Again").show();
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        if (new StudentDataController().deleteStudent(txtid.getText())){
           new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
       } else {
           new Alert(Alert.AlertType.WARNING, "Try Again").show();
       }
    }
}
