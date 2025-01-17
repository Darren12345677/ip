package roofus;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Roofus roofus = new Roofus();

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/user.png"));
    private Image roofusImage = new Image(this.getClass().getResourceAsStream("/images/roofus.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        dialogContainer.getChildren().add(
                DialogBox.getRoofusDialog(roofus.greet(), roofusImage));
    }

    /**
     * Initialise Roofus with an instance.
     *
     * @param f
     */
    public void setRoofus(Roofus f) {
        roofus = f;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Roofus' reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = roofus.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getRoofusDialog(response, roofusImage)
        );
        userInput.clear();
    }
}
