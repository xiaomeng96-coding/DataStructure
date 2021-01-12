package graph;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int sum = 5;
        String[] vertex = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(sum);
        //指明图的顶点
        for (String top : vertex) {
            graph.insertVertex(top);
        }
        //指明相连的顶点
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        //显示邻接矩阵
        System.out.println("邻接矩阵");
        graph.showGraph();
    }
}

