package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping;

import com.codebakery.eduino.Block.Block;
import com.codebakery.eduino.Block.ListBlock;
import com.codebakery.eduino.GUI.BlockUI.GUIBlock;
import com.codebakery.eduino.GUI.BlockUI.GUIBLockUtil.GUIListBlock;
import com.codebakery.eduino.main.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Created by Timo on 15. 3. 28..
 */
public class BlockGroup extends VBox{

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    GUIBlock rootBlock;

    public BlockGroup(GUIListBlock listBlock)
    {
        rootBlock = listBlock.get(0);
        for(GUIBlock block : listBlock) {
            this.setHeight(this.getHeight()+block.getHeight());
            this.getChildren().add(block);
        }
        this.setLayoutX(listBlock.get(0).getLayoutX());
        this.setLayoutY(listBlock.get(0).getLayoutY());
        this.setOnMousePressed(OnMousePressedEventHandler);
        this.setOnMouseDragged(OnMouseDraggedEventHandler);
    }
    public BlockGroup(int start_index,GUIListBlock listBlock)
    {
        rootBlock = listBlock.get(0);
        for(int i = start_index;i<listBlock.size();i++) {
            this.setHeight(this.getHeight() + listBlock.get(i).getHeight());
            this.getChildren().add(listBlock.get(i));
        }
        this.setLayoutX(listBlock.get(start_index).getLayoutX());
        this.setLayoutY(listBlock.get(start_index).getLayoutY());
        this.setOnMousePressed(OnMousePressedEventHandler);
        this.setOnMouseDragged(OnMouseDraggedEventHandler);
        this.setOnMouseReleased(OnMouseReleaseEventHandler);
    }

    public BlockGroup(int start_index,int end_index,GUIListBlock listBlock)
    {
        rootBlock = listBlock.get(0);
        for(int i = start_index;i<=end_index;i++) {
            this.setHeight(this.getHeight() + listBlock.get(i).getHeight());
            this.getChildren().add(listBlock.get(i));
        }
        this.setLayoutX(listBlock.get(start_index).getLayoutX());
        this.setLayoutY(listBlock.get(start_index).getLayoutY());
        this.setOnMousePressed(OnMousePressedEventHandler);
        this.setOnMouseDragged(OnMouseDraggedEventHandler);
    }
    public GUIBlock getRootBlock()
    {
        return this.rootBlock;
    }

    public GUIListBlock getGUIListBlock()
    {
        GUIBlock block = this.getRootBlock();
        GUIListBlock listBlock = null;
        listBlock.add(block);
        while(block.getNextGUIBlock() != null)
        {
            block = block.getNextGUIBlock();
            listBlock.add(block);
        }
        return listBlock;

    }

    public ListBlock getListBlock()
    {
        Block block = this.getRootBlock().getBlock();
        ListBlock listBlock = null;
        listBlock.add(block);
        while(block.getChild() != null)
        {
            block = block.getChild();
            listBlock.add(block);
        }
        return listBlock;
    }


    EventHandler<MouseEvent> OnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Main.setDragBlockBoard((BlockGroup)t.getSource());
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((BlockGroup)(t.getSource())).getTranslateX();
                    orgTranslateY = ((BlockGroup)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> OnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((BlockGroup)(t.getSource())).setTranslateX(newTranslateX);
                    ((BlockGroup)(t.getSource())).setTranslateY(newTranslateY);
                }
            };

    EventHandler<MouseEvent> OnMouseReleaseEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    Main.clearDragBlockBoard();
                    rootBlock.clearGroupBlock();
                }
            };

}
