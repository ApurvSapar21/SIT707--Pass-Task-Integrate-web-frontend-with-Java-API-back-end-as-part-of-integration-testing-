package web.service;

public class LoginService {

    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false; // Null values are not allowed
        }
        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false; // Empty values are not allowed
        }
        return isValidUser(username, password, dob);
    }

    private static boolean isValidUser(String username, String password, String dob) {
        // Check if username, password, and dob match expected values
        // Convert DOB format from dd-mm-yyyy to yyyyMMdd
        String formattedDOB = formatDOB(dob);
        if ("ahsan".equals(username) && "ahsan_pass".equals(password) && "19900101".equals(formattedDOB)) {
            return true;
        }
        return false;
    }

    private static String formatDOB(String dob) {
        // Assuming dob format is dd-mm-yyyy, convert it to yyyyMMdd
        String[] parts = dob.split("-");
        if (parts.length == 3) {
            String day = parts[0];
            String month = parts[1];
            String year = parts[2];
            return year + month + day;
        }
        return dob; // Return as-is if format doesn't match
    }
}