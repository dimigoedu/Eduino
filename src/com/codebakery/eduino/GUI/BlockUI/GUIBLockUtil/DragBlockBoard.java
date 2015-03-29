package com.codebakery.eduino.GUI.BlockUI.GUIBLockUtil;

import com.codebakery.eduino.Block.Block;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping.BlockGroup;

/**
 * Created by Timo on 15. 3. 29..
 */
public class DragBlockBoard {

    public static BlockGroup blockGroup;

    public DragBlockBoard()
    {
        blockGroup = null;
    }

    public static Boolean hasBlockGroup()
    {
        if(blockGroup != null)
            return true;
        else
            return false;

    }
    public static void setBlockGroup(BlockGroup block)
    {
        blockGroup = block;
    }
    public static BlockGroup getBlockGroup()
    {
        return blockGroup;
    }

    public static void clear()
    {
        blockGroup = null;
    }
}
