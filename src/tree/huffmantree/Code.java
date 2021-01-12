package tree.huffmantree;

import java.util.HashMap;
import java.util.Map;

/**
* @author: ZhiHao
* @date: 2021/1/12
* @version: 1.0
*/
class Code implements Comparable<Code> {
    Byte data;
    int weight;
    Code left;
    Code right;
    private Map<Byte, String> codeMap = new HashMap<>();



    public Code(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Code{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preTraverse() {
        System.out.println(this);
        if(left != null) {
            left.preTraverse();
        }
        if(right != null) {
            right.preTraverse();
        }
    }

    public Map<Byte, String> getCodeMap() {
        return getCode(this, "", new StringBuilder());
    }

    /**
     * 对哈弗曼树中的叶子节点进行编码
     * @param node 根节点
     * @param code 左子树为0，右子树为1
     * @param stringBuilder 用于拼接的字符串
     * @return
     */
    private Map<Byte, String> getCode(Code node, String code, StringBuilder stringBuilder) {
        //新建拼接路径
        StringBuilder appendCode = new StringBuilder(stringBuilder);
        appendCode.append(code);
        if(node != null) {
            //如果是非叶子结点，就继续向下遍历
            if(node.data == null) {
                getCode(node.left, "0", appendCode);
                getCode(node.right, "1", appendCode);
            }else {
                //如果是叶子节点，就将哈弗曼编码放入哈希表中
                codeMap.put(node.data, appendCode.toString());
            }
        }
        return codeMap;
    }

    @Override
    public int compareTo(Code o) {
        return weight - o.weight;
    }

}
