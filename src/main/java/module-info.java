module calcu.calcu {
    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires com.almasb.fxgl.all;
    requires java.desktop;
    requires javafx.media;

    opens calcu.calcu to javafx.fxml;
    exports calcu.calcu;
    exports calcu.data;
    opens calcu.data to javafx.fxml;
}