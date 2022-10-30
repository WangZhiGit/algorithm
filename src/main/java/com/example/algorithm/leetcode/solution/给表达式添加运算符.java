package com.example.algorithm.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class 给表达式添加运算符 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, num, target, 0, 0, 0, "");
        return res;
    }

    /**
     * @param res    返回的结果
     * @param num    字符串num
     * @param target 目标值target
     * @param index  访问到字符串的第几个字符
     * @param preNum 前面的连续乘积（乘法的时候会用到）
     * @param sum    表达式前面计算得到的和
     * @param path   算术表达式，可以看做n叉树的路径
     */
    private void dfs(List<String> res, String num, int target, int index, long preNum, long sum, String path) {
        //字符串num中所有元素都遍历完了，要指针遍历
        if (index >= num.length()) {
            //如果表达式的值等于target，说明找到了一个合适的表达式，就把他加入到集合res中
            if (sum == target) {
                res.add(path);
            }

            return;
        }

        for (int i = index; i < num.length(); i++) {
            //类似于05，07这样以0开头的数字要过滤掉
            if (i != index && num.charAt(index) == '0')
                break;
            //截取字符串，转化为数字
            long number = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                //因为第一个数字前面是没有符号的，所以要单独处理
                dfs(res, num, target, i + 1, number, number, "" + number);
            } else {
                //在当前数字number前面可以添加"+","-","*"三种符号。
                //数字number前添加"+"
                dfs(res, num, target, i + 1, number, sum + number, path + "+" + number);
                //数字number前添加"-"
                dfs(res, num, target, i + 1, -number, sum - number, path + "-" + number);
                //数字number前添加"*"
                dfs(res, num, target, i + 1, preNum * number, sum + preNum * number - preNum, path + "*" + number);
            }
        }
    }
}
