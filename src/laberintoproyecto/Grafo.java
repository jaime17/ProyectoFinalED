/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoproyecto;
import java.util.*;
/**
 *
 * @author emiaj
 */
public interface Grafo {
    int getNumV();//obtiene el numero de vertices
    
    boolean isDirected();//Determina si es un grafo dirigido
  
    void insert(Edge edge);  //Determina si una arista existe
     
    boolean isEdge (int source, int dest);//Obtiene la arista entre dos vértices
   
    Edge getEdge(int source, int dest);//Obtiene la arista entre dos vértices
    
    Iterator<Edge> edgeIterator(int source);//Devuelve un iterador de aristas conectadas a un vértice dado
}