package shopServer.Services;

//Here we import all the needed libraries for the conexion with the data base

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.dbcp2.BasicDataSource;

public class DataBase {
    //Here we declare the and initialize the object that will work with the data base
    private BasicDataSource bDS = new BasicDataSource();
    //Here we declare the needed objects for an connexion with the DB
    private Connection cnx;
    private Statement st;
    private ResultSet rs;

    //Here we create a public constructor of the class in wich we will put all the needed parameters to start a
    //connexion with the DB
    public DataBase() {
        this.bDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.bDS.setUrl("jdbc:mysql://localhost/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC");
        this.bDS.setUsername("root");
        this.bDS.setPassword("TheBestShop");
        this.bDS.setMinIdle(5);
        this.bDS.setMaxIdle(10);
        this.bDS.setMaxOpenPreparedStatements(100);
    }

    //Here we create the functions to start or close a connexion
    public void connect() throws SQLException {
        this.cnx = this.bDS.getConnection();
    }

    public void closeConnexion() throws SQLException {
        this.cnx.close();
    }

    //Here we create the function to insert data to the DB

    public void insert(String sql) {
        try {
            this.connect();
            this.st = this.cnx.createStatement();
            this.st.executeUpdate(sql);
            this.closeConnexion();
        } catch (SQLException ex) {
            System.out.println("/////////////////INSERT ERROR///////////////\nSql code:" + sql + "\n ERROR MESSAGE: "
                    + ex.getMessage());
        }
    }

    //Here we create the function to modify data to the DB

    public void modify(String sql) {
        try {
            this.connect();
            this.st = this.cnx.createStatement();
            this.st.executeUpdate(sql);
            this.closeConnexion();
        } catch (SQLException ex) {
            System.out.println("/////////////////MODIFY ERROR///////////////\nSql code:" + sql + "\n ERROR MESSAGE: "
                    + ex.getMessage());
        }
    }

    //Here we create the function to consult data from the DB, the consult will be retrieved
    // in an bidimensional ArrayList

    public ArrayList<ArrayList<Object>> consult(String sql) {
        ArrayList res = new ArrayList();
        try {
            this.connect();
            this.st = this.cnx.createStatement();
            this.rs = this.st.executeQuery(sql);
            ResultSetMetaData md = this.rs.getMetaData();
            int columns = md.getColumnCount();

            for (int line = 0; this.rs.next(); line++) {
                res.add(new ArrayList());
                for (int column = 0; column < columns; column++) {
                    ((ArrayList) res.get(line)).add(this.rs.getObject(column + 1));
                }
            }
            this.closeConnexion();
        } catch (SQLException ex) {
            System.out.println("/////////////////CONSULT ERROR///////////////\nSql code:" + sql + "\n ERROR MESSAGE: "
                    + ex.getMessage());
        }
        return res;
    }

}
