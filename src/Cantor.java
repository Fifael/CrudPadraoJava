import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Cantor {

    private int id;
    private String nomeCantor;
    private int idade;

    public Cantor() {

    }

    public Cantor(String nomeCantor, int idade) throws Exception {
        this.nomeCantor = nomeCantor;
        this.idade = idade;
         
        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO cantor (nomeCantor, idade) VALUES (?,?);");
            stmt.setString(1, this.getNomeCantor());
            stmt.setInt(2, this.getIdade());
            stmt.execute();
            DAO.closeConnection();
    }

    public Cantor(int id, String nomeCantor, int idade) throws Exception {
        this.id = id;
        this.nomeCantor = nomeCantor;
        this.idade = idade;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
            "INSERT INTO cantor (id, nomeCantor, idade) VALUES (?,?,?,);");
            stmt.setInt(1, this.getId());
            stmt.setString(1, this.getNomeCantor());
            stmt.setInt(2, this.getIdade());
            stmt.execute();
            DAO.closeConnection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override 
    public String toString(){
        return "Cantor [id: " + id + ", nomeCantor: " + nomeCantor + ", idade: " + idade + "]";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Cantor c = (Cantor) obj;
        return c.getId() == this.getId();
    }

    public static Cantor getById(int id) throws Exception {
        PreparedStatement select = DAO.createConnection().prepareStatement("SELECT * FROM cantor WHERE id = ?;");
        select.setInt(1, id);
        ResultSet rs = select.executeQuery();

        if (rs.next()) {
            Cantor cantor = new Cantor();
            cantor.setId(rs.getInt("id"));
            cantor.setNomeCantor(rs.getString("NomeCantor"));
            cantor.setIdade(rs.getInt("Idade"));
            return cantor;
        }

        throw new Exception("Cantor inexistente! ");
    }    

    public static void select() throws Exception {
        Connection select = DAO.createConnection();
        ResultSet rs = select.createStatement().executeQuery(
            "SELECT * FROM Cantor;"
        );
        while (rs.next()) {
            System.out.println(
                "=======================================" + "\n" +
                "Id: " + 
                rs.getInt("id") + "\n" +
                "Nome: " +
                rs.getString("nome") + "\n" +
                "Idade: " +
                rs.getInt("idade") + "\n" +
                "======================================="
            );
        }
        select.close();
    }

    public static void update(int id, String nomeCalendario, int idade) throws Exception {
        Connection update = DAO.createConnection();
        PreparedStatement stmt = update.prepareStatement(
            "UPDATE cantor SET nome = ?, idade = ? WHERE id = ?;"
        );
        stmt.setString(1, "Nome");
        stmt.setInt(2, idade);
        stmt.setInt(3, id);
        stmt.execute();
        stmt.close();
        update.close();
    }

    public static void delete(int id) throws Exception {
        Connection delete = DAO.createConnection();
        PreparedStatement stmt = delete.prepareStatement(
            "DELETE FROM companhia WHERE id = ?;"
        );
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        delete.close();
    }
    
}
