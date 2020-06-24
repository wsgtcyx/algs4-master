package lc.tree;

import edu.princeton.cs.algs4.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.util.Pair;
import lc.utils.TreeNode;

/**
 * Created on 2020-05-24-11:33
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 *
 * 因此，我在这里介绍一种“颜色标记法”（瞎起的名字……），兼具栈迭代方法的高效，又像递归方法一样简洁易懂，更重要的是，这种方法对于前序、中序、后序遍历，能够写出完全一致的代码。
 *
 * 其核心思想如下：
 *
 * 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
 * 如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
 * 如果遇到的节点为灰色，则将节点的值输出。
 *
 *
 * 这个方法很好，递归与非递归的记忆方法相同，只是顺序相反（只需要移动三句话的顺序）。如中序遍历：递归是左根右，非递归是右根左；后序遍历：左右根=》根右左。先序类似，三种遍历都实现了一遍，很简单，也好记
 *
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }

        Integer first = 1;
        Integer second = 2;

        List<Integer> result = new ArrayList<>();

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, first));
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            Integer status = pair.getValue();

            if(status.equals(second)) {
                result.add(node.val);
            }else {
                if(node.right != null) {
                    stack.push(new Pair<>(node.right, first));
                }
                stack.push(new Pair<>(node, second));
                if(node.left != null) {
                    stack.push(new Pair<>(node.left, first));
                }
            }
        }

        return result;
    }
}
