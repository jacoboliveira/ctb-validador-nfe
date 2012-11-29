/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ctb.validador.nfe.util;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

/**
 *
 * @author jacoboliveira
 */
public class AbstractFrame extends javax.swing.JFrame{
    protected LogSis logSis;
    
    public AbstractFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }

    public AbstractFrame(String title) throws HeadlessException {
        super(title);
    }

    public AbstractFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public AbstractFrame() throws HeadlessException {
        super();
        logSis = new LogSis();
    }
}
