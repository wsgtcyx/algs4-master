package lc.bst;

import lc.utils.TreeNode;

/**
 * Created on 2020-05-23-21:48
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        }else {
            if(root.right == null) {
                return root.left;
            }
            if(root.left == null) {
                return root.right;
            }

            TreeNode node = root.right;
            //找到当前节点右子树最左边的叶子结点
            while(node.left != null){
                node = node.left;
            }
            //将root的左子树放到root的右子树的最下面的左叶子节点的左子树上
            node.left = root.left;
            return root.right;
        }

        return root;
    }
}
