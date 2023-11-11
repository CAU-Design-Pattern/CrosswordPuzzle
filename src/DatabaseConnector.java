import com.holub.database.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnector {
    private static DatabaseConnector instance;

    private Database database;

    private DatabaseConnector() throws IOException {

        FileInputStream config = new FileInputStream("src/config.properties");
        Properties properties = new Properties();
        properties.load(config);
        String path = properties.getProperty("database.path");
        this.database = new Database(path);
    }

    public static synchronized DatabaseConnector getInstance() throws IOException {
        if (instance == null)
            instance = new DatabaseConnector();
        return instance;
    }

    public Database getDatabase() {
        return this.database;
    }
}
