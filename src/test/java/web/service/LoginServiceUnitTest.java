package web.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Before
    public void setUp() {
        // Initialize test data
    }

    @Test
    public void testValidLogin() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "01-01-1990");
        assertTrue(result);
    }

    @Test
    public void testInvalidUsername() {
        boolean result = LoginService.login("invalid_user", "ahsan_pass", "01-01-1990");
        assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        boolean result = LoginService.login("ahsan", "wrong_pass", "01-01-1990");
        assertFalse(result);
    }

    @Test
    public void testInvalidDOB() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "01-01-2000");
        assertFalse(result);
    }

    @Test
    public void testEmptyUsername() {
        boolean result = LoginService.login("", "ahsan_pass", "01-01-1990");
        assertFalse(result);
    }

    @Test
    public void testEmptyPassword() {
        boolean result = LoginService.login("ahsan", "", "01-01-1990");
        assertFalse(result);
    }

    @Test
    public void testEmptyDOB() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "");
        assertFalse(result);
    }

    @Test
    public void testNullUsername() {
        boolean result = LoginService.login(null, "ahsan_pass", "01-01-1990");
        assertFalse(result);
    }

    @Test
    public void testNullPassword() {
        boolean result = LoginService.login("ahsan", null, "01-01-1990");
        assertFalse(result);
    }

    @Test
    public void testNullDOB() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", null);
        assertFalse(result);
    }

    @Test
    public void testInvalidDOBFormat() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "1990-01-01");
        assertFalse(result);
    }
}
