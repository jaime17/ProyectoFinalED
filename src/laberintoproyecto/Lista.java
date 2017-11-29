/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoproyecto;
import java.io.*;
import java.util.*;

/**
 *
 * @author emiaj
 */
public class Lista extends grafoAbs {
    private List < Edge > [] edges;

 
    public Lista(boolean directed, int numV) {
        super(directed, numV);
        edges = new List[numV];
        for (int i = 0; i < numV; i++) {
          edges[i] = new LinkedList<Edge>();
        }
    }



  public boolean isEdge(int source, int dest) {
    return edges[source].contains(new Edge(source, dest));
  }


  public void insert(Edge edge) {
    edges[edge.getSource()].add(edge);
    if (!isDirected()) {
      edges[edge.getDest()].add(new Edge(edge.getDest(),edge.getSource(),edge.getWeight()));
    }
  }

  public Iterator < Edge > edgeIterator(int source) {
    return edges[source].iterator();
  }

  public Edge getEdge(int source, int dest) {
    Edge target =
        new Edge(source, dest, Double.POSITIVE_INFINITY);
    for (Edge edge : edges[source]) {
      if (edge.equals(target))
        return edge; 
    }
    
    return target; 
  }
  
  public void loadEdgesFromFile(BufferedReader bufferedReader) throws
      IOException {

  }

}
