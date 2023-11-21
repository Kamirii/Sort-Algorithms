package com.sort;

public class MergeSort {
    private int numTrocas = 0;
    private int numIteracoes = 0;
    private int tam;
    private int[] vetor;

    public MergeSort(int[] vetor, int tam) {
        this.vetor = vetor;
        this.tam = tam;
    }

    public int[] sort() {
        numTrocas = 0;
        numIteracoes = 0;
        mergeSort(0, tam - 1);
        return vetor;

    }

    private void mergeSort(int min, int max) {

        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(min, mid);
            mergeSort(mid + 1, max);
            merge(min, mid, max);
        }

    }

    private void merge(int min, int mid, int max) {
        int[] temp = new int[this.tam];
        for (int i = min; i <= max; i++) {
            temp[i] = vetor[i];
        }
        int i = min;
        int j = mid + 1;
        int k = min;

        while (i <= mid && j <= max) {
            if (temp[i] <= temp[j]) {
                vetor[k] = temp[i];
                i++;
            } else {
                vetor[k] = temp[j];
                j++;
            }
            k++;
            numTrocas++;
            numIteracoes++;
        }

        while (i <= mid) {
            vetor[k] = temp[i];
            k++;
            i++;
            numTrocas++;
            numIteracoes++;
        }
    }

    public int getNumTrocas() {
        return numTrocas;
    }

    public int getNumIteracoes() {
        return numIteracoes;
    }
}
