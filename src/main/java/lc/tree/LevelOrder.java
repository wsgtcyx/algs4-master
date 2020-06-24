package lc.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;
import lc.utils.TreeNode;

/**
 * Created on 2020-05-24-12:10
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            Integer level = pair.getValue();

            // 添加层结果List
            if(result.size() <= level) {
                result.add(new ArrayList<>());
            }

            List<Integer> levelResult = result.get(level);
            levelResult.add(node.val);

            if(node.left != null) {
                q.offer(new Pair<>(node.left, level + 1));
            }
            if(node.right != null) {
                q.offer(new Pair<>(node.right, level + 1));
            }
        }

        return result;

    }
}
