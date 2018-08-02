package com.nz.springbootlearning.Note;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 9:57 18/7/6
 * @ Description：二叉树遍历
 * @ Modified By：
 * @Version: $
 */
public class BinaryTree {
    public Note init(){
        Note J = new Note(8, null, null);
        Note H = new Note(4, null, null);
        Note G = new Note(2, null, null);
        Note F = new Note(7, null, J);
        Note E = new Note(5, H, null);
        Note D = new Note(1, null, G);
        Note C = new Note(9, F, null);
        Note B = new Note(3, D, E);
        Note A = new Note(6, B, C);
        return A;   //返回根节点  
    }
    public  void  printNode(Note note){
        System.out.println(note.getVal());
    }
    /**
     * create by: nz
     * description:先序遍历
     * create time: 上午 10:13 18/7/6
     *
     * @param  note
     * @return  void
     */
    public void theFirstTraversal(Note note){

        printNode(note);
        if (note.getLeftNode()!=null){
            theFirstTraversal(note.getLeftNode());}
        if (note.getRightNode()!= null){
            theFirstTraversal(note.getRightNode());
        }
    }

    /**
     * create by: nz
     * description:中序遍历
     * create time: 上午 10:17 18/7/6
     *
      * @param
     * @return
     */
        public void thInorderTraversal(Note note){
        if (note.getLeftNode()!=null){
            theFirstTraversal(note.getLeftNode());}
        printNode(note);
        if (note.getRightNode()!= null){
            theFirstTraversal(note.getRightNode());
        }
    }  /**
     * create by: nz
     * description:后序遍历
     * create time: 上午 10:17 18/7/6
     *
      * @param
     * @return
     */
        public void thLastTraversal(Note note){
        if (note.getLeftNode()!=null){
            theFirstTraversal(note.getLeftNode());}

        if (note.getRightNode()!= null){
            theFirstTraversal(note.getRightNode());
        }
            printNode(note);
    }
}
