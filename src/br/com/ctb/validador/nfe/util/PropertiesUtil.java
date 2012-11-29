/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author jacoboliveira
 */
public class PropertiesUtil implements Constants {

    private final String MSG_ARQ_NAO_ENCONT = "Ocorreu um erro durante a leitura do arquivo,verificar as seguintes situações:\n"
            + "\t1- O arquivo especificado não encontrado;\n"
            + "\t2- O caminho do arquivo especificado inválido;\n"
            + "\t3- Permissão de acesso do arquivo negado.\n\n";
    private Map<String, Object> pesquisa;
    private Properties properties;

    public PropertiesUtil() {
    }

    /**
     *
     * @param caminhoArq 
     * @throws FileNotFoundException
     * @throws IOException caso haja algum erro de comunicação I/O com arquivo properties
     * @throws NullPointerException caso o objeto Output stream for nulo, ou se o objeto caminhoArq for nulo.
     * @throws ClassCastException caso as chaves do objeto properties forem diferente de strings
     */
    public void escreverArqProps(Properties props, String caminhoArq) throws FileNotFoundException, IOException, NullPointerException, ClassCastException {

        if (caminhoArq == null) {
            throw new NullPointerException("o caminho do arquivo esta nulo");
        }
        if (props == null) {
            throw new NullPointerException("objeto 'props' nulo!");
        }
        //FileHelper.getPath2(caminhoArq)
        escreverArqProps(props, new File(caminhoArq));
    }

    /**
     * 
     * @param props passar a instacia do objeto properties com as propriedades
     * @throws FileNotFoundException arquivo não encontrado,acesso negado,caminho inválido.
     * @throws IOException caso haja algum erro de comunicação I/O com arquivo properties
     * @throws NullPointerException caso o objeto Output stream for nulo
     * @throws ClassCastException caso as chaves do objeto properties forem diferente de strings
     */
    public void escreverArqProps(Properties props, File caminhoArq) throws FileNotFoundException, IOException, NullPointerException, ClassCastException {
        //TODO substituir nas classes que usam ResourceBundleUtil
        if (caminhoArq == null) {
            throw new NullPointerException("Objeto File esta nulo!");
        }
        if (!caminhoArq.exists()) {
            throw new FileNotFoundException(MSG_ARQ_NAO_ENCONT);
        }
        FileOutputStream fos = new FileOutputStream(caminhoArq);

        try {
            props.store(fos, "Configurações do Sistema");
        } catch (IOException ex) {
            if (ex instanceof FileNotFoundException) {
                throw new FileNotFoundException(MSG_ARQ_NAO_ENCONT);
            } else {
                throw new IOException("Ocorreu um erro ao tentar salvar as alterações feitas na tela, \n pode ser erro de comunicação com o arquivo!Tente novamente!", ex);
            }
        } catch (NullPointerException ex) {
            throw new NullPointerException("Objeto Output Stream esta nulo! Verificar caminho do arquivo properties!");
        } catch (ClassCastException ex) {
            throw new ClassCastException(" as chaves do objeto propertie não são strings!");
        } finally {
            if (fos != null) {
                fos.flush();
                fos.close();
            }
        }


    }

    public void lerArqProps(String caminhoArq) throws FileNotFoundException, NullPointerException, IOException {
        if (caminhoArq == null) {
            throw new NullPointerException("o caminho do arquivo esta nulo!");
        }
        //FileHelper.getPath2(caminhoArq)
        lerArqProps(new File(caminhoArq));
    }

    /**
     * 
     * @param props passar a instacia do objeto properties com as propriedades
     * @throws FileNotFoundException arquivo não encontrado,acesso negado,caminho inválido.
     * @throws NullPointerException caso o objeto Output stream for nulo
     * @throws IOException caso haja algum erro leitura do arquivo.
     */
    public void lerArqProps(File caminhoArq) throws FileNotFoundException, NullPointerException, IOException {
        if (caminhoArq == null) {
            throw new NullPointerException("Objeto File esta nulo!");
        }
        if (!caminhoArq.exists()) {
            throw new FileNotFoundException(MSG_ARQ_NAO_ENCONT);
        }
        FileInputStream fis = new FileInputStream(caminhoArq);
        Properties props = new Properties();
        try {
            props.load(fis);
            this.properties = props;
            pesquisa = new HashMap(props);
        } catch (IOException ex) {
            throw new IOException("Houve um erro de leitura do arquivo! Verificar se o mesmo possui acesso.", ex);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Caracteres Unicode presentes no arquivo inválidos!", ex);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

    }

    /**
     * nota: execute primeiro o metodo : lerArqProps(File caminhoArq);
     * @return o objeto properties apos leitura do mesmo.
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * serve de navegação p/ os valores/chaves do properties, apos a leitura do mesmo
     * nota: execute primeiro o metodo : lerArqProps(File caminhoArq);
     * @return objeto Map contendo as propriedades do arquivo properties
     */
    public Map<String, Object> getPesquisa() {
        return pesquisa;
    }

    /**
     *  retorna o valor do objeto que esta no Map
     * @param key
     * @return retorna o valor do objeto que esta no Map
     */
    public String getString(String key) {
        return (String) pesquisa.get(key);
    }
}
