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
public class DFS {
     //Atributos de la clase
    private Grafo grafo;// El arreglo de padres in la busqueda del primero en anchura.
    private int[] parent;// Bandera para indicar si el vertice ha sido visitado previamente.
    private boolean[] visited;// El arreglo que contiene cada vertice en orden de descubrimiento.
    private int[] discoveryOrder;// El arreglo que contiene cada vertice en orden de culminación.
    private int[] finishOrder;    // El arreglo que indica el orden de descubrimiento.
    private int discoverIndex = 0;// El indice que indica el orden de culminación.
    private int finishIndex = 0;// El indice que indica el orden de culminación.

    public DFS(Grafo grafo, int[] parent, boolean[] visited, int[] discoveryOrder, int[] finishOrder) {
        this.grafo = grafo;
        int n = grafo.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < 10; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < 10; i++) {
            if(!visited[i])
                DFS(i);
        }
    }
    
    
    
    public DFS(Grafo grafo,int[] order){
        //El mismo constructor, pero sin la comprobación.
         this.grafo = grafo;
        int n = grafo.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < 10; i++) {
            parent[i] = -1;
        }
    }
   
    public void DFS(int current){
        // Marca el vertice "@actual" como visitado. 
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        // Examina cada vertice adyacente al vertice actual
        Iterator<Edge> itr = grafo.edgeIterator(current);
        while(itr.hasNext()){
            int neighbor = itr.next().getDest();
            //Procesa al vecino que no ha sido visitado.
            if(!visited[neighbor]){
                //Inserta (acutal,vecino) en la busqueda del primero en anchura.
                parent[neighbor] = current;
                // Recursivamente aplica el algoritmo comenzando por el vecino.
                DFS(neighbor);
            }
        }
        /* Marca del actual finalizada.*/
        finishOrder[finishIndex++] = current;
    }
}
   