package tree.huffmantree;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo2 {
    public static void main(String[] args) {
        String str = "helloworld";
        //哈夫曼编码
        HuffmanCode huffmanCode = new HuffmanCode();
        ArrayList<Code> list = huffmanCode.getList(str);
        //构建哈弗曼树
        Code root = huffmanCode.createHuffmanTree(list);
        System.out.println("前序遍历哈弗曼树");
        root.preTraverse();
        //进行哈弗曼编码
        Map<Byte, String> codeMap = root.getCodeMap();
        System.out.println("哈弗曼编码");
        System.out.println(codeMap);
    }
}

