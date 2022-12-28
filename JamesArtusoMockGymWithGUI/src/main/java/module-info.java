module com.example.project3 {
    requires javafx.controls;
    requires javafx.fxml;


    exports projectpackage;
    opens projectpackage to javafx.fxml;
}