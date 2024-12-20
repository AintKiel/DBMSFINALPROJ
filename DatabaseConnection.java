import java.sql.*;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/scholarshipdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static int getLatestSerialNumber() {
        String query = "SELECT MAX(serial_number) AS max_serial FROM qualifierslist";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                int maxSerial = rs.getInt("max_serial");
                return rs.wasNull() ? 1 : maxSerial + 1;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching the latest serial number: " + e.getMessage());
        }
        return 1;
    }

    public static void saveQualifier(String lastName, String firstName, String middleName,
                                     String educationLevel, String academicInstitution, String email, int serialNumber) {
        // Query for the qualifierslist table
        String generalQuery = "INSERT INTO qualifierslist (serial_number, last_name, first_name, middle_name, academic_institution, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        // Query for specific tables
        String specificTableQuery = null;
        if ("college".equalsIgnoreCase(educationLevel)) {
            specificTableQuery = "INSERT INTO college_qualifiers (serial_number, last_name, first_name, middle_name, academic_institution, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        } else if ("senior high school".equalsIgnoreCase(educationLevel)) {
            specificTableQuery = "INSERT INTO senior_high_qualifiers (serial_number, last_name, first_name, middle_name, academic_institution, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
        } else {
            System.err.println("Invalid education level: " + educationLevel);
            return; // Exit if education level is invalid
        }

        try (Connection conn = getConnection();
             PreparedStatement generalStmt = conn.prepareStatement(generalQuery);
             PreparedStatement specificStmt = conn.prepareStatement(specificTableQuery)) {

            // Insert into qualifierslist table
            generalStmt.setInt(1, serialNumber);
            generalStmt.setString(2, lastName);
            generalStmt.setString(3, firstName);
            generalStmt.setString(4, middleName);
            generalStmt.setString(5, academicInstitution);
            generalStmt.setString(6, email);
            generalStmt.executeUpdate();

            // Insert into specific table
            specificStmt.setInt(1, serialNumber);
            specificStmt.setString(2, lastName);
            specificStmt.setString(3, firstName);
            specificStmt.setString(4, middleName);
            specificStmt.setString(5, academicInstitution);
            specificStmt.setString(6, email);
            specificStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error saving qualifier: " + e.getMessage());
        }
    }

    // Validation method for field names
    private static boolean isFieldValid(String field) {
        // Accept camelCase field names and map to database column names
        switch (field) {
            case "lastName", "firstName", "middleName", "educationLevel",
                 "academicInstitution", "email":
                return true;
            default:
                return false;
        }
    }

    public static void updateQualifier(int serialNumber, String field, String newValue) throws SQLException {
        if (!isFieldValid(field)) {
            throw new SQLException("Invalid field name: " + field);
        }

        // Map camelCase to database column names
        String columnName = switch (field) {
            case "lastName" -> "last_name";
            case "firstName" -> "first_name";
            case "middleName" -> "middle_name";
            case "educationLevel" -> "education_level";
            case "academicInstitution" -> "academic_institution";
            case "email" -> "email";
            default -> field;
        };

        String query = "UPDATE qualifierslist SET " + columnName + " = ? WHERE serial_number = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newValue);
            pstmt.setInt(2, serialNumber);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Qualifier updated successfully.");
            } else {
                System.out.println("No qualifier found with the given serial number.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating qualifier: " + e.getMessage());
        }
    }

    public static void deleteQualifier(int serialNumber) {
        String query = "DELETE FROM qualifierslist WHERE serial_number = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, serialNumber);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Qualifier deleted successfully.");
            } else {
                System.out.println("No qualifier found with the given serial number.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting qualifier: " + e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
