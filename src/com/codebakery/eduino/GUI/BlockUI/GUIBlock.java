package com.codebakery.eduino.GUI.BlockUI;

import com.codebakery.eduino.Block.Block;
import com.codebakery.eduino.GUI.BlockUI.BlockDesign.BlockDesign;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping.BlockGroup;
import javafx.scene.layout.StackPane;

/**
 * Created by Timo on 15. 3. 28..
 */
public abstract class GUIBlock extends StackPane{
    Block block;
    BlockDesign design;
    BlockGroup group;

    public abstract void setApperance();
    public abstract void setBlock();
    public Block getBlock(){
        return block;
    }

}
