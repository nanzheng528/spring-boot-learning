package com.nz.springbootlearning.Note;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 9:23 18/7/6
 * @ Description：二叉树的类
 * @ Modified By：
 * @Version: $
 */
public class Note {

    private int val;
    private Note leftNode;
    private Note rightNode;

    public Note(int val, Note leftNode, Note rightNode) {
        this.val = val;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Note getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Note leftNode) {
        this.leftNode = leftNode;
    }

    public Note getRightNode() {
        return rightNode;
    }

    public void setRightNode(Note rightNode) {
        this.rightNode = rightNode;
    }
}
