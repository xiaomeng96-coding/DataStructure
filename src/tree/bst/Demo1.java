package tree.bst;

/**
 * @author: ZhiHao
 * @date: 2021/1/7
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        //创建二叉排序树
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.addNode(new Node(arr[i]));
        }
        //前序遍历
        System.out.println("前序遍历二叉排序树");
        binarySortTree.preTraverse();
        System.out.println();
        //删除值为5、1、3、10、7的节点
        binarySortTree.deleteNode(2);
        binarySortTree.deleteNode(1);
        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(7);
        System.out.println("前序遍历二叉排序树");
        binarySortTree.preTraverse();
    }
}

class BinarySortTree {
    private Node root;

    public void addNode(Node node) {
        //如果根节点为空，就直接将该节点作为根节点
        if (root == null) {
            root = node;
            return;
        }
        //否则就插入该节点到对应的位置
        root.add(node);
    }

    public void preTraverse() {
        if (root == null) {
            System.out.println("二叉树为空");
        } else {
            root.preTraverse();
        }
    }

    public Node getTargetNode(int targetValue) {
        if (root == null) {
            System.out.println("请先创建二叉树");
            return null;
        } else {
            return root.getTargetNode(targetValue);
        }
    }

    public Node getParentNode(int targetValue) {
        if (root == null) {
            System.out.println("请先创建二叉树");
            return null;
        } else {
            return root.getParentNode(targetValue);
        }
    }

    /**
     * 删除节点
     *
     * @param targetValue 待删除节点的值
     */
    public void deleteNode(int targetValue) {
        if (root == null) {
            System.out.println("请先创建二叉树");
            return;
        }

        //找到待删除结点
        Node targetNode = getTargetNode(targetValue);
        if (targetNode == null) {
            System.out.println("未找到该节点，删除失败");
            return;
        }
        //如果只有一个根节点，就删除根节点
        if (root.left == null && root.right == null) {
            root = null;
            System.out.println("删除成功");
            return;
        }

        //得到其父节点
        Node parentNode = getParentNode(targetValue);
        //如果父节点为空（待删除节点为根节点）
        if (parentNode == null) {
            int minValue = getMinValue(targetNode.right);
            deleteNode(minValue);
            //根节点的值令为最接近的值
            targetNode.value = minValue;
            return;
        }

        //如果待删除节点为叶子节点
        if (targetNode.left == null && targetNode.right == null) {
            if (parentNode.left != null && parentNode.left == targetNode) {
                //删除左子树
                parentNode.left = null;
                System.out.println("删除成功");
            } else if (parentNode.right != null && parentNode.right == targetNode) {
                //删除右子树
                parentNode.right = null;
                System.out.println("删除成功");
            }
        } else if (targetNode.left != null && targetNode.right != null) {
            //待删除节点有左右子树
            //得到并删除待删除节点右子树中值最小的节点
            int minValue = getMinValue(targetNode.right);
            deleteNode(minValue);
            //将值最小的节点的值作为新的目标节点
            targetNode.value = minValue;
        } else {
            //待删除节点只有左子树
            if (targetNode.left != null) {
                if (parentNode.left != null && parentNode.left == targetNode) {
                    parentNode.left = targetNode.left;
                } else if (parentNode.right != null && parentNode.right == targetNode) {
                    parentNode.right = targetNode.left;
                }
            } else {
                //待删除节点只有右子树
                if (parentNode.left != null && parentNode.left == targetNode) {
                    parentNode.left = targetNode.right;
                } else if (parentNode.right != null && parentNode.right == targetNode) {
                    parentNode.right = targetNode.right;
                }
            }
        }
    }

    /**
     * 找到以node为根节点的二叉树的最小节点的值
     *
     * @param node 作为根节点的节点
     * @return 值最小的节点的值
     */
    public int getMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        //返回值最小的节点
        return node.value;
    }
}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 添加节点到二叉排序树的对应位置
     *
     * @param node 待插入的节点
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //如果该节点的值大待插入节点的值
        if (value > node.value) {
            //如果该节点的左子树为空，就直接插入
            if (left == null) {
                left = node;
            } else {
                left.add(node);
            }
        } else {
            if (right == null) {
                right = node;
            } else {
                right.add(node);
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preTraverse() {
        System.out.println(this);
        if (left != null) {
            left.preTraverse();
        }
        if (right != null) {
            right.preTraverse();
        }
    }

    /**
     * 得到目标节点
     *
     * @param targetValue 目标节点的值
     * @return 目标节点
     */
    public Node getTargetNode(int targetValue) {
        //如果当前节点就是目标节点，就返回
        if (value == targetValue) {
            return this;
        }
        //如果当前节点的值大于目标节点，就向左查找，反之向右查找
        if (value > targetValue) {
            if (left == null) {
                return null;
            } else {
                return left.getTargetNode(targetValue);
            }
        } else {
            if (right == null) {
                return null;
            } else {
                return right.getTargetNode(targetValue);
            }
        }
    }

    /**
     * 得到目标节点的父节点
     *
     * @param targetValue 目标节点的值
     * @return 目标节点的父节点
     */
    public Node getParentNode(int targetValue) {
        //如果左右子树是目标节点，就返回该节点，否则继续向下查找
        if (left != null && left.value == targetValue) {
            return this;
        } else if (right != null && right.value == targetValue) {
            return this;
        } else {
            if (left != null && value > targetValue) {
                return left.getParentNode(targetValue);
            }
            if (right != null && value <= targetValue) {
                return right.getParentNode(targetValue);
            } else {
                //没有父节点（根节点）
                return null;
            }
        }
    }
}
