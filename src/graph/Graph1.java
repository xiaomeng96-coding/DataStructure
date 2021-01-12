package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class Graph1 {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    /**
     * 标记是否访问过该顶点，用于遍历
     */
    private boolean[] isTraversed;

    public Graph1(int sum) {
        //根据顶点总数进行初始化
        vertexList = new ArrayList<>(sum);
        edges = new int[sum][sum];
        isTraversed = new boolean[sum];
        numOfEdges = 0;
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
     * 深度优先遍历
     *
     * @param vertex 开始顶点下标
     */
    private void dfs(int vertex) {
        //被访问过了就返回
        if (isTraversed[vertex]) {
            return;
        }
        System.out.print(vertexList.get(vertex) + "->");
        //标记已被访问
        isTraversed[vertex] = true;
        //从相邻顶点开始深度优先遍历
        for (int nextVertex = vertex + 1; nextVertex < vertexList.size(); nextVertex++) {
            //如果该顶点存在且未被访问，就向下访问
            if (edges[vertex][nextVertex] != 0 && !isTraversed[nextVertex]) {
                dfs(nextVertex);
            }
        }
    }

    public void dfs() {
        //对未被访问的顶点都进行深度优先遍历
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isTraversed[i]) {
                dfs(i);
            }
        }
    }

}
