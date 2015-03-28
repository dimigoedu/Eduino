package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane;

import javafx.scene.layout.Pane;

/**
 * Created by Timo on 15. 3. 28..
 */
public class UpRange extends RangePane {

    public UpRange(boolean big,double x,double y,double height) {

        this.big = big;
        this.blockPoint.setX(x);
        this.blockPoint.setY(y);
        this.height = height;
    }

    public void BlockPositionSetting()
    {
        this.setX(this.blockPoint.getX());
        this.setY(this.blockPoint.getY()-this.height);
    }



}

