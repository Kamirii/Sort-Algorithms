package com.sort;

import java.util.Arrays;
import java.util.Random;

/*
Avaliar:
a) Tempo de execução
b) Número de trocas
c) Número de iterações
Utilize vetores de inteiros, preenchidos aleatoriamente com 50, 500,
1000, 5000, 10000
Apresente a média, considerando ao menos 5 rodadas para cada
tamanho de vetor
*/


  public class Main {
  public static void main(String[] args) {
  
  int[] tamanhos = {50, 500, 1000, 5000, 10000};
  
  int tam = 5;
  
  // Arrays para armazenar as médias
  int[] mediaTempoExecucaoInsertion = new int[tam];
  int[] mediaNumTrocasInsertion = new int[tam];
  int[] mediaNumIteracoesInsertion = new int[tam];
  
  int[] mediaTempoExecucaoHeap = new int[tam];
  int[] mediaNumTrocasHeap = new int[tam];
  int[] mediaNumIteracoesHeap = new int[tam];
  
  int[] mediaTempoExecucaoMerge = new int[tam];
  int[] mediaNumTrocasMerge = new int[tam];
  int[] mediaNumIteracoesMerge = new int[tam];
  
  for (int i = 0; i < tam; i++) {
    int tamanho = tamanhos[i];

    int[] vetor = criaVetor(tamanho);

    // Variáveis para o INSERTION SORT
    int somaTempoExecucaoInsertion = 0;
    int somaNumTrocasInsertion = 0;
    int somaNumIteracoesInsertion = 0;

    // Variáveis para o MERGE SORT
    int somaTempoExecucaoMerge = 0;
    int somaNumTrocasMerge = 0;
    int somaNumIteracoesMerge = 0;

    // Variáveis para o Heap SORT
    int somaTempoExecucaoHeap = 0;
    int somaNumTrocasHeap = 0;
    int somaNumIteracoesHeap = 0;

    // LAÇO PARA RODAR tam VEZES
    for (int j = 0; j < tam; j++) {
        int[] copiaVetorInsertion = Arrays.copyOf(vetor, tamanho);

        // INSERTION SORT
        InsertionSort insertionSort = new InsertionSort(copiaVetorInsertion, tamanho);
        long start_time = System.currentTimeMillis();
        insertionSort.sort();
        long end_time = System.currentTimeMillis();
        int numTrocasInsertion = insertionSort.getNumTrocas();
        int numIteracoesInsertion = insertionSort.getNumIteracoes();
        int tempoExecucaoInsertion = (int) (end_time - start_time);

        somaTempoExecucaoInsertion += tempoExecucaoInsertion;
        somaNumTrocasInsertion += numTrocasInsertion;
        somaNumIteracoesInsertion += numIteracoesInsertion;

        // Heap SORT
        int[] copiaVetorHeap = Arrays.copyOf(vetor, tamanho);
        HeapSort heapSort = new HeapSort(copiaVetorHeap, tamanho);
        start_time = System.currentTimeMillis();
        heapSort.sort();
        end_time = System.currentTimeMillis();
        int numTrocasHeap = heapSort.getNumTrocas();
        int numIteracoesHeap = heapSort.getNumIteracoes();
        int tempoExecucaoHeap = (int) (end_time - start_time);

        somaTempoExecucaoHeap += tempoExecucaoHeap;
        somaNumTrocasHeap += numTrocasHeap;
        somaNumIteracoesHeap += numIteracoesHeap;

        // MERGE SORT
        int[] copiaVetorMerge = Arrays.copyOf(vetor, tamanho);
        MergeSort mergeSort = new MergeSort(copiaVetorMerge, tamanho);
        start_time = System.currentTimeMillis();
        mergeSort.sort();
        end_time = System.currentTimeMillis();
        int numTrocasMerge = mergeSort.getNumTrocas();
        int numIteracoesMerge = mergeSort.getNumIteracoes();
        int tempoExecucaoMerge = (int) (end_time - start_time);

        somaTempoExecucaoMerge += tempoExecucaoMerge;
        somaNumTrocasMerge += numTrocasMerge;
        somaNumIteracoesMerge += numIteracoesMerge;
    }

    // Médias para os algoritmos
    // INSERTION SORT
    mediaTempoExecucaoInsertion[i] = somaTempoExecucaoInsertion / tam;
    mediaNumTrocasInsertion[i] = somaNumTrocasInsertion / tam;
    mediaNumIteracoesInsertion[i] = somaNumIteracoesInsertion / tam;

    // Heap SORT
    mediaTempoExecucaoHeap[i] = somaTempoExecucaoHeap / tam;
    mediaNumTrocasHeap[i] = somaNumTrocasHeap / tam;
    mediaNumIteracoesHeap[i] = somaNumIteracoesHeap / tam;

    // MERGE SORT
    mediaTempoExecucaoMerge[i] = somaTempoExecucaoMerge / tam;
    mediaNumTrocasMerge[i] = somaNumTrocasMerge / tam;
    mediaNumIteracoesMerge[i] = somaNumIteracoesMerge / tam;
}

// Exibir as médias após o loop
for (int i = 0; i < tam; i++) {
    int tamanho = tamanhos[i];

    System.out.printf("\n Resultados para tamanho de vetor: %d  \n", tamanho);
    System.out.println("=============================================");

    System.out.println("Média dos resultados para o INSERTION SORT:");
    System.out.println("Tempo de Execução Médio: " + mediaTempoExecucaoInsertion[i] + " ms");
    System.out.println("Número Médio de Trocas: " + mediaNumTrocasInsertion[i]);
    System.out.println("Número Médio de Iterações: " + mediaNumIteracoesInsertion[i]);
    System.out.println("---------------------------------------------");
    System.out.println("Média dos resultados para o HEAP SORT:");
    System.out.println("Tempo de Execução Médio: " + mediaTempoExecucaoHeap[i] + " ms");
    System.out.println("Número Médio de Trocas: " + mediaNumTrocasHeap[i]);
    System.out.println("Número Médio de Iterações: " + mediaNumIteracoesHeap[i]);
    System.out.println("---------------------------------------------");
    System.out.println("Média dos resultados para o MERGE SORT:");
    System.out.println("Tempo de Execução Médio: " + mediaTempoExecucaoMerge[i] + " ms");
    System.out.println("Número Médio de Trocas: " + mediaNumTrocasMerge[i]);
    System.out.println("Número Médio de Iterações: " + mediaNumIteracoesMerge[i]);

    System.out.println();
}

  }
  
  public static int[] criaVetor(int tamanho) {
  int[] vetor = new int[tamanho];
  
  Random random = new Random(1234);
  
  for (int i = 0; i < tamanho; i++) {
  vetor[i] = random.nextInt(10000);
  }
  
  return vetor;
  }
  
  
  }
 