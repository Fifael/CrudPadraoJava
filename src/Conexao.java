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
                System.out.println("||  9 - Sair                 ||");
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
                        break
                    case 5:
                        removerProdutora(scanner);
                        break;
                    case 6:
                        removerCantor(scanner);
                        break
                    case 7:
                        editarProdutora(scanner);
                        break;
                    case 8:
                        editarCantor(scanner);
                    case 9:
                        sair();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } while (opcao != 9);
        }
            }


            
        try {
            Connection conexao = DAO.createConnection();
            Usuario usuario = new Usuario("JovemD", "Jovem Dex", "hash");

            /* INSERT Usuário */
            /*
             * PreparedStatement stmt = conexao.prepareStatement(
             * "INSERT INTO usuario (user_name, name, password) VALUES (?, ?, ?);"
             * );
             * stmt.setString(1, usuario.getUserName());
             * stmt.setString(2, usuario.getName());
             * stmt.setString(3, usuario.getPassword());
             * stmt.execute();
             */

            /* SELECT ALL USERS */
            imprimirUsuarios(conexao);

            /* DELETE id = 2 */
            /*
             * PreparedStatement stmt = conexao.prepareStatement(
             * "DELETE FROM usuario WHERE id = ?;"
             * );
             * stmt.setInt(1, 2);
             * stmt.execute();
             * imprimirUsuarios(conexao);
             */

            /* UPDATE id = 1 */
            /*
             * stmt = conexao.prepareStatement(
             * "UPDATE usuario SET user_name = ?, name = ?, password = ? WHERE id = ?;"
             * );
             * stmt.setString(1, "maria.dores");
             * stmt.setString(2, "Maria das Dores");
             * stmt.setString(3, "123457");
             * stmt.setInt(4, 1);
             * stmt.execute();
             * imprimirUsuarios(conexao);
             */
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void imprimirUsuarios(Connection conexao) throws Exception {
        ResultSet rs = conexao.createStatement().executeQuery(
                "SELECT * FROM usuario;");
        while (rs.next()) {
            Usuario usuario2 = new Usuario(
                    rs.getInt("id"),
                    rs.getString("user_name"),
                    rs.getString("name"),
                    rs.getString("password"));
            System.out.println(usuario2);
            System.out.println("===================================");
        }
    }
}
