package com.sort;

public class QuickSort {
    private int numTrocas = 0;
    private int numIteracoes = 0;
    private int[] vetor;
    private int tam;

    public QuickSort(int[] vetor, int tam) {
        this.vetor = vetor;
        this.tam = tam;
    }

    public void sort() {
        quicksort(0, tam);
    }

    private void quicksort(int min, int max) {
        if (min < max) {
            int indicePivo = particiona(min, max);
            quicksort(min, indicePivo - 1);
            quicksort(indicePivo + 1, max);
        }
    }

    private int particiona(int min, int max) {
        int pivo = vetor[max];
        int j = (min - 1);
        for (int i = min; i <= max - 1; i++) {
            numIteracoes++;

            if (vetor[i] <= pivo) {
                j++;
                trocar(j, i);
            }
        }

        trocar(j + 1, max);
        return (j + 1);
    }

    private void trocar(int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
        numTrocas++;
    }

    public int getNumTrocas() {
        return numTrocas;
    }

    public int getNumIteracoes() {
        return numIteracoes;
    }
}