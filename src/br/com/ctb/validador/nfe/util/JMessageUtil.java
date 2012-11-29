/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

import br.com.jacob.util.DateUtil;
import java.awt.Component;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author jacoblisboa
 */
public class JMessageUtil {

    private List<String> mensagens = new ArrayList<String>();

    public static void showWarningMessage(Component comp, String message) {
        JTextArea area = new JTextArea(10, 30);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setEditable(false);
        area.append(message);
        JOptionPane.showMessageDialog(comp, new JScrollPane(area), "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * 
     * @param comp
     * @param message
     * @param titulo
     * @return
     */
    public static String showInputMessage(Component comp, Object message) {
        return JOptionPane.showInputDialog(comp, message, "Pergunta:", JOptionPane.QUESTION_MESSAGE);
    }



    public static int showOptionDialog(Component comp, Object message,String titulo,Object valorDefault,Object[] opcoes){
        return JOptionPane.showOptionDialog(comp,
                message,
                titulo,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                ImageUtil.getImageIconResource(Constants.PATH_IMAGES + "localizar.gif"),
                opcoes,
                valorDefault);
    }

     /**
     *
     * @param message
     * @param titulo
     * @param textInputInitialize
     * @param comp
     * @param valoresSelecionados
     * @return
     */
    public static Object showInputMessage(Component comp,Object message,Object[] valoresSelecionados) {
        return JOptionPane.showInputDialog(comp,
                message,
                "Pergunta:",
                JOptionPane.QUESTION_MESSAGE,
                ImageUtil.getImageIconResource(Constants.PATH_IMAGES + "help.gif"),
                valoresSelecionados,null);
    }
    /**
     * 
     * @param message
     * @param titulo
     * @param textInputInitialize
     * @param comp
     * @param valoresSelecionados
     * @return
     */
    public static Object showInputMessage(Component comp,Object message,String titulo,Object[] valoresSelecionados) {
        return JOptionPane.showInputDialog(comp,
                message,
                titulo,
                JOptionPane.QUESTION_MESSAGE,
                ImageUtil.getImageIconResource(Constants.PATH_IMAGES + "help.gif"),
                valoresSelecionados,null);
    }

    public static void showInfoMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showSucessMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Sucesso", JOptionPane.INFORMATION_MESSAGE, ImageUtil.getImageIconResource(Constants.PATH_IMAGES + "sucess_msg.png"));
    }

    public static void showErroMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Erro Ocorrido", JOptionPane.ERROR_MESSAGE);
    }

    public void showWarningMessages(Component comp) {
        JTextArea area = new JTextArea(10, 50);
        area.setEditable(false);
        for (String msg : mensagens) {
            area.append("\n\t+" + msg);
        }
        JOptionPane.showMessageDialog(comp, new JScrollPane(area), "", JOptionPane.WARNING_MESSAGE);
    }

    public int showWarningMessagesList(Component comp, String message) {
        JTextArea area = new JTextArea(10, 50);
        area.append(message + "\n\n");
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        for (String msg : mensagens) {
            area.append("\n\t+" + msg);
        }
        return JOptionPane.showConfirmDialog(comp, new JScrollPane(area), "", JOptionPane.WARNING_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
    }

    public static int showConfirm(String message) {
        return JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.OK_CANCEL_OPTION);
    }

    public synchronized void addMensagem(String msg) {
        mensagens.add(msg);
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public String getMensagemFormatada() {
        StringBuilder str = new StringBuilder();
        for (String msg : mensagens) {
            str.append("-> ").append(msg).append("\n");
        }
        return str.toString();
    }

    public boolean isMessages() {
        return (mensagens != null && !mensagens.isEmpty());
    }

    //--------------------------------------------------
    public static void messageLog(String msg) {
        System.out.println("[" + DateUtil.getDataHoje2() + "]: " + msg);
    }

    public static void printFields(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        List lista = new ArrayList();
        for (Field field : fields) {
            try {
                lista.add(BeanUtils.getProperty(bean, field.getName()));
            } catch (IllegalAccessException ex) {
                //    Logger.getLogger(JMessageUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                //    Logger.getLogger(JMessageUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                //     Logger.getLogger(JMessageUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(lista);
    }

//    public static void main(String args[]){
//        try {
//            System.out.println(showInputMessage(null,"sdasd", "Pergunta", WrapperUtils.wrapperArrayBeansToArray(new Object(), new Object())));
//        } catch (Exception ex) {
//            Exceptions.printStackTrace(ex);
//        }
//    }

}
