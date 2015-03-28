package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane;

import com.codebakery.eduino.Block.Block;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.BlockPoint;
import javafx.scene.layout.Pane;

import java.awt.*;

/**
 * Created by Timo on 15. 3. 28..
 */
public abstract class RangePane extends Pane {

    public boolean big;
    public BlockPoint blockPoint;
    public double height;

    public double getX()
    {
        return this.getLayoutX();
    }
    public double getY()
    {
        return this.getLayoutY();
    }
    public void setX(double x)
    {
        this.setLayoutX(x);
    }
    public void setY(double y)
    {
        this.setLayoutY(y);
    }
    public BlockPoint getBlockPoint()
    {
        BlockPoint blockPoint = new BlockPoint(this.getX(),this.getY());
        return blockPoint;
    }
    public void setPosition(BlockPoint blockPoint)
    {
        this.setLayoutX(blockPoint.getX());
        this.setLayoutY(blockPoint.getY());
    }

    public void register()
    {

    }
    public void release()
    {

    }
    public abstract void BlockPositionSetting();

}
