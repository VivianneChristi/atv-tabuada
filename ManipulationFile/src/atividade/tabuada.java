package atividade;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class tabuada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Digite o número para calcular a tabuada:");
        int numero = scanner.nextInt();

        System.out.println("Digite a quantidade de itens da tabuada:");
        int quantidadeItens = scanner.nextInt();

    
        StringBuilder tabuadaBuilder = new StringBuilder();
        for (int i = 1; i <= quantidadeItens; i++) {
            tabuadaBuilder.append(numero).append(" x ").append(i).append(" = ").append(numero * i).append("\n");
        }
        String tabuada = tabuadaBuilder.toString();

        
        String nomeArquivo = "tabuada.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(tabuada);
            System.out.println("Tabuada calculada e armazenada em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        
        try (Scanner arquivoScanner = new Scanner(new FileReader(nomeArquivo))) {
            System.out.println("Conteúdo do arquivo " + nomeArquivo + ":");
            while (arquivoScanner.hasNextLine()) {
                System.out.println(arquivoScanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
