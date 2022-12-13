import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Produtora {

    private int id;
    private String nomeProdutora;
    private String genero;
    private String cidade;
    private int idCantor;
    private Cantor cantor;

    public Produtora() {

    }

    public Produtora(int id, String nomeProdutora, String genero, String cidade, int idCantor, Cantor cantor) throws Exception {
        this.id = id;
        this.nomeProdutora = nomeProdutora;
        this.genero = genero;
        this.cidade = cidade;
        this.idCantor = idCantor;
        this.cantor = Cantor.getById(idCantor);

        PreparedStatement stmt = DAO.createConnection().prepareStatement( 
        "INSERT INTO produtora (id, nomeProdutora , genero, cidade , cantor_id) VALUES (?, ?, ?, ?, ?);");
        stmt.setInt(1, id);
        stmt.setString(2, nomeProdutora);
        stmt.setString(3, genero);
        stmt.setString(4, cidade);
        stmt.setInt(5, idCantor);
        stmt.execute();
        stmt.close();
        }   

    public Produtora(String nomeProdutora, String genero, String cidade, int idCantor, Cantor cantor) throws Exception {
        this.nomeProdutora = nomeProdutora;
        this.genero = genero;
        this.cidade = cidade;
        this.idCantor = idCantor;
        this.cantor = cantor;
    

    PreparedStatement stmt = DAO.createConnection().prepareStatement( 
        "INSERT INTO produtora (nomeProdutora , genero, cidade , cantor_id) VALUES (?, ?, ?, ?);");
        stmt.setString(1, nomeProdutora);
        stmt.setString(2, genero);
        stmt.setString(3, cidade);
        stmt.setInt(4, idCantor);
        stmt.execute();
        stmt.close();
        } 

    public int getIdCantor() {
        return idCantor;
    }

    public void setIdCantor(int idCantor) {
        this.idCantor = idCantor;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProdutora() {
        return nomeProdutora;
    }

    public void setNomeProdutora(String nomeProdutora) {
        this.nomeProdutora = nomeProdutora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Produtora [ id=" + id
                + ", nomeProdutora=" + nomeProdutora
                + ", genero=" + genero
                + ", cidade="  + cidade 
                + ", idCantor=" + idCantor
                + "; Cantor=" + cantor + "]";
    }

    public static void select() throws Exception {
        Connection select = DAO.createConnection();
        ResultSet rs = select.createStatement().executeQuery(
            "SELECT * FROM produtora;"
        );
        while (rs.next()) {
            System.out.println(
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + "\n" +
                "Id: " + 
                rs.getInt("idProdutora") + "\n" +
                "Nome Produtora: " +  
                rs.getString("nomeProdutora") + "\n" + 
                "genero: " +
                rs.getString("genero") + "\n" +
                "cidade: " +
                rs.getString("cidade") + "\n" +
                "Id do Cantor: " +
                rs.getInt("cantor_id") + "\n" +
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
            );
        }
        rs.close();
        select.close();
    }

    public static void update(int id, String nomeProdutora, String genero, String cidade,  Cantor cantor, int idCantor) throws Exception{
        Connection update = DAO.createConnection();
        PreparedStatement stmt = update.prepareStatement(
            "UPDATE produtora SET nomeProdutora = ?, genero = ?, cidade = ?, cantor_id = ? WHERE id = ?;"
        );
        stmt.setString(1, nomeProdutora);
        stmt.setString(2, genero);
        stmt.setString(3, cidade);
        stmt.setInt(4, idCantor);
        stmt.setInt(5, id);
        stmt.execute();
        stmt.close();
        update.close();
    }

    public static void delete(int id) throws Exception{
        Connection delete = DAO.createConnection();
        PreparedStatement stmt = delete.prepareStatement(
            "DELETE FROM produtora WHERE idProdutora = ?;"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        delete.close();
    }

    public static Produtora getById(int id) {
        return new Produtora();
    }

}