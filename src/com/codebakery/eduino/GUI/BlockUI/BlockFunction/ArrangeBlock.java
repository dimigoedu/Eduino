package com.codebakery.eduino.GUI.BlockUI.BlockFunction;

import com.codebakery.eduino.Block.ListBlock;
import com.codebakery.eduino.GUI.BlockUI.BlockFunction.Grouping.BlockGroup;
import com.codebakery.eduino.GUI.BlockUI.GUIBlock;

/**
 * Created by Timo on 15. 3. 29..
 */
public class ArrangeBlock {

    public static void DataArrange(BlockGroup blockGroup,GUIBlock block,int Position)
    {
        ListBlock listBlock = blockGroup.getListBlock();

        switch (Position)
        {
            case 0:
                listBlock.getFirst().setParent(null);
                listBlock.getLast().setChild(block.getBlock());
                block.getBlock().setParent(listBlock.getLast());
                break;

            case 1:
                if(block.getBlock().getChild() != null) {
                    if (listBlock.size() == 1) {
                        block.getBlock().getChild().setParent(listBlock.getFirst());
                        listBlock.getFirst().setChild(block.getBlock().getChild());
                        listBlock.getFirst().setParent(block.getBlock());
                        block.getBlock().setChild(listBlock.getFirst());
                    } else {
                        block.getBlock().getChild().setParent(listBlock.getLast());
                        listBlock.getLast().setChild(block.getBlock().getChild());
                        block.getBlock().setChild(listBlock.getFirst());
                        listBlock.getFirst().setParent(block.getBlock());
                    }
                }

                else
                {
                    if(listBlock.size() == 1)
                    {
                        block.getBlock().setChild(listBlock.getFirst());
                        listBlock.getFirst().setParent(block.getBlock());
                        listBlock.getFirst().setChild(null);
                    }
                    else
                    {
                        block.getBlock().setChild(listBlock.getFirst());
                        listBlock.getFirst().setParent(block.getBlock());
                        listBlock.getLast().setChild(null);
                    }
                }
                break;


        }

    }
}
