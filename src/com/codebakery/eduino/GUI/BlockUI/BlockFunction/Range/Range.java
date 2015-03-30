package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range;

import com.codebakery.eduino.GUI.BlockUI.BlockFunction.ArrangeBlock;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.BlockPoint;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane.DownRange;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane.UpRange;
import com.codebakery.eduino.GUI.BlockUI.GUIBlock;
import com.codebakery.eduino.main.Main;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;

import java.util.ArrayList;

/**
 * Created by Timo on 15. 3. 28..
 */
public class Range{

    DownRange downRange;
    UpRange upRange;
    GUIBlock block;

    BlockPoint blockPoint;

    Boolean hasChild;
    Boolean hasParent;

    public Range(GUIBlock block) {
        this.block = block;
        this.blockPoint = new BlockPoint(this.block.getLayoutX(),this.block.getLayoutY());
        childParentCheck();
        setRange();
    }
    public void updateRange()
    {
        childParentCheck();
        updateUpDownRange();

    }
    public void childParentCheck()
    {
        if(block.getBlock().hasChild())
            hasChild=true;
        else
            hasChild = false;

        if(block.getBlock().hasParent())
            hasParent=true;
        else
            hasParent = false;

    }
    public void setRange()
    {
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
        initDragEvent();
    }
    public void updateUpDownRange()
    {
        if(hasChild && hasParent)
        {
            upRange = null;
            downRange.updateRange(false,blockPoint.getX(),blockPoint.getY(),block.getHeight());
        }
        else if(hasChild && !hasParent)
        {
            downRange.updateRange(false,blockPoint.getX(),blockPoint.getY(),block.getHeight());
            upRange.updateRange(true,blockPoint.getX(),blockPoint.getY(),block.getHeight());
        }
        else if(!hasChild && hasParent) {
            upRange = null;
            downRange.updateRange(true, blockPoint.getX(), blockPoint.getY(),block.getHeight());
        }
        else
        {
            downRange.updateRange(true,blockPoint.getX(),blockPoint.getY(),block.getHeight());
            upRange.updateRange(true,blockPoint.getX(),blockPoint.getY(),block.getHeight());
        }
    }
    public void release()
    {
        this.downRange.release();
        this.upRange.release();
    }
    public void initDragEvent()
    {
        if(this.upRange != null)
            this.upRange.setOnDragDropped(OnUpRangeMouseDragDroppedEventHandler);
        if(this.downRange != null)
            this.downRange.setOnDragDropped(OnDownRangeMouseDragDroppedEventHandler);
    }

    EventHandler<DragEvent> OnUpRangeMouseDragDroppedEventHandler =
            new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent t) {
                    if(Main.hasDragBlockBoard())
                    {
                        //////When Up Range Block Drag Out
                        ArrangeBlock.DataArrange(Main.getBlockGroup(), block, 0);
                        Main.clearDragBlockBoard();
                    }
                    t.consume();
                }
            };

    EventHandler<DragEvent> OnDownRangeMouseDragDroppedEventHandler =
            new EventHandler<DragEvent>() {
                @Override
                public void handle(DragEvent t) {
                    if(Main.hasDragBlockBoard())
                    {
                        ///When Down Range Block Drag Out
                        Main.clearDragBlockBoard();
                    }
                    t.consume();

                }
            };




}
