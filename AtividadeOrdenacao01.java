/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeordenacao01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodolfo Barreiro
 */
public class AtividadeOrdenacao01 {

    /**
     * @param args the command line arguments
     */
    
    
    private static List<Integer> listNumeros = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        addAll("src/couting.txt");
        
        
        
        //insertionsort(listNumeros);
        selectionsort(listNumeros);
        
        for(int i = 0;i<listNumeros.size();i++){
          System.out.println(listNumeros.get(i));
        }
        
    }
    
    public static void addAll(String file) {
        System.out.println("LENDO ARQUIVO");
        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                //String numeros[] = linha.split("-");
                listNumeros.add(Integer.parseInt(linha));
                
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        List<Integer> arr = listNumeros;
    }
    
    public static void insertionsort(List<Integer> arr) 
    { 
        int n = arr.size(); 
        for (int i=1; i<n; ++i) 
        { 
            int chave = arr.get(i); 
            int j = i-1; 
  
            /* Mover elementos de arr [0..i-1], que são
                maior que chave, para uma posição à frente
                da sua posição atual */
            while (j>=0 && arr.get(j) > chave) 
            { 
                arr.set(j+1, arr.get(j)); 
                j = j-1; 
            } 
            arr.set(j+1, chave); 
        } 
    }
    
    public static void selectionsort(List<Integer> arr) 
    { 
        int n = arr.size(); 
  
        for (int i = 0; i < n-1; i++) 
        { 
            // Encontre o elemento mínimo não classificado 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr.get(j) < arr.get(min_idx)) 
                    min_idx = j; 
  
            // Troque o elemento mínimo encontrado pelo primeiro  
            int temp = arr.get(min_idx); 
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        } 
    } 
    
}
