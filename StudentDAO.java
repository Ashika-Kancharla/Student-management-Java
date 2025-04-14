import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student s) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO students (id, name, course) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, s.getId());
            stmt.setString(2, s.getName());
            stmt.setString(3, s.getCourse());
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateStudent(Student s) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE students SET name=?, course=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getCourse());
            stmt.setInt(3, s.getId());
            stmt.executeUpdate();
            System.out.println("Student updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
