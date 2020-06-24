package lc.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import lc.utils.TreeNode;

/**
 * Created on 2020-05-24-17:54
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 */
public class BFS {
    // 计算从起点 start 到终点 target 的最近距离
    int BFS(TreeNode start, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构
        Set<TreeNode> visited = new HashSet<>(); // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                return step;
                /* 将 cur 的相邻节点加入队列 */
//                for (Node x : cur.adj())
//                    if (x not in visited) {
//                    q.offer(x);
//                    visited.add(x);
//                }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }
}
