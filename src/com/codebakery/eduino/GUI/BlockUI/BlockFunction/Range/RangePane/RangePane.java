package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane;

import com.codebakery.eduino.GUI.BlockUI.BlockFunction.BlockPoint;
import com.codebakery.eduino.main.Main;
import javafx.scene.layout.Pane;


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

    public void register()
    {
        setSize();
        BlockPositionSetting();
        Main.addNode(this);
    }
    public void release()
    {
        Main.deleteNode(this);
    }

    public void setSize()   //재정의 해야함
    {
        double width = 100;
        double height_normal = 100;
        double height_big = 200;
        if(this.big) {
            this.setWidth(width);
            this.setHeight(height_big);
        }
        else{
            this.setWidth(width);
            this.setHeight(height_normal);
        }
    }

    public abstract void BlockPositionSetting();
    public abstract void updateRange(Boolean Big,double x, double y,double height);



}
