package connector;

import com.holub.database.Database;
import com.holub.database.TableFactory;
import com.holub.text.ParseFailure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConnector {
    private static DatabaseConnector instance;

    private Database database;

    private DatabaseConnector() throws IOException, ParseFailure {
        Properties properties = getProperties();
        String path = properties.getProperty("database.path");
        this.database = new Database(path);

        // table 생성 로직은 별도 분리 ?
        String[] tableList = properties.getProperty("database.tableList").split(",");
        System.out.println("테이블 생성");
        for (String tableName : tableList) {
            try{
            	System.out.println("[Table load : " + tableName + " ]");
                TableFactory.load(tableName + ".csv", path);
                System.out.println("[Table load success : " + tableName + " ]");
            } catch (IOException e){
            	System.out.println("[Table load fail : " + tableName + " ]");
                String columns = properties.getProperty("table." + tableName);
                database.execute("create table " + tableName + "("+columns+")");
                System.out.println("[Table create : " + tableName + " ]");
            }
        }
    }

    private Properties getProperties() throws IOException {
        FileInputStream config = new FileInputStream("src/config.properties");
        Properties properties = new Properties();
        properties.load(config);
        return properties;
    }

    public static synchronized DatabaseConnector getInstance() throws IOException, ParseFailure {
        if (instance == null)
            instance = new DatabaseConnector();
        return instance;
    }

    public Database getDatabase() {
        return this.database;
    }
}
