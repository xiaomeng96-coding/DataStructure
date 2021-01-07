package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo2 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        List<Integer> integers = preTraverse(node1);
        System.out.println("前序遍历结果");
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
        System.out.println();

        List<Integer> integers2 = midTraverse(node1);
        System.out.println("中序遍历结果");
        for (Integer integer : integers2) {
            System.out.print(integer + " ");
        }
        System.out.println();

        List<Integer> integers3 = lastTraverse(node1);
        System.out.println("后序遍历结果");
        for (Integer integer : integers3) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    /**
     * 使用迭代法对二叉树进行前序遍历
     *
     * @param root 二叉树根节点
     * @return 遍历后的集合
     */
    public static List<Integer> preTraverse(TreeNode root) {
        // 用于存放结果的集合
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 栈，用于存放遍历的节点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 遍历二叉树
        while (!stack.isEmpty()) {
            // 栈顶元素出栈，并放入集合中
            root = stack.pop();
            result.add(root.val);
            // 先遍历右子树，将其压栈
            if (root.right != null) {
                stack.push(root.right);
            }
            // 遍历左子树,压栈
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return result;
    }

    /**
     * 使用迭代法对二叉树进行中序遍历
     *
     * @param root 二叉树根节点
     * @return 中序遍历结果集合
     */
    public static List<Integer> midTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            // 节点压栈，并遍历其左子树
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 栈顶元素出栈，放入结果集合
            root = stack.pop();
            result.add(root.val);

            // 遍历该节点的右子树
            root = root.right;
        }
        return result;
    }

    /**
     * 使用迭代法的后序遍历
     *
     * @param root 二叉树根节点
     * @return 后序遍历集合
     */
    public static List<Integer> lastTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        // 保存放入集合的右子树，避免重复放入
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 获取栈顶元素
            root = stack.pop();

            // 如果该元素没有右子树，或者右子树已近被遍历过了，就放入集合
            if (root.right == null || root.right == pre) {
                result.add(root.val);
                pre = root;
                root = null;
            } else {
                // 否则就继续遍历该节点的右子树
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

}
