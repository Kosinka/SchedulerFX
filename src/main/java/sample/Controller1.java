
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
        import javafx.scene.control.Button;
        import javafx.scene.control.TextField;
        import javafx.stage.Modality;
        import javafx.stage.Stage;

public class Controller1 {
    FileInputStream fis;
    Properties property = new Properties();
    @FXML
    TextField EmailTextField;
    @FXML
    TextField NoteTextField;
    @FXML
    private Button SendNowButtonID;


    public Controller1() {
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
        emailPr = this.property.getProperty("db.email", "skosinka@yandex.ru");
        SendNowButtonID.setText("3");
        Seller(emailPr);
        SendNowButtonID.setText("3");
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
        this.NoteTextField.setText("1");
        this.fis.close();
    }

    private void Seller(String emailPr){
        SendEmail1 sendEmail = new SendEmail1(emailPr, "test");
        SendNowButtonID.setText("1");
        sendEmail.sendMessage("Test");
        SendNowButtonID.setText("2");
    }
}
