package co.edu.uniquindio.ingesis.utils;

import co.edu.uniquindio.ingesis.ScriptExecutor;
import static org.junit.jupiter.api.Assertions.fail;
import java.nio.file.Paths;

public class SqlTestUtils {

    public static void executeFileSql(String rutaRelativa) {
        try {
            ScriptExecutor executor = new ScriptExecutor();
            String rutaAbsoluta = String.valueOf(Paths.get(rutaRelativa).toAbsolutePath());
            executor.ejecutarScriptDesdeArchivo(rutaAbsoluta);
        } catch (Exception e) {
            fail("Se esperaba que no se lanzara ninguna excepción, pero se lanzó: " + e.getMessage());
        }
    }
}
