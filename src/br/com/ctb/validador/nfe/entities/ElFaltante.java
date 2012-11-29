/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ctb.validador.nfe.entities;

/**
 *
 * @author yaaqovtatas777
 */
public class ElFaltante {
    //nome da tag
    private String nomeElemento;
    //posicao correta do elemento na arvore de elementos,de acordo com o mapeamento arq. properties
    private int posicaoElemento;

    // eh o caminho exato, onde se encontra o elemento-faltante
    private String caminhoAPercorrer;
    /**
     * @return the nomeElemento
     */
    public String getNomeElemento() {
        return nomeElemento;
    }

    /**
     * @param nomeElemento the nomeElemento to set
     */
    public void setNomeElemento(String nomeElemento) {
        this.nomeElemento = nomeElemento;
    }

    /**
     * @return the posicaoElemento
     */
    public int getPosicaoElemento() {
        return posicaoElemento;
    }

    /**
     * @param posicaoElemento the posicaoElemento to set
     */
    public void setPosicaoElemento(int posicaoElemento) {
        this.posicaoElemento = posicaoElemento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ElFaltante other = (ElFaltante) obj;
        if ((this.nomeElemento == null) ? (other.nomeElemento != null) : !this.nomeElemento.equals(other.nomeElemento)) {
            return false;
        }
        if (this.posicaoElemento != other.posicaoElemento) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.nomeElemento != null ? this.nomeElemento.hashCode() : 0);
        hash = 67 * hash + this.posicaoElemento;
        return hash;
    }

    /**
     * @return the caminhoAPercorrer
     */
    public String getCaminhoAPercorrer() {
        return caminhoAPercorrer;
    }

    /**
     * @param caminhoAPercorrer the caminhoAPercorrer to set
     */
    public void setCaminhoAPercorrer(String caminhoAPercorrer) {
        this.caminhoAPercorrer = caminhoAPercorrer;
    }


}
