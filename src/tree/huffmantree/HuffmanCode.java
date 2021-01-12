package tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
* @author: ZhiHao
* @date: 2021/1/12
* @version: 1.0
*/
class HuffmanCode {
    public ArrayList<Code> getList(String codes) {
        //得到字符串对应的字节数组
        byte[] byteCodes = codes.getBytes();

        //创建哈希表，用于存放数据及其权值（出现次数）
        Map<Byte, Integer> dataAndWight = new HashMap<>();
        for(byte b : byteCodes) {
            Integer wight = dataAndWight.get(b);
            //如果还没有该数据，就创建并让其权值为1
            if(dataAndWight.get(b) == null) {
                dataAndWight.put(b, 1);
            }else {
                //如果已经有了该数据，就让其权值加一
                dataAndWight.put(b, wight+1);
            }
        }

        //创建List，用于返回
        ArrayList<Code> list = new ArrayList<>();
        //遍历哈希表，放入List集合中
        for(Map.Entry<Byte, Integer> entry : dataAndWight.entrySet()) {
            list.add(new Code(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public Code createHuffmanTree(ArrayList<Code> lists) {
        int leftIndex = 0;
        int rightIndex = 1;
        //根据权值进行排序
        Collections.sort(lists);

        while (lists.size() > 1) {
            Code leftCode = lists.get(leftIndex);
            Code rightCode = lists.get(rightIndex);
            Code parent = new Code(null,leftCode.weight + rightCode.weight);
            parent.left = leftCode;
            parent.right = rightCode;
            lists.add(parent);
            lists.remove(leftCode);
            lists.remove(rightCode);
            //再次排序
            Collections.sort(lists);
        }
        return lists.get(0);
    }
}
