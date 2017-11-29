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
public class BFS {
   public static int[] bfs(Grafo g, int start){
        Queue<Integer>theQueue = new LinkedList<Integer>(); //Declara el arrego padre y se inizialican sus elementos en -1.
        int[]parent = new int[g.getNumV()];
        for (int i = 0; i < g.getNumV(); i++) {
            parent[i]= -1;
        }
        boolean[]identified = new boolean[g.getNumV()];//Declara el arreglo identificado y se inicializan los elementos a falso;
       identified[start] = true; // Marca el vertice de inicio como identificado y lo inserta en la cola.(queue)
        theQueue.offer(start); 
        while(!theQueue.isEmpty()){//Mientras que la cola(queue) no esté vacia
            int current = theQueue.remove();//Toma el vertice, actual, afuera de la cola.(Comienza visitando al "@actual").
               Iterator<Edge> itr = g.edgeIterator(current); //Examina cada vertice,vecino, adyacente hasta el actual
                while(itr.hasNext()){
                    Edge edge = itr.next();
                    int neighbor = edge.getDest();
                        if(!identified[neighbor]){//Sí el vecino no es identificado.
                        identified[neighbor] = true ;//Marcar como identificado.
                        theQueue.offer(neighbor);//Añadirlo a la cola(queue).
                        parent[neighbor] = current;//Inserta el Arista (actual,vecino en el árbol)
                    }
                }
            //Fin  
        }
        return parent;
    }
    
}