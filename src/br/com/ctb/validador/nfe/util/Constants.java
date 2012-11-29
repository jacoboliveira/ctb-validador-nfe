/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

/**
 *
 * @author jacob_lisboa
 */
public interface Constants {

    public static final String PATH_DEFAULT = "/br/com/ctb/validador/nfe";
    public static final String PATH_IMAGES = PATH_DEFAULT+"/imagens/";
    
    //chaves do arquivos properties 'recurso_config.properties'
    //composicao dos nomes das variaveis = PROP + iniciais do nome da tela + algumas letras do comp + o que vai alterar
    public static final String PROP_PF_LOC_FIELD="principalFrame.localizarArqXmlPanel.field.texto";
    public static final String PROP_PF_ARQ_ITENS="principalFrame.arquivosXmlList.itens";
    public static final String PROP_PF_CAM_CORRECAO_FIELD="principalFrame.caminhoDeCorrecaoPanel.field.texto";
    public static final String PROP_PF_MARCAR_CHECK="principalFrame.marcaIdemCamValidCBox.check";
    public static final String PROP_CSD_SALVAR_CHECK="configSisDialog.salvarAltCBox.check";
    public static final String PATH_RECURSO_CONFIG="recurso_config.properties";
}
