import java.sql.*;
import java.util.ArrayList;

/**
 * Holds the person data that is to be read from the database
 * and handles all database communications.
 */
public class DatabaseHandler {
    private static final String DATABASE = "database.sqlite3";
    private Connection conn = null;

    public Integer addDebt(String label, Date date, Integer amount) {
            return insert("label, date, amount", "debts", String.format("\"%s\", %s, %d", label, date, amount));
    }

    public ArrayList<Object> getDebts(String queryModifiers) {
        return select("debtId, label, date, amount", "debts", queryModifiers);
    }

    public Integer addRecord(Integer personId, Integer debtId) {
            return insert("personId, debtId", "records", String.format("%d, %d", personId, debtId));
    }

    private ArrayList<Object> getRecords(String queryModifiers) {
            return select("personId, debtId", "records", queryModifiers);
    }
    public Integer addPerson(String name) {
        return insert("name", "people", '"' + name + '"');
    }

    private ArrayList<Object> getPeople(String queryModifiers) {
        return select("personId, name", "people", queryModifiers);
    }

    public Integer insert(String fields, String table, String values) {
        Integer id = null;
        try {
            Connection db = connect(DATABASE);
            String sql = "INSERT INTO " + table + " (" + fields + ") VALUES (" + values + ");";
            PreparedStatement stmt = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            id = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<Object> select(String fields, String table, String queryModifiers) {
        ResultSet resultSet;
        ArrayList<Object> results = new ArrayList<>();
        try {
            Connection db = connect(DATABASE);
            String sql = "SELECT " + fields + " FROM " + table + " " + queryModifiers;
            resultSet = db.createStatement().executeQuery(sql);
            for (int i = 1; resultSet.next(); i++) {
                results.add(resultSet.getObject(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    private Connection connect(String path) {
        String url = "jdbc:sqlite:" + path;

        try {
            conn = DriverManager.getConnection(url);
            if (conn != null) {
                conn.getMetaData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}