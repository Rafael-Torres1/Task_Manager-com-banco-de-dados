import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DaoTask {

    private static final String URL = "jdbc:mysql://localhost:3306/tasks_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);

    }

    public void insert(Task task){
        String sql = "INSERT INTO tarefas (nome, task, stats) VALUES (?, ?, ?)";
        try (Connection conex = getConnection();
            PreparedStatement stmt = conex.prepareStatement(sql)){


            stmt.setString(1, task.getName());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStats());

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    List<Task> taskList(){
        List<Task> taskList = new ArrayList<>();

        String sql = "SELECT * FROM tarefas";

        try(Connection conex = getConnection();
            Statement stmt = conex.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){

                Task t = new Task();

                t.setId(rs.getInt("id"));
                t.setName(rs.getString("nome"));
                t.setDescription(rs.getString("task"));
                t.setStats(rs.getString("stats"));
                taskList.add(t);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return taskList;
    }

    public void update(int id, String newtask){
        String sql = "UPDATE tarefas SET stats = ? WHERE id  = ?";

        try(Connection conex = getConnection();
            PreparedStatement stmt = conex.prepareStatement(sql)){

            stmt.setString(1, newtask);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void delete(int id){
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try(Connection conex = getConnection();
            PreparedStatement stmt = conex.prepareStatement(sql)){

            stmt.setInt(1, id );
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
