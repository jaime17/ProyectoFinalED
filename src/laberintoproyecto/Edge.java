/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoproyecto;

/**
 *
 * @author emiaj
 */
public class Edge {
     private int dest;
    private int source;
    private double weight;

    public Edge(int dest, int source) {
        this.dest = dest;
        this.source = source;
    }

    public Edge(int dest, int source, double weight) {
        this.dest = dest;
        this.source = source;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.dest;
        hash = 67 * hash + this.source;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (this.dest != other.dest) {
            return false;
        }
        if (this.source != other.source) {
            return false;
        }
        return true;
    }

    public int getDest() {
        return dest;
    }

    public int getSource() {
        return source;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" + "dest=" + dest + ", source=" + source + ", weight=" + weight + '}';
    }
    
    
    
}
