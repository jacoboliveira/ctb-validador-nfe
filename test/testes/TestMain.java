/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.com.ctb.validador.nfe.util.Constants;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jacoboliveira
 */
public class TestMain implements Constants{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Set<String> s = new HashSet<String>(Arrays.asList("a1","a2"));
        p(getPosEl(s, "a3"));
    //    File file = new File("C:\\testesNFE\\5501.xml");
//        PropertyResourceBundle p = new ResourceBundleUtil(FileHelper.getPath2("/elementos-padrao.properties")).getPropertyResourceBundle();
//        Set<String> e = p.keySet();
//        for (String key : e) {
//            System.out.println(key);
//        }
//        //usando JAXB 2
//        //"br.com.ctb.validador.nfe.entities"
//        JAXBContext context = JAXBContext.newInstance(NfeProc.class);
//        Unmarshaller u = context.createUnmarshaller();
//
//        NfeProc raiz = (NfeProc) u.unmarshal(file);
//
////        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
////        dbf.setNamespaceAware(true);
////        DocumentBuilder db = dbf.newDocumentBuilder();
////        Document doc = db.parse(file);
////        Node fooSubtree = doc.getFirstChild();
////        JAXBElement<NfeProc.NFe> nfe = u.unmarshal( fooSubtree, NfeProc.NFe.class);
////        JAXBElement<NfeProc.NFe.Signature> s = u.unmarshal( fooSubtree, NfeProc.NFe.Signature.class);
////        NfeProc.NFe n = nfe.getValue();
////        n.setSignature(s.getValue());
//        System.out.println(raiz);

//---------------------------------------------------------------
//    dom4j
//        SAXReader reader = new SAXReader();
//        File file = new File("C:\\testesNFE\\5501.xml");
//
//        Document document = reader.read(file);
//        Element root = document.getRootElement();
//
////        for(Iterator<Element> ii= root.elementIterator();ii.hasNext();){
////            Element el = ii.next();
////
////            System.out.println(el.getPath());
////        }
////        List<Element> list = document.selectNodes("//nfeProc");
////        for (Element el : list) {
////            System.out.println(el.getName());
////        }
//        //----------------------------------------
////        Element root = document.getRootElement();
////
////        //localiza e seta atributo
////        Iterator<Attribute> i =root.attributeIterator();
////        while(i.hasNext()){
////            Attribute a = i.next();
////            a.setValue("3.00");
////            System.out.println(a.getQName().getName());
////        }
////
////        System.out.println(document.asXML());
//        //----------------------------------------
//
//        //verificar tag faltante
//        List<String> caminhosDefault = Arrays.asList("//nfeProc/NFe/infNFe/det/prod", "//nfeProc/NFe/infNFe/det/@imposto");
//        List<String> tagsObrig = Arrays.asList("prod", "imposto");
//
//        for (String caminhoAAnalisar : caminhosDefault) {
//            List els = document.selectNodes(caminhoAAnalisar,".",true);
//            //for (String tag : tagsObrig) {
//               System.out.println(els.size());
//            //}
//
//        }

        //root.elementIterator(nomeTag);
    }

    static void p(Object s){
        System.out.println(s);
    }

    static int getPosEl(Set<String> mapNFeKeys, String elObrig) {
        List<String> a = Arrays.asList(mapNFeKeys.toArray(new String[mapNFeKeys.size()]));
        return a.indexOf(elObrig);
    }
}
