/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.entities;

import java.util.List;

/**
 *
 * @author yaaqovtatas777
 */
public class InfoErros extends InfoArq {

    private List<ElFaltante> elFaltantes;

    public InfoErros() {
    }

    /**
     * @return the elFaltantes
     */
    public List<ElFaltante> getElFaltantes() {
        return elFaltantes;
    }

    /**
     * @param elFaltantes the elFaltantes to set
     */
    public void setElFaltantes(List<ElFaltante> elFaltantes) {
        this.elFaltantes = elFaltantes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InfoErros other = (InfoErros) obj;
        if (this.elFaltantes != other.elFaltantes && (this.elFaltantes == null || !this.elFaltantes.equals(other.elFaltantes))) {
            return false;
        }

        if ((this.nomeArquivo == null) ? (other.nomeArquivo != null) : !this.nomeArquivo.equals(other.nomeArquivo)) {
            return false;
        }

        if ((this.caminhoAbsoluto == null) ? (other.caminhoAbsoluto != null) : !this.caminhoAbsoluto.equals(other.caminhoAbsoluto)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.elFaltantes != null ? this.elFaltantes.hashCode() : 0);
        return hash;
    }

    
}
