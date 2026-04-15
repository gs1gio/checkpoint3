package br.ulbra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static String url;
    private static String user;
    private static String password;

    static {
        try {
            Properties props = new Properties();
            InputStream input = ConnectionFactory.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");

            props.load(input);
            url = props.getProperty("db.url");

            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar propriedades");
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexão" + e.getMessage());
        }
        return null;
    }
}
