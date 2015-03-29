package com.codebakery.eduino.GUI.BlockUI;

import com.codebakery.eduino.Block.Block;
import com.codebakery.eduino.GUI.BlockUI.BlockDesign.BlockDesign;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping.BlockGroup;
import com.codebakery.eduino.GUI.BlockUI.GUIBLockUtil.GUIListBlock;
import com.codebakery.eduino.main.Main;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * Created by Timo on 15. 3. 28..
 */
public abstract class GUIBlock extends StackPane{
    Block block;
    BlockDesign design;
    BlockGroup group;

    public abstract void setApperance();
    public void setBlock()
    {
        this.setOnMousePressed(OnMousePressedEventHandler);
    }
    public Block getBlock(){
        return block;
    }
    public GUIListBlock getNextGUIBlocks()
    {
        GUIListBlock blocks = null;
        Block block = this.block;
        do {
            blocks.add(block.getGuiBlock());
            block = block.getChild();
        }while(block !=null);

        return blocks;
    }
    public void clearGroupBlock()
    {
        Main.deleteNode(this.group);
        this.group = null;
    }
    EventHandler<MouseEvent> OnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    for(GUIBlock block1 : getNextGUIBlocks())
                    {
                        Main.deleteNode(block1);
                    }
                    group = new BlockGroup(getNextGUIBlocks());
                    Main.setDragBlockBoard(group);
                }
            };

}
