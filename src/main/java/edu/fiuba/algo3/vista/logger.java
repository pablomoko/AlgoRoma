package edu.fiuba.algo3.vista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logger {
    private static final Logger logger = LogManager.getLogger(logger.class);

    /*public static void main(String[] args) {
        logger.info("Comiendo un panchito");
        logger.error("Mensaje de error");
        logger.info("");
    }*/

    public static void info(String mensaje){
        logger.info(mensaje);
    }

    public static void error(String mensaje){
        logger.error(mensaje);
    }

    public static void debug(String mensaje){
        logger.debug(mensaje);
    }


}
