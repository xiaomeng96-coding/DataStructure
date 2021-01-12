package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class Graph3 {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    /**
     * 标记是否访问过该顶点，用于遍历
     */
    private boolean[] isTraversed;
    /**
     * 用于保存访问过的顶点
     */
    private Queue<Integer> queue;

    public Graph3(int sum) {
        //根据顶点总数进行初始化
        vertexList = new ArrayList<>(sum);
        edges = new int[sum][sum];
        isTraversed = new boolean[sum];
        numOfEdges = 0;
        queue = new LinkedList<Integer>();
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int vertex1, int vertex2, int weight) {
        edges[vertex1][vertex2] = weight;
        edges[vertex2][vertex1] = weight;
        numOfEdges++;
    }

    public void showGraph() {
        for (int[] list : edges) {
            System.out.println(Arrays.toString(list));
        }
    }

    /**
     * 广度优先遍历
     *
     * @param vertex 遍历顶点的下标
     */
    private void bfs(int vertex) {
        //未被访问，打印顶点信息
        if (!isTraversed[vertex]) {
            System.out.print(vertexList.get(vertex) + "->");
            isTraversed[vertex] = true;
        }
        //继续访问相邻元素
        for (int nextVertex = vertex + 1; nextVertex < vertexList.size(); nextVertex++) {
            //如果存在且未被访问
            if (edges[vertex][nextVertex] != 0 && !isTraversed[nextVertex]) {
                //打印顶点信息
                System.out.print(vertexList.get(nextVertex) + "->");
                //标记为已访问
                isTraversed[nextVertex] = true;
                //入队
                queue.add(nextVertex);
            }
        }
        //相邻元素访问完了（广度优先），再让队列中的元素出队，继续访问
        while (!queue.isEmpty()) {
            //队首元素出队，继续访问
            bfs(queue.remove());
        }
    }

    public void bfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            //未被访问过，就进行广度优先遍历
            if (!isTraversed[i]) {
                bfs(i);
            }
        }
    }

}
