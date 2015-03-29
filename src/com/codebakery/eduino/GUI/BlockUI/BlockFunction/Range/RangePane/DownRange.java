package com.codebakery.eduino.GUI.BlockUI.BlockFunction.Range.RangePane;

import javafx.scene.layout.Pane;

/**
 * Created by Timo on 15. 3. 28..
 */
public class DownRange extends RangePane {

    public DownRange(Boolean Big,double x, double y,double height)
    {
        this.big = Big;
        this.blockPoint.setX(x);
        this.blockPoint.setY(y);
        this.height = height;
        this.register();
    }

    public void updateRange(Boolean Big,double x, double y,double height)
    {
        this.big = Big;
        this.blockPoint.setX(x);
        this.blockPoint.setY(y);
        this.height = height;
        this.register();
    }

    public void BlockPositionSetting()
    {
        this.setX(this.blockPoint.getX());
        this.setY(this.blockPoint.getY()-this.height);
    }

}
