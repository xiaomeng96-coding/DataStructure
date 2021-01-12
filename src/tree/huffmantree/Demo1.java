package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 1, 8, 29, 13};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node root = huffmanTree.createHuffmanTree(arr);
        root.preTraverse();
    }
}

