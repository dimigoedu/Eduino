package com.codebakery.eduino.Block;

import com.codebakery.eduino.GUI.BlockUI.GUIBlock;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Timo on 15. 3. 27..
 */
public abstract class Block {
    Block child;
    Block parent;
    GUIBlock guiBlock;

    public Boolean hasChild()
    {
        if(child != null)
            return true;
        else
            return false;
    }
    public Boolean hasParent()
    {
        if(parent != null)
            return true;
        else
            return false;
    }
    public Block getChild()
    {
        return child;
    }
    public Block getParent()
    {
        return parent;
    }
    public void setGuiBlock(GUIBlock gui)
    {
        this.guiBlock = gui;
    }
    public GUIBlock getGuiBlock()
    {
        return this.guiBlock;
    }
    public void setChild(Block block)
    {
        this.child = block;
    }
    public void setParent(Block block)
    {
        this.parent = block;
    }


}
