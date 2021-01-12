package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: ZhiHao
 * @date: 2021/1/12
 * @version: 1.0
 */
class Graph {
    ArrayList<String> vertexList;
    int[][] edges;
    int numOfEdges;

    public Graph(int sum) {
        //根据顶点总数进行初始化
        vertexList = new ArrayList<>(sum);
        edges = new int[sum][sum];
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

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getWeight(int vertex1, int vertex2) {
        return edges[vertex1][vertex2];
    }

    public void showGraph() {
        for (int[] list : edges) {
            System.out.println(Arrays.toString(list));
        }
    }

}
