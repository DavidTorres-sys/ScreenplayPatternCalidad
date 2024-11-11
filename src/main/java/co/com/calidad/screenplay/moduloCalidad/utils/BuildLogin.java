package co.com.calidad.screenplay.moduloCalidad.utils;

import co.com.calidad.screenplay.moduloCalidad.models.Login;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;


public class BuildLogin {

    private static final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

    public static Login validLogin() {
        Login login = new Login();
        login.setUsername(environmentVariables.getProperty("valid.username"));
        login.setPassword(environmentVariables.getProperty("valid.password"));
        return login;
    }

    public static Login invalidLogin() {
        Login login = new Login();
        login.setUsername(environmentVariables.getProperty("invalid.username"));
        login.setPassword(environmentVariables.getProperty("invalid.password"));
        return login;
    }
}
