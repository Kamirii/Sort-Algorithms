package com.sort;

public class InsertionSort {
    private int numTrocas = 0;
    private int numIteracoes = 0;
    private int[] vetor;
    private int tam; 

    public InsertionSort(int[] vetor, int tam) {
        this.vetor = vetor;
        this.tam = tam; 
    }

    public int[] sort() {
        
        numTrocas = 0; 
        numIteracoes = 0; 


        for (int i = 1; i < tam; i++) {
            int x = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > x) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
                //j--;
                numTrocas++;
            }
            vetor[j + 1] = x;
            numTrocas++;
            numIteracoes++;
        }

        return vetor; 

    }


    public int getNumTrocas() {
        return numTrocas;
    }

    public int getNumIteracoes() {
        return numIteracoes;
    }

      
    }



