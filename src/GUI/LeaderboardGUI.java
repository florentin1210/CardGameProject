package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class LeaderboardGUI extends JFrame {
    private JTable leaderboardTable;

    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/loginschema";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "dan1234";

    public LeaderboardGUI() {
        setTitle("Leaderboard - Top 10 Players by Wins");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        Vector<Vector<Object>> leaderboardData = getLeaderboardData();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Rank");
        columnNames.add("Username");
        columnNames.add("Wins");

        DefaultTableModel tableModel = new DefaultTableModel(leaderboardData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        leaderboardTable = new JTable(tableModel);
        leaderboardTable.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private Vector<Vector<Object>> getLeaderboardData() {
        Vector<Vector<Object>> data = new Vector<>();

        String query = "SELECT username, wins FROM users ORDER BY wins DESC LIMIT 10";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            int rank = 1;
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rank++);  // Rank
                row.add(resultSet.getString("username"));
                row.add(resultSet.getInt("wins"));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching leaderboard data.");
        }

        return data;
    }
}