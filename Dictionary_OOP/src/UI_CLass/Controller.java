package UI_CLass;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import static DictionaryClass.Dictionary.dictionary_list;

public class Controller implements Initializable {

    //khung cua chuong trinh

    @FXML
    private AnchorPane Main_App;

    @FXML
    private AnchorPane Top_App;

    // các biến thao tác tìm kiếm từ

    @FXML
    private HBox Search_Box;

    @FXML
    private Pane Search_Pane;

    @FXML
    private TextField Search_Text_Field;

    @FXML
    private JFXButton Search_Cancel;

    @FXML
    private JFXButton Search_Button;

    @FXML
    private JFXListView<String> Search_ListView;

    @FXML
    private JFXButton Search_Left;

    @FXML
    private JFXButton Search_Right;


    //phần kết quả

    @FXML
    private WebView Result_WebView;


    //các biến liên quan
    private Stack<String> Stack_left = new Stack<String>();
    private Stack<String> Stack_right = new Stack<String>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Search_ListView.getItems().add("hello");
        Search_ListView.getItems().add("strange");

        Search_Text_Field.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (Search_Text_Field.getLength() != 0) {
                    String Search_Word = Search_Text_Field.getText();
                    if (event.getCode().equals(KeyCode.ENTER)) {
                        Search_A_Word(Search_Word);
                    }
                    else {
                        Search_Cancel.setVisible(true);
                        Search_ListView.setVisible(true);
                    }
                }
                else {
                    Search_Cancel.setVisible(false);
                    Search_ListView.setVisible(false);
                }
            }
        });

        Search_Cancel.setOnMouseClicked(event -> {
            Search_Text_Field.setText("");
            Search_Cancel.setVisible(false);
            Search_ListView.setVisible(false);
        });

        Search_ListView.setOnMouseClicked(event -> {
            String Chosen_Word = Search_ListView.getSelectionModel().getSelectedItem();
            Search_A_Word(Chosen_Word);
        });
        Search_Button.setOnMouseClicked(event -> {
            if (Search_Text_Field.getLength() != 0) {
                String Search_Word = Search_Text_Field.getText();
                Search_A_Word(Search_Word);
                Result_WebView.getEngine().loadContent(dictionary_list.get(1).getWord_explain());
                Result_WebView.setVisible(true);
            }
        });

    }

    public void Search_A_Word(String SWord) {
        Search_Text_Field.setText(SWord);
        Search_ListView.setVisible(false);
        Search_Cancel.setVisible(true);
    }

    //hello nguyenquangdang 18012001 239024u09



}