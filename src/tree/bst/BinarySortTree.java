package tree.bst;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
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
