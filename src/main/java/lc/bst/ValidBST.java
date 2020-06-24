package lc.bst;

import lc.utils.TreeNode;

/**
 * Created on 2020-05-23-21:40
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
 */
public class ValidBST {

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isValidBST(root.left)) {
            return false;
        }

        if(root.val <= pre) {
         return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }
}
