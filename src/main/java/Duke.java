package duke.driver;

import duke.command.Command;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.ui.DialogBox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Represents a instance of Duke which is the main driver of the program.
 */
public class Duke extends Application {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image user = new Image("https://raw.githubusercontent.com/sianghwee/duke/master/tutorials/assets/DaUser.png");
    private Image duke = new Image("https://raw.githubusercontent.com/sianghwee/duke/master/tutorials/assets/DaDuke.png");

    public Duke() {
        this("test.txt");
    }
    /**
     * Creates the Duke object which has a db file tagged to it.
     * 
     * @param filename the filename of the file to be referenced to
     */
    public Duke(String filename) {
        ui = new Ui();
        storage = new Storage(filename);
        tasks = new TaskList(storage.load());
    }

    /**
     * Runs the program.
     */
    public void run() {
        ui.welcome();
        String fullCommand;
        while (ui.hasNext() && !(fullCommand = ui.readCommand()).equals("bye")) {
            ui.printLine();
            Command c = Parser.parse(fullCommand);
            System.out.println(c.execute(tasks, ui, storage));
            ui.printLine();
        }
        ui.byeMessage();
    }

//    /**
//     * The main driver of the program. Takes in the file to be referenced as a
//     * command line argument. If no file is given, then the default file "test.txt"
//     * is used.
//     *
//     * @param args command line arguments that could include the filename of the
//     *             file to be used
//     */
//    public static void main(String[] args) {
//        if (args.length == 0) {
//            new Duke("test.txt").run();
//        } else {
//            new Duke(args[0]).run();
//        }
//    }

    @Override
    public void start(Stage stage) {
        //The container for the content of the chat to scroll.
        scrollPane = new ScrollPane();
        dialogContainer = new VBox();
        scrollPane.setContent(dialogContainer);

        userInput = new TextField();
        sendButton = new Button("Send");

        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(scrollPane, userInput, sendButton);

        scene = new Scene(mainLayout);

        stage.setScene(scene);
        stage.show();

        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setMinHeight(600.0);
        stage.setMinWidth(400.0);

        mainLayout.setPrefSize(400.0, 600.0);

        scrollPane.setPrefSize(385, 535);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        scrollPane.setVvalue(1.0);
        scrollPane.setFitToWidth(true);

        // You will need to import `javafx.scene.layout.Region` for this.
        dialogContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);

        userInput.setPrefWidth(325.0);

        sendButton.setPrefWidth(55.0);

        AnchorPane.setTopAnchor(scrollPane, 1.0);

        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 1.0);

        AnchorPane.setLeftAnchor(userInput , 1.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);

        //Step 3. Add functionality to handle user input.
        sendButton.setOnMouseClicked((event) -> {
            handleUserInput();
        });

        userInput.setOnAction((event) -> {
            handleUserInput();
        });

        //Scroll down to the end every time dialogContainer's height changes.
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));
    }

    private void handleUserInput() {
        Label userText = new Label(userInput.getText());
        Command c = getResponse(userInput.getText());
        Label dukeText = new Label(c.execute(tasks, ui, storage));
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, new ImageView(user)),
                DialogBox.getDukeDialog(dukeText, new ImageView(duke))
        );
        userInput.clear();

        if(c.isExit()){
            Platform.exit();
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    private Command getResponse(String input) {
        return Parser.parse(input);
    }
}