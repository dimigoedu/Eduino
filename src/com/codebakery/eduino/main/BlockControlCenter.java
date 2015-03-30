package com.codebakery.eduino.main;

import com.codebakery.eduino.Block.Block;
import com.codebakery.eduino.Block.ListBlock;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.ArrangeBlock;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping.BlockGroup;
import com.codebakery.eduino.GUI.BlockUI.GUIBLockUtil.GUIListBlock;
import com.codebakery.eduino.GUI.BlockUI.GUIBlock;

import java.util.ArrayList;

/**
 * Created by Timo on 15. 3. 29..
 */
public class BlockControlCenter {

    public static ArrayList<Block> globalBlockList;

    public GUIBlock getLast(GUIBlock block)
    {
        GUIBlock guiBlock = block;
        while(guiBlock.getNextGUIBlock() != null)
        {
            guiBlock = guiBlock.getNextGUIBlock();
        }
        return guiBlock;

    }

}
