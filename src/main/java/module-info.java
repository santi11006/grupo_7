module org.example.proyecto_grupo7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires java.desktop;


    opens org.example.proyecto_grupo7 to javafx.fxml;
    exports org.example.proyecto_grupo7;
}