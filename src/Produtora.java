import java.sql.PreparedStatement;

public class Produtora {

    private int id;
    private String nomeProdutora;
    private String genero;
    private String cidade;

    public Produtora(String nomeProdutora, String genero, String cidade) throws Exception {
        this.nomeProdutora = nomeProdutora;
        this.genero = genero;
        this.cidade = cidade;

        PreparedStatement stmt = DAO.createConnection().prepareStatement(
        "INSERT INTO produtora (user_name, genero, cidade) VALUES (?, ?, ?);");
        stmt.setString(1, this.getNomeProdutora());
        stmt.setString(2, this.getGenero());
        stmt.setString(3, this.getCidade());
        stmt.execute();
        DAO.closeConnection();
    }

    public Produtora(int id, String nomeProdutora, String genero, String cidade) {
        this.id = id;
        this.nomeProdutora = nomeProdutora;
        this.genero = genero;
        this.cidade = cidade;
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
        return "Produtora{"
                + "id=" + id
                + ", nomeProdutora=" + nomeProdutora
                + ", genero=" + genero
                + ", cidade=" + cidade + '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !(object instanceof Produtora)) {
            return false;
        }
        final Produtora other = (Produtora) object;

        return this.id == other.id;
    }
}