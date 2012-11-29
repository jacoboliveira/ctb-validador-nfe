/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.entities;

/**
 *
 * @author yaaqovtatas777
 */
public class InfoArq {

    protected String nomeArquivo;
    protected String caminhoAbsoluto;

    public InfoArq() {
    }

    public InfoArq(String nomeArquivo, String caminhoAbsoluto) {
        this.nomeArquivo = nomeArquivo;
        this.caminhoAbsoluto = caminhoAbsoluto;
    }

    /**
     * @return the nomeArquivo
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * @param nomeArquivo the nomeArquivo to set
     */
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    /**
     * @return the caminhoAbsoluto
     */
    public String getCaminhoAbsoluto() {
        return caminhoAbsoluto;
    }

    /**
     * @param caminhoAbsoluto the caminhoAbsoluto to set
     */
    public void setCaminhoAbsoluto(String caminhoAbsoluto) {
        this.caminhoAbsoluto = caminhoAbsoluto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InfoArq other = (InfoArq) obj;
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
        int hash = 3;
        hash = 89 * hash + (this.nomeArquivo != null ? this.nomeArquivo.hashCode() : 0);
        hash = 89 * hash + (this.caminhoAbsoluto != null ? this.caminhoAbsoluto.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return nomeArquivo;
    }


}
