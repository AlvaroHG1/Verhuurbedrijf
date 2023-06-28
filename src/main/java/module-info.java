module com.example.verhuurbedrijf {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.verhuurbedrijf to javafx.fxml;
    exports com.example.verhuurbedrijf;
    exports com.example.verhuurbedrijf.soorten;
    opens com.example.verhuurbedrijf.soorten to javafx.fxml;
}