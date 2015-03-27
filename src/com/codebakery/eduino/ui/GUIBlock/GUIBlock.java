package com.codebakery.eduino.ui.GUIBlock;

import com.codebakery.eduino.block.Block;
import javafx.scene.layout.StackPane;

/**
 * Created by Timo on 15. 3. 27..
 */
public abstract class GUIBlock {
    Block block;
    StackPane degin;

    public abstract void blockDesign();
    public StackPane getBlockPane(){ return degin; }
    public void setBlockData(Block b)
    {
        block = b;
    }
    public Block getBlockData() { return block; }
    public Block getNothing() { return null; }
}