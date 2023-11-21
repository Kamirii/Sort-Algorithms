package com.sort;

public class HeapSort {
    private int numTrocas = 0;
    private int numIteracoes = 0;
    private int[] vetor;
    private int tam;

    public HeapSort(int[] vetor, int tam) {
        this.vetor = vetor;
        this.tam = tam;
    }

    public int[] sort() {

        int mid = tam / 2 - 1;

        for (int i = mid; i >= 0; i--) {
            constroiHeap(tam, i);
        }

        for (int i = tam - 1; i > 0; i--) {
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            numTrocas++;
            numIteracoes++;

            constroiHeap(i, 0);
        }

        return vetor;
    }

    private void constroiHeap(int tamHeap, int i) {

        int paiMaior = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < tamHeap && vetor[left] > vetor[paiMaior]) {
            paiMaior = left;
        }

        if (right < tamHeap && vetor[right] > vetor[paiMaior]) {
            //System.out.println(right);
            paiMaior = right;
        }

        if (paiMaior != i) {
            int swap = vetor[i];
            vetor[i] = vetor[paiMaior];
            vetor[paiMaior] = swap;
            numTrocas++;
            numIteracoes++;

            constroiHeap(tamHeap, paiMaior);
        }
    }

    public int getNumTrocas() {
        return numTrocas;
    }

    public int getNumIteracoes() {
        return numIteracoes;
    }
}
