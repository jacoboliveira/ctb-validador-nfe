/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

/**
 *
 * @author jacoboliveira
 */
public class AbstractDialog extends javax.swing.JDialog {

    protected LogSis logSis;

    public AbstractDialog() {
        super();
        logSis = new LogSis();
    }

    public AbstractDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, title, modalityType, gc);
    }

    public AbstractDialog(Window owner, String title, ModalityType modalityType) {
        super(owner, title, modalityType);
    }

    public AbstractDialog(Window owner, String title) {
        super(owner, title);
    }

    public AbstractDialog(Window owner, ModalityType modalityType) {
        super(owner, modalityType);
    }

    public AbstractDialog(Window owner) {
        super(owner);
    }

    public AbstractDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
    }

    public AbstractDialog(Dialog owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public AbstractDialog(Dialog owner, String title) {
        super(owner, title);
    }

    public AbstractDialog(Dialog owner, boolean modal) {
        super(owner, modal);
    }

    public AbstractDialog(Dialog owner) {
        super(owner);
    }

    public AbstractDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
        super(owner, title, modal, gc);
    }

    public AbstractDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
    }

    public AbstractDialog(Frame owner, String title) {
        super(owner, title);
    }

    public AbstractDialog(Frame owner, boolean modal) {
        super(owner, modal);
        logSis = new LogSis();
    }

    public AbstractDialog(Frame owner) {
        super(owner);
    }
}
