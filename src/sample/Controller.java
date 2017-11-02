
package sample;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.Properties;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.TextField;
        import javafx.stage.Modality;
        import javafx.stage.Stage;

public class Controller {
    FileInputStream fis;
    Properties property = new Properties();
    @FXML
    TextField EmailTextField;
    @FXML
    TextField NoteTextField;

    public Controller() {
    }

    public void SettingButton(ActionEvent event) throws Exception {
        try {
            Stage stage = new Stage();
            Parent SettingsScene = (Parent)FXMLLoader.load(this.getClass().getResource("Settings1.fxml"));
            stage.setTitle("Настройки");
            stage.setMinHeight(150.0D);
            stage.setMinWidth(300.0D);
            stage.setResizable(false);
            stage.setScene(new Scene(SettingsScene));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public void SendNowButton(ActionEvent event) throws IOException {
        this.fis = new FileInputStream("src/sample/settings.properties");
        this.property.load(this.fis);
        String emailPr;
        emailPr = this.property.getProperty("db.email", "skosinka@yandex.ru1");
        String email = "skosinka@yandex.ru";
        System.out.println("Send... " + emailPr);
        SendEmail sendEmail = new SendEmail(emailPr, "test");
        sendEmail.sendMessage("Test");
        this.fis.close();
    }

    public void Send5MinButton(ActionEvent event) {
        System.out.println("test");
    }

    public void SendXMinButton(ActionEvent event) {
        System.out.println("test");
    }

    public void SettingsOK(ActionEvent event) throws IOException {
        String email = this.EmailTextField.getText();
        this.fis = new FileInputStream("src/sample/settings.properties");
        this.property.load(this.fis);
        this.property.setProperty("db.email", email);
        this.NoteTextField.setText(email);
        this.fis.close();
    }
}
