package lc.tree;

import lc.utils.TreeNode;

/**
 * Created on 2020-05-25-21:22
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Symmetric {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        if((root.left == null) ^ (root.right == null)) {
            return false;
        }

        return isSymmetric(root.left) && isSymmetric(root.right) && root.left.val == root.right.val;


    }

}
