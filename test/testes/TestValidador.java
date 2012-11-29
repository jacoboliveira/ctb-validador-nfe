/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import br.com.ctb.validador.nfe.entities.InfoErros;
import br.com.ctb.validador.nfe.valnfe.ValidadorNFe;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.JDOMException;

/**
 *
 * @author yaaqovtatas777
 */
public class TestValidador extends TestMain{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            String caminhoArq = "C:/testesNFe/5501.xml";
            List<InfoErros> i = new ArrayList<InfoErros>();
            //
            ValidadorNFe analisarNFe = new ValidadorNFe();
            analisarNFe.setNfeXml(new File(caminhoArq));
            analisarNFe.setInfoErrosList(i);
            analisarNFe.analisarArqNFe();

            List<InfoErros> l = analisarNFe.getInfoErrosList();
            //imprimir a qtde de arqs com erros
            //p(analisarNFe.getInfoErrosList().size());

            ValidadorNFe corrigirNFe = new ValidadorNFe();
            corrigirNFe.setInfoErrosList(i);
            try {
                corrigirNFe.corrigirErrosDocNFe(false, new File("C:\\Users\\yaaqovtatas777\\Desktop"),null);
            } catch (JDOMException ex) {
                Logger.getLogger(TestValidador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TestValidador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JDOMException ex) {
            Logger.getLogger(TestValidador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestValidador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(TestValidador.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

    

}
