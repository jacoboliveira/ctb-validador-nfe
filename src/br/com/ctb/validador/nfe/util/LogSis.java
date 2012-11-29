/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author jacoboliveira
 */
public class LogSis {
    private static final Logger logger = Logger.getLogger("LogSistema");

    public LogSis() {
        //TODO fazer uma rotina criar uma pasta 'logs' e transferir o arquivo sis.log para dentro da mesma
        try {
         
//            String p = FileHelper.getLocationAppPath()
//                    +SO.getSepArqSO()
//                    +"ctb-validador-nfe~jacob-svn"
//                    +SO.getSepArqSO()
//                    +"ctb-validador-nfe"
//                    +SO.getSepArqSO()
//                    +"build"
//                    +SO.getSepArqSO()
//                    +"classes"+SO.getSepArqSO()+"sis.log";
            String appPath =FileHelper.getLocationAppPath();
            System.out.println(appPath);
            File arq = new File(appPath+SO.getSepArqSO()+"sis.log");
            if(!arq.exists()){
                arq.createNewFile();
            }
            FileHandler fh = new FileHandler(arq.getPath(), true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException ex) {
            Logger.getLogger(LogSis.class.getName()).log(Level.SEVERE, "ocorreu um erro de comunicação ao tentar criar o arquivo, verificar permissões do mesmo ou se o caminho esta correto!", ex);
        } catch (SecurityException ex) {
            Logger.getLogger(LogSis.class.getName()).log(Level.SEVERE, "gerenciamento de segurança do log inexistente", ex);
        }
    }

    public void alerta(String msg){
        logger.log(Level.WARNING, msg);
    }

    public void info(String msg){
        logger.log(Level.INFO, msg);
    }

    public void erro(String msg){
        logger.log(Level.SEVERE, msg);
    }

    public void info(String msg,Throwable ex){
        logger.log(Level.INFO, msg,ex);
    }

    public void alerta(String msg,Throwable ex){
        logger.log(Level.WARNING, msg,ex);
    }

    public void erro(String msg,Throwable ex){
        logger.log(Level.SEVERE, msg,ex);
    }

//    public static void main(String[] args) {
//        //TODO implementar: impl. uma classe de log p/ o sis., para registra os logs do sistema
//        new LogSis().erro("again erro fatality!",new Exception());
////        Logger logger = Logger.getLogger("MyLog");
////        FileHandler fh;
////
////        try {
////
////            // This block configure the logger with handler and formatter
////            fh = new FileHandler("c:\\MyLogFile.log", true);
////            logger.addHandler(fh);
////            logger.setLevel(Level.ALL);
////            SimpleFormatter formatter = new SimpleFormatter();
////            fh.setFormatter(formatter);
////
////            // the following statement is used to log any messages
////            logger.log(Level.WARNING, "My first log");
////
////        } catch (SecurityException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//    }
}
