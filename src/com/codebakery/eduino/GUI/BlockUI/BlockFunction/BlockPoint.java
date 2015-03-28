package com.codebakery.eduino.GUI.BlockUI.BlockFunction;

import com.codebakery.eduino.Block.Block;

/**
 * Created by Timo on 15. 3. 28..
 */
public class BlockPoint {

    public double x_point;
    public double y_point;

    public double getX()
    {
        return x_point;
    }
    public double getY()
    {
        return y_point;
    }
    public void setX(double x)
    {
        this.x_point = x;
    }
    public void setY(double y)
    {
        this.y_point = y;
    }
    public BlockPoint(double x, double y) {
        this.x_point = x;
        this.y_point = y;
    }

}
