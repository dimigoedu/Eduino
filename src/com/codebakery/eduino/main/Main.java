package com.codebakery.eduino.main;

import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping.BlockGroup;
import com.codebakery.eduino.GUI.BlockUI.GUIBLockUtil.DragBlockBoard;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    public static Pane root;
    public static DragBlockBoard dragBlockBoard;
    @Override
    public void start(Stage primaryStage) throws Exception{
        root = new Pane();
        //String image_url = //"/Users/Timo/IdeaProjects/Eduino/src/com/codebakery/eduino/GUI/BlockUI/BlockDesign/BlockResource/block1.png";
        Image image = new Image("file:GUI/BlockUI/BlockDesign/BlockResource/block1.png");

        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        root.getChildren().add(iv1);

        iv1.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.print("Detect");
                /* allow any transfer mode */
                Dragboard db = iv1.startDragAndDrop(TransferMode.ANY);
                event.consume();
            }
        });

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
    public static void addNode(Node node)
    {
        root.getChildren().add(node);
    }
    public static void deleteNode(Node node)
    {
        root.getChildren().remove(node);
    }

    public static void setDragBlockBoard(BlockGroup blockGroup)
    {
        dragBlockBoard.setBlockGroup(blockGroup);
    }
    public static void clearDragBlockBoard()
    {
        dragBlockBoard.clear();
    }
}
