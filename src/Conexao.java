import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Conexao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        System.out.println("CRUD");
        System.out.println("Bem vindo ao Cadastro de cantor no Grupo FORGET");
            do {
                System.out.println("||||||||||||||||||||||||||||||||");
                System.out.println("||   O que deseja fazer?      ||");
                System.out.println("||  1 - Cadastrar Produtora   ||");
                System.out.println("||  2 - Cadastrar Cantor      ||");
                System.out.println("||  3 - Listar    Produtora   ||");
                System.out.println("||  4 - Listar    Cantor      ||");
                System.out.println("||  5 - Remover   Produtora   ||");
                System.out.println("||  6 - Remover   Cantor      ||");         
                System.out.println("||  7 - Editar    Produtora   ||");         
                System.out.println("||  8 - Editar    Cantor      ||");         
                System.out.println("||  9 - Sair                  ||");
                System.out.println("||||||||||||||||||||||||||||||||");
                System.out.print("Opção: ");
                try {
                    opcao = scanner.nextInt();
                } catch (Exception e) {
                    opcao = 0;
                }
                switch (opcao) {
                    case 1:
                        cadastrarProdutora(scanner);
                        break;
                    case 2:
                        cadastrarCantor(scanner);
                        break;
                    case 3:
                        listarProdutora();
                        break;
                    case 4:
                        listarCantor();
                        break;
                    case 5:
                        removerProdutora(scanner);
                        break;
                    case 6:
                        removerCantor(scanner);
                        break;
                    case 7:
                        try {
                            editarProdutora(scanner);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case 8:
                        try {
                            editarCantor(scanner);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    case 9:
                        sair();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (opcao != 9);
        }
            
            public static void cadastrarProdutora (Scanner scanner){
                try {
                    System.out.println("Cadastrar Produtora");
                    System.out.println("Digite o nome da Produtora: ");
                    String nomeCantor = scanner.next();
                    System.out.println("Digite o genero musical da produtora: ");
                    String genero = scanner.next();
                    System.out.println("Digite a cidade da produtora: ");
                    String cidade = scanner.next();
                    System.out.println("Digite o id do cantor: ");
                    int idCantor = scanner.nextInt();
                    Cantor cantor = Cantor.getById(idCantor);
                    new Produtora(nomeCantor, genero, cidade, idCantor, cantor);
                    } catch (Exception e) {
                    System.out.println(e.getMessage());
                    }
                }

            public static void cadastrarCantor (Scanner scanner){
                try {
                System.out.println("Cadastrar Cantor");
                System.out.println("Digite o nome do Cantor: ");
                String nomeCantor = scanner.next();
                System.out.println("Digite a idade do Cantor: ");
                int idade = scanner.nextInt();
                new Cantor(nomeCantor, idade);
                } catch (Exception e) {
                System.out.println(e.getMessage());
                }            
            }

            public static void listarProdutora(){
                try {
                    Produtora.select();
                } catch (Exception e) {
                    System.out.println("Erro ao listar Produtora" + "\n" + e.getMessage());
                }    
            }    

            public static void listarCantor(){
                try {
                    Cantor.select();
                } catch (Exception e) {
                    System.out.println("Erro ao listar Cantor" + "\n" + e.getMessage());
                }    
            } 

            public static void removerProdutora(Scanner scanner){ 
                try {
                System.out.println("Digite o id da produtora que deseja excluir: ");
                int id = scanner.nextInt();
                Produtora.delete(id);
                } catch (Exception e) {
                System.out.println("Erro ao excluir produtora" + "\n" + e.getMessage());
                }
            } 

            public static void removerCantor(Scanner scanner){ 
                try {
                System.out.println("Digite o id do Cantor que deseja excluir: ");
                int id = scanner.nextInt();
                Cantor.delete(id);
                } catch (Exception e) {
                System.out.println("Erro ao excluir avião" + "\n" + e.getMessage());
                }
            }

            

            public static void editarProdutora(Scanner scanner) throws Exception{
                System.out.println("Digite o id: ");
                int id = scanner.nextInt();
                System.out.println("Digite o Nome Produtora: ");
                String nomeProdutora = scanner.next();
                System.out.println("Digite o genero: ");
                String genero = scanner.next();
                System.out.println("Digite o cidade: ");
                String cidade = scanner.next();
                System.out.println("Digite o id Cantor: ");
                int idCantor = scanner.nextInt();
        
                Produtora.update(id, nomeProdutora, genero, cidade, Cantor.getById(idCantor), idCantor);
            }

            public static void editarCantor(Scanner scanner) throws Exception{
                System.out.println("Digite o id: ");
                int id = scanner.nextInt();
                System.out.println("Digite o Nome do Cantor: ");
                String nomeCantor = scanner.next();
                System.out.println("Digite a idade: ");
                int idade = scanner.nextInt();
                Cantor.update(id, nomeCantor, idade);
            }

            public static void sair() {
                System.out.println("Saindo...");
                System.exit(0);
            }

        }
