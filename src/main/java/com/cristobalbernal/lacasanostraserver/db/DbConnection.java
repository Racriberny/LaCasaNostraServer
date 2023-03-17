package com.cristobalbernal.lacasanostraserver.db;


import com.cristobalbernal.lacasanostraserver.LaCasaNostraServerApplication;
import com.cristobalbernal.lacasanostraserver.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase Singleton para obtener una conexión a la base de datos.
 * Para un servidor real que atendiera varias peticiones de forma simultánea
 * debería crearse un pool de conexiones.
 */
public class DbConnection {
    private final static String TAG = "DbConnection";
    private static DbConnection instance = null;
    private String DB_SERVER = "localhost:3306";
    private String DB_NAME = "LaCasaNostra";
    private String DB_USERNAME = "root";
    private String DB_PASSWORD = "";
    public Connection connection;

    /** Constructor private para evitar que sea instanciado */
    private DbConnection() {
        /** Se deja vacío porque estamos definiendo una clase Singleton */
    }

    /**
     * Obtiene la instancia para la conexión a la base de datos.
     * Hacemos el método synchronized para evitar que 2 hilos puedan crear
     * instancias diferentes.
     * @return DbConnection
     */
    public synchronized static DbConnection getInstance() {
        if(instance == null) {
            instance = new DbConnection();
            if(LaCasaNostraServerApplication.CONFIG_FILE != null) {
                instance.readConfig(LaCasaNostraServerApplication.CONFIG_FILE);
            }
            instance.connect();
        }
        return instance;
    }

    /**
     * Conecta a la base de datos
     * @return true si la conexión ha sido satisfactoria, false en caso contrario.
     */
    private boolean connect() {
        boolean success = false;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://"+DB_SERVER+"/"+DB_NAME;
            connection = DriverManager.getConnection (url,DB_USERNAME,DB_PASSWORD);
            success = true;
        } catch (ClassNotFoundException ex) {
            Log.e(TAG,"No se ha podido cargar el driver de conexión a base de datos");
            Log.e(TAG, ex.getMessage());
            ex.printStackTrace();
        } catch(SQLException sqle) {
            Log.e(TAG,"Error al conectar con la base de datos");
            Log.e(TAG, sqle.getMessage());
        }
        return success;
    }

    public void destroy() {
        try {
            connection.close();
            Log.i(TAG, "Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Log.e(TAG, ex.getMessage());
        }
        instance = null;
    }

    private void readConfig(String filename) {
        Properties prop = new Properties();
        InputStream in;
        try {
            in = new FileInputStream(filename);
            prop.load(in);
            DB_SERVER = prop.getProperty("DB_SERVER", "locahost:3306");
            DB_NAME = prop.getProperty("DB_NAME", "german");
            DB_USERNAME = prop.getProperty("DB_USERNAME", "root");
            DB_PASSWORD = prop.getProperty("DB_PASSWORD", "");
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Archivo " + filename + " no encontrado");
            Log.e(TAG, e.getMessage());
        } catch (IOException io) {
            Log.e(TAG, "Error al leer el archivo configuración " + filename);
        }
    }
}

