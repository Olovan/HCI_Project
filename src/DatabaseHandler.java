package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Holds the player data that is to be read from the database
 * and handles all database communications.
 */
public class DatabaseHandler {
  private static final String DATABASE = "player_scores.sqlite3";
  private Connection conn = null;
  private ArrayList<String[]> scores;

  /**
   * Takes the data stored in the given table
   * and puts it in the scores variable, updating the ScoreView.
   *
   * @param table The table in the database to get the players from.
   */
  public void updatePlayers(String table) {
    this.scores = getPlayers(table, "ORDER BY score DESC LIMIT 10");
    Object[] container = {"", scores};

  }

  /**
   * Given all the information for a player, add them to the database.
   *
   * @param table The table in the database to put the player in.
   * @param name  The name of the player.
   * @param score The score the player attained.
   * @param time  The amount of time the player took.
   * @param moves The number of moves the player used.
   */
  public void addPlayer(String table, String name, Integer score, Integer time, Integer moves) {
    String playerId = null;
    try {
      Connection db = connect(DATABASE);
      String sql = "INSERT INTO " + table + " (name, score, time, moves) VALUES (?, ?, ?, ?)";
      PreparedStatement stmt = db.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      stmt.setString(1, name);
      stmt.setInt(2, score);
      stmt.setObject(3, time);
      stmt.setObject(4, moves);
      stmt.executeUpdate();

      ResultSet rs = stmt.getGeneratedKeys();
      rs.next();
      playerId = String.valueOf(rs.getInt(1));
    } catch (SQLException e) {
      e.printStackTrace();
    }

    scores = getPlayers(table, "ORDER BY score DESC LIMIT 10");
    String finalPlayerId = playerId;
    String message = scores.stream()
            .map(o -> o[0])
            .anyMatch(p -> p.equals(finalPlayerId)) ? "high_score" : "regular_score";
    Object[] container = {message, scores};
  }

  private ArrayList<String[]> getPlayers(String table, String queryModifiers) {
    ResultSet resultSet;
    ArrayList<String[]> people = new ArrayList<>();
    try {
      Connection db = connect(DATABASE);
      String sql = "SELECT rowid, * FROM " + table + " " + queryModifiers;
      resultSet = db.createStatement().executeQuery(sql);
      while (resultSet.next()) {
        String id = String.valueOf(resultSet.getInt(1));
        String name = resultSet.getString(2);
        String score = String.valueOf(resultSet.getInt(3));
        String time = String.valueOf(resultSet.getInt(4));
        String moves = String.valueOf(resultSet.getInt(5));

        people.add(new String[]{id, name, score, time, moves});
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return people;
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