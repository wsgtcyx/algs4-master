package lc.dp;

/**
 * Created on 2020-05-24-15:38
 *
 * @author Chen Yuxiang(yuxiangchen@sohu-inc.com)
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Fib {
    public int fib(int N) {
        if(N == 0 || N == 1) {
            return N;
        }

        int pre = 0;
        int cur = 1;
        for(int i = 2; i <= N; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }

        return cur;

    }
}
