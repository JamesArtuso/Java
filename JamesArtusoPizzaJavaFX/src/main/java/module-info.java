module com.example.project4_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    opens projectpackage to javafx.fxml;
    exports projectpackage;
}