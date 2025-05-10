package co.edu.uniquindio.ingesis;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScriptExecutor {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    public ScriptExecutor() {
        Dotenv dotenv = Dotenv.load();
        this.dbUrl = dotenv.get("DB_URL");
        this.dbUser = dotenv.get("DB_USER");
        this.dbPassword = dotenv.get("DB_PASSWORD");
    }

    public void ejecutarScriptDesdeArchivo(String rutaArchivoSql) throws Exception {
        String sql = new String(Files.readAllBytes(Paths.get(rutaArchivoSql)));

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Script ejecutado correctamente.");
        }
    }

    public void ejecutarScriptDesdeTexto(String sql) throws Exception {
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Script ejecutado correctamente.");
        }
    }
}
