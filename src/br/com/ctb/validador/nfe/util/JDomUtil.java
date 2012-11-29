/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author yaaqovtatas777
 */
public class JDomUtil {

    Document document;
    Element root;

    public JDomUtil(Document document) {
        this.document = document;
    }

    public JDomUtil(Document document, Element root) {
        this.document = document;
        this.root = root;
    }

    /**
     * adiciona o elemento contendo a raiz como namespace
     * devido o elemento raiz conter o namespace, eh necessario passar o objeto para os elementos-filhos
     * @param el elemento-filho ascendente
     * @param newEl novo elemento-filho
     */
    public void adicElFilho(Element el, Element newEl) {        
        newEl.setNamespace(root.getNamespace());
        el.addContent(newEl);
    }

    /**
     * adiciona elemento contendo a raiz como namespace
     * devido o elemento raiz contem o namespace, eh necessario passar o objeto para os elementos-filhos
     * @param index posicao do elemento na arvore
     * @param el elemento-filho ascendente
     * @param newEl novo elemento-filho
     */
    public void adicElFilho(int index, Element el, Element newEl) {        
        newEl.setNamespace(root.getNamespace());
        el.addContent(index, newEl);
    }

    /**
     * obtem o elemento-filho caso o root tenha namespace
     *
     * @param cname nome qualificado do elemento
     * @param e elemento-filho ascendente
     * @return devolve o elemento-filho descedente
     */
    public Element getElFilho(String cname, Element e) {
        return e.getChild(cname, root.getNamespace());
    }

    public void imprimirNoConsole() throws IOException {
        XMLOutputter outputter = new XMLOutputter();
        outputter.output(document, System.out);
    }

    public void escreverNoArq(File file) throws IOException {
        XMLOutputter outputter = new XMLOutputter();
        outputter.output(document, new FileWriter(file));
    }
}
