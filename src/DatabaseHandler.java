import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private static final String DATABASE = ".\\database.sqlite3";
    private static Connection conn = null;

	public static void connectToDatabase() {
		connect(DATABASE);
		System.out.println("Database Opened");
	}

	public static void disconnectFromDatabase() {
		try {
			conn.close();
		} catch (Exception e) {
			//Ignored
		}
	}

    public static void addDebt(String label, Double amount, String date, Integer owner) {
		modify("INSERT INTO debts (label, amount, date, owner) VALUES ( \""  + label + "\", " + amount + ", \"" + date + "\", " + owner + ");");
    }

    public static ArrayList<Object[]> getDebts(String queryModifiers) {
        return select("debtId, label, date, amount", "debts", queryModifiers);
    }

    public static Integer addRecord(Integer personId, Integer debtId) {
            return insert("personId, debtId", "records", String.format("%d, %d", personId, debtId));
    }

    private static ArrayList<Object[]> getRecords(String queryModifiers) {
            return select("personId, debtId", "records", queryModifiers);
    }
    public static Integer addPerson(String name) {
        return insert("name", "people", '"' + name + '"');
    }

    public static ArrayList<Object[]> getPeople(String queryModifiers) {
        return select("personId, name", "people", queryModifiers);
    }

    public static Integer insert(String fields, String table, String values) {
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

    public static ArrayList<Object[]> select(String fields, String table, String queryModifiers) {
        ResultSet resultSet;
        ArrayList<Object[]> results = new ArrayList<>();
        try {
            Connection db = connect(DATABASE);
            String sql = "SELECT " + fields + " FROM " + table + " " + queryModifiers;
            resultSet = db.createStatement().executeQuery(sql);

            Integer fieldCount = fields.split(",").length;
            while(resultSet.next()) {
            	Object[] row = new Object[fieldCount];
				for (int i = 0; i < fieldCount; i++) {
					row[i] = resultSet.getObject(i+1);
				}
				results.add(row);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

	public static void modify(String statement) {
        try {
            Connection db = connect(DATABASE);
            PreparedStatement stmt = db.prepareStatement(statement);
            stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Object[]> select(String statement, int fieldCount) {
        ResultSet resultSet;
        ArrayList<Object[]> results = new ArrayList<>();
        try {
            Connection db = conn;
            String sql = statement;
            resultSet = db.createStatement().executeQuery(sql);

            while(resultSet.next()) {
            	Object[] row = new Object[fieldCount];
				for (int i = 0; i < fieldCount; i++) {
					row[i] = resultSet.getObject(i+1);
				}
				results.add(row);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
	}

    private static Connection connect(String path) {
        String url = "jdbc:sqlite:" + path;

        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
