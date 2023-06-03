package ativpextra;

import java.io.*;
import java.util.*;

public class UtilitarioMoedas {
    private static List<PunhadoMoedas> punhados;
    private static final String NOME_ARQUIVO = "dados_moedas.bin";

    public static void main(String[] args) {
        punhados = carregarDados(); 

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
        	System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("Escolha uma operação:");
            System.out.println("1) Cadastro de novo punhado de moedas");
            System.out.println("2) Mostrar valor total em moedas");
            System.out.println("3) Mostrar valor da moeda com maior quantidade");
            System.out.println("4)  Terminar execução ");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    cadastrarPunhado(scanner);
                    break;
                case 2:
                    exibirValorTotal();
                    break;
                case 3:
                    exibirValorMaiorQuantidade();
                    break;
                case 4:
                    encerrarAplicacao();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 4);

        salvarDados(); 
    }

    private static void cadastrarPunhado(Scanner scanner) {
        System.out.println("Digite o valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Digite a quantidade de moedas: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 
        PunhadoMoedas punhado = new PunhadoMoedas(valor, quantidade);
        punhados.add(punhado);
        System.out.println("Punhado de moedas foi cadastrado com sucesso.");
    }

    private static void exibirValorTotal() {
        double total = 0;
        for (PunhadoMoedas punhado : punhados) {
            total += punhado.getTotalPunhado();
        }
        System.out.println("Valor total em moedas: R$" + total);
    }

    private static void exibirValorMaiorQuantidade() {
        int maiorQuantidade = 0;
        double valorMaiorQuantidade = 0;

        for (PunhadoMoedas punhado : punhados) {
            if (punhado.getQuantidade() > maiorQuantidade) {
                maiorQuantidade = punhado.getQuantidade();
                valorMaiorQuantidade = punhado.getValor();
            }
        }

        System.out.println("Valor da moeda que tem a maior quantidade: R$" + valorMaiorQuantidade);
    }

    private static void encerrarAplicacao() {
        System.out.println("Encerrando a aplicação.");
    }

    private static void salvarDados() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            outputStream.writeObject(punhados);
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao tentar salvar os dados: " + e.getMessage());
        }
    }

    private static List<PunhadoMoedas> carregarDados() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            return (List<PunhadoMoedas>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado encontrado. Iniciando com uma nova lista.");
            return new ArrayList<>();
        }
    }
}
