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
public class Minimo { // este es otro tipo de metodo con el que se puede saber el camino mas corto
    public String BFS(long [][]mady){ //metodo para deternimar los caminos posibles
        int v= mady.length;
        long matrizAdy[][]=mady;
        String ruta[][]=new String[v][v];
        String rutaAux[][]=new String[v][v];
        String rutaRe="", cadena="", rutas="";
        int i,j,k;
        float temp1,temp2,temp3,temp4;
        for(i=0;i<v;i++){
            for(j=0;j<v;j++){
                ruta[i][j]="";
                rutaAux[i][j]="";
            }
        }
        for(k=0;k<v;k++){
            for(i=0;i<v;i++){
                for(j=0;j<v;j++){
                    temp1=matrizAdy[i][j];
                    temp2=matrizAdy[i][k];
                    temp3=matrizAdy[k][j];
                    temp4=temp2+temp3; 
                    float minimo = Math.min(temp1, temp4); //Encontrando el minimo
                    if(temp1!=temp4){
                        if(minimo==temp4){
                            rutaRe="";
                            rutaAux[i][j]= k +"";
                            ruta[i][j]=rutaRec(i,k,rutaAux,rutaRe) + (k+1);
                        }
                        
                        
                    }
                    matrizAdy[i][j]= (long)minimo;
                }
                
            }
        }
        for(i=0;i<v;i++){
            for(j=0;j<v;j++){
                cadena+= "[" + matrizAdy[i][j] + "}";
            }
            cadena+="\n";
        }
        //importante
        for(i=0;i<v;i++){
            for(j=0;j<v;j++){
                if(matrizAdy[i][j]!=100000000)//esto marca el infinito == No hay una arista que una tales vertices
                    if(i!=j){
                        if(ruta[i][j].equals("")){
                            rutas+="De ("+(i+1)+ "-->"+(j+1)+") se va por (" + (i+1)+ ", " + (j+1) +")\n";
                        }else{
                            rutas+="De ("+(i+1)+ "-->"+(j+1)+") se va por (" + (i+1)+ ", " + ruta[i][j]+ ", " + (j+1) +")\n";
                        }
                    }
            }
        }
        return "El camino del vertice \n" + cadena + "son \n" + rutas;

    }        
    
    public String rutaRec(int i, int k, String [][] rutaAux, String rutaRe ){
        if(rutaAux[i][k].equals("")){
            return "";
        }else{
            //recursividad
            rutaRe+=rutaRec(i, Integer.parseInt(rutaAux[i][k].toString()),rutaAux,rutaRe)+ 
                    (Integer.parseInt(rutaAux[i][k].toString())+1) + "";
            return rutaRe;
        }
    }
}
