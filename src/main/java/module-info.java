module com.example.f23assignment1comp1011 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.f23assignment1comp1011 to javafx.fxml;
    exports com.example.f23assignment1comp1011;
}