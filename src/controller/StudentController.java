package controller;

import Tm.StudentTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Studentmodel;

import java.sql.SQLException;
import java.util.ArrayList;

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

    public void initialize() {
        try {
            colStudent.setCellFactory(new PropertyValueFactory<>("Id"));
            colStudentName.setCellFactory(new PropertyValueFactory<>("name"));
            colStudentEmail.setCellFactory(new PropertyValueFactory<>("email"));
            colStudentContact.setCellFactory(new PropertyValueFactory<>("contact"));
            colStudentAddress.setCellFactory(new PropertyValueFactory<>("address"));
            colStudentNic.setCellFactory(new PropertyValueFactory<>("Nic"));

            setStudentToTable(new StudentDataController().getAllStudent());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setStudentToTable(ArrayList<Studentmodel> studentmodels) {
        ObservableList<StudentTm> obList = FXCollections.observableArrayList();
        studentmodels.forEach(e ->
                obList.add(new StudentTm(e.getId(), e.getName(), e.getEmail(), e.getContact(), e.getAddress(), e.getNIC())));
                tblStudentDetails.setItems(obList);
    }
    



    public void SaveStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Studentmodel s1 = new Studentmodel(txtid.getText(), txtname.getText(), txtemail.getText(), txtcontact.getText(), txtaddress.getText(), txtnic.getText());

        if (new StudentDataController().saveStudent(s1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved...").show();
        else
            new Alert(Alert.AlertType.CONFIRMATION, "Try Again...").show();
    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Studentmodel s1 = new Studentmodel(txtid.getText(), txtname.getText(), txtemail.getText(), txtcontact.getText(), txtaddress.getText(), txtnic.getText());

        if (new StudentDataController().updateStudent(s1))
            new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
        else
            new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
    }

    public void DeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

       /* if (new StudentDataController().deleteStudent(txtid.getText())){
           new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
       } else {
           new Alert(Alert.AlertType.WARNING, "Try Again").show();
       }*/
    }

}
