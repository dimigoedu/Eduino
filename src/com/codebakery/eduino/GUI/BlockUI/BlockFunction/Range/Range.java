package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range;

import com.codebakery.eduino.GUI.BlockUI.BlockFunction.BlockPoint;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane.DownRange;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane.UpRange;
import com.codebakery.eduino.GUI.BlockUI.GUIBlock;

/**
 * Created by Timo on 15. 3. 28..
 */
public class Range{

    public Range(GUIBlock block) {

        DownRange downRange;
        UpRange upRange;

        Boolean hasChild = false;
        Boolean hasParent = false;

        BlockPoint blockPoint = new BlockPoint(block.getLayoutX(),block.getLayoutY());

        if(block.getBlock().hasChild())
            hasChild=true;
        if(block.getBlock().hasParent())
            hasParent=true;

        if(hasChild && hasParent)
        {
            upRange = null;
            downRange = new DownRange(false,blockPoint.getX(),blockPoint.getY(),block.getHeight());
        }
        else if(hasChild && !hasParent)
        {
            downRange = new DownRange(false,blockPoint.getX(),blockPoint.getY(),block.getHeight());
            upRange = new UpRange(true,blockPoint.getX(),blockPoint.getY(),block.getHeight());
        }
        else if(!hasChild && hasParent) {
            upRange = null;
            downRange = new DownRange(true, blockPoint.getX(), blockPoint.getY(),block.getHeight());
        }
        else
        {
            downRange = new DownRange(true,blockPoint.getX(),blockPoint.getY(),block.getHeight());
            upRange = new UpRange(true,blockPoint.getX(),blockPoint.getY(),block.getHeight());
        }

    }



}
