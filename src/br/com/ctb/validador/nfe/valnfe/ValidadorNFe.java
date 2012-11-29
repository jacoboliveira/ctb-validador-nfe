/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.valnfe;

import br.com.ctb.validador.nfe.entities.ElFaltante;
import br.com.ctb.validador.nfe.entities.InfoErros;
import br.com.ctb.validador.nfe.tablemodel.InfoErrosTableModel;
import br.com.ctb.validador.nfe.util.CollectionsUtils;
import br.com.ctb.validador.nfe.util.FileHelper;
import br.com.ctb.validador.nfe.util.JDomUtil;
import br.com.ctb.validador.nfe.util.LogSis;
import br.com.ctb.validador.nfe.util.ResourceBundleUtil;
import br.com.ctb.validador.nfe.util.SO;
import br.com.ctb.validador.nfe.util.StringHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author yaaqovtatas777
 */
public class ValidadorNFe {

    ResourceBundleUtil elsPadraoResource;
    ResourceBundleUtil mapNFeResource;
    PropertyResourceBundle elsPadraoProp;
    PropertyResourceBundle mapNFeProp;
    List<InfoErros> infoErrosList;
    private File nfeXml;

    public ValidadorNFe() throws IOException {
        //FileHelper.getPath2("/elementos-padrao.properties")
        //FileHelper.getPath2("/mapeamento-nfe.properties")
        String appPath =FileHelper.getLocationAppPath();
        System.out.println(appPath);
        this.elsPadraoResource = new ResourceBundleUtil(appPath+SO.getSepArqSO()+"elementos-padrao.properties");
        this.mapNFeResource = new ResourceBundleUtil(appPath+SO.getSepArqSO()+"mapeamento-nfe.properties");

        this.elsPadraoProp = elsPadraoResource.getPropertyResourceBundle();
        this.mapNFeProp = mapNFeResource.getPropertyResourceBundle();

    }

    public void setNfeXml(File nfeXml) {
        this.nfeXml = nfeXml;
    }

    public void setInfoErrosList(List<InfoErros> infoErrosList) {
        this.infoErrosList = infoErrosList;
    }

    public List<InfoErros> getInfoErrosList() {
        return infoErrosList;
    }

    private Document getCarregarDocNFe() throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        return builder.build(nfeXml);
    }

    /**
     *
     * @throws JDOMException erro de sintaxe do arquivo xml
     * @throws IOException erro de I/O durante a nalise do arquivo xml
     * @throws NullPointerException caso nao for encontrado o elemento-filho do mapeamento do arquivo properties
     */
    public void analisarArqNFe() throws JDOMException, IOException, NullPointerException {

        try {
            Document doc = getCarregarDocNFe();
            Set<String> mapNFeKeys = mapNFeProp.keySet();
            boolean checarError = false;
            InfoErros infoErros = new InfoErros();
            infoErros.setCaminhoAbsoluto(StringHelper.substringBeforeLast(nfeXml.getPath(), SO.getSepArqSO()));
            infoErros.setNomeArquivo(nfeXml.getName());

            List<ElFaltante> elFaltantes = new ArrayList<ElFaltante>();
            //1-verificando se ha algum elemento-filho faltante
            //percorrendo mapeamento do arquivo NFe
            for (String mapNFeKey : mapNFeKeys) {
                //encontra o elemento-filho
                Element elFilho = encontrarElFilho(doc, mapNFeKey);
                if (elFilho == null) {
                    String l = "mapeamento inválido: " + mapNFeKey + " do arquivo: " + infoErros.getCaminhoAbsoluto() + SO.getSepArqSO() + infoErros.getNomeArquivo();
                    Logger.getLogger(ValidadorNFe.class.getName()).log(Level.SEVERE, l);
                    continue;
                }
                //obtendo os elementos-obrigatorios do documento
                List<Element> filhos = elFilho.getChildren();

                //obtem o array de string dos elementos-obrigatorios para verificacao
                String caminhoAPercorrer = mapNFeKey;
                String[] elsObrig = StringHelper.split(mapNFeProp.getString(mapNFeKey), '|');

                //percorrendo o elementos-obrigatorios
                for (String elObrig : elsObrig) {
                    //checando se o elemento-filho esta faltando,caso
                    //esteja eh adicionado em um ArrayList de erros.
                    boolean isContemEl = false;
                    for (Element filho : filhos) {
                        if (!filho.getQualifiedName().equalsIgnoreCase(elObrig)) {
                            isContemEl = false;
                            continue;
                        } else {
                            isContemEl = true;
                            break;
                        }
                    }
                    if (!isContemEl) {
                        //adiciona o nome elemento-filho faltante em um arraylist de erros
                        ElFaltante elFaltante = new ElFaltante();
                        elFaltante.setNomeElemento(elObrig);
                        //registrando exato que vai ser corrigo posteriorimente
                        elFaltante.setCaminhoAPercorrer(caminhoAPercorrer);
                        //registra a posicao do elemento da arvore de elementos, para poder colocar na posicao correta o elemento faltante
                        elFaltante.setPosicaoElemento(getPosEl(elsObrig, elObrig));

                        elFaltantes.add(elFaltante);
                        checarError = true;
                    }

                }// fim percorrer els obrig.
            }//fim analise

            //ao termino da analise registra os erros do arquivo
            //a variavel booleana checa se tem algum erro,caso haja registra na Lista de Erros
            if (checarError) {
                infoErros.setElFaltantes(elFaltantes);
                infoErrosList.add(infoErros);
            }
        } catch (JDOMException ex) {
            throw new JDOMException("Ocorreu um erro de analise do xml.Verificar o xml,validando o mesmo se há algum erro de tag!", ex);
        } catch (IOException ex) {
            throw new IOException("Ocorreu um erro de comunicação com arquivo xml.Verificar se há algum impedimento ou repita a operação!", ex);
        } catch (NullPointerException ex) {
            throw new NullPointerException(ex.getMessage());
        }
    }

    /**
     * 
     * @param isIdemCamValidacao
     * @param caminhoDif
     * @throws JDOMException
     * @throws IOException
     */
    public void corrigirErrosDocNFe(boolean isIdemCamValidacao, File caminhoDif, InfoErrosTableModel infoErrosTableModel) throws JDOMException, IOException {

        //crio um clone da lista erros para que ela se mantenha com as mesma configurações
        List<InfoErros> clone = CollectionsUtils.clone(infoErrosList, new ArrayList<InfoErros>());

        //verifico se o usuario escolheu um caminho diferente,
        //se ele escolheu, entao eu faço uma varredura no objeto clone
        //copiando os arquivo, para o caminho especificado,
        //alterando o caminho absoluto, para o caminho escolhido
        if (!isIdemCamValidacao) {
            for (InfoErros infoErros : clone) {
                String caminhoDifStr = caminhoDif.getPath();
                FileHelper.copyFile(
                        new File(infoErros.getCaminhoAbsoluto() + SO.getSepArqSO() + infoErros.getNomeArquivo()),
                        new File(caminhoDifStr + SO.getSepArqSO() + infoErros.getNomeArquivo()));
                infoErros.setCaminhoAbsoluto(caminhoDifStr);
            }
        }

        //verifico se ele marcou com o mesmo caminho da validação, caso sim assumo a lista
        //normal de validação,caso contrario assumo o clone com o caminho especificado
        List<InfoErros> listaAPercorrer = isIdemCamValidacao ? infoErrosList : clone;
        synchronized (listaAPercorrer) {
            //realizo a correção dos arquivos xml's
            for (InfoErros infoErros : listaAPercorrer) {
                SAXBuilder builder = new SAXBuilder();
                File caminhoXml = new File(infoErros.getCaminhoAbsoluto() + SO.getSepArqSO() + infoErros.getNomeArquivo());
                Document doc = builder.build(caminhoXml);
                JDomUtil dUtil = new JDomUtil(doc, doc.getRootElement());
                List<ElFaltante> elFaltantes = infoErros.getElFaltantes();
                for (ElFaltante elFaltante : elFaltantes) {
                    Element elAscendent = encontrarElFilho(doc, elFaltante.getCaminhoAPercorrer());

                    dUtil.adicElFilho(elAscendent,
                            new Element(elFaltante.getNomeElemento()));
                    //TODO implementar: correcao de posicao dos elementos-filhos
                }
                //escrevo as alteracoes feitas no documento, no caminho escolhido pelo usuario
                dUtil.escreverNoArq(caminhoXml);
                //dUtil.imprimirNoConsole();
                //remover linha da tabela e do model
                synchronized (infoErrosList) {
                    if (infoErrosTableModel != null) {
                        infoErrosTableModel.removerLinha(listaAPercorrer.indexOf(infoErros));
                    }
                }

            }
        }
    }

    private Element encontrarElFilho(Document doc, String mapNFeKey) throws NullPointerException {
        Element raiz = doc.getRootElement();
        JDomUtil dUtil = new JDomUtil(doc, raiz);

        //arvore de elementos-pseudonimo a percorrer
        String[] arvoreEls = StringHelper.split(mapNFeKey, '.');
        //varrendo os elementos ate encontrar o elemento-filho
        int proxEl = 0;
        Element ultEl = null;
        List<Element> e = new ArrayList<Element>();
        boolean b = true;
        for (String elArvore : arvoreEls) {
            if (b) {
                e.add(raiz);
                b = false;
                continue;
            }
            String r = getRealNomeKey(elArvore);
            ultEl = dUtil.getElFilho(r, e.get(proxEl++));
            if (ultEl == null) {
                break;
            }
            e.add(ultEl);
        }


        return ultEl;
    }

    /**
     *
     * obtendo o nome correto do elemento no map-properties
     *
     * @param elArvore pseudonimo do elemento real.
     * @return nome real do elemento que esta no xml
     */
    private String getRealNomeKey(String elArvore) {
        Set<String> elsPadraoKeys = elsPadraoProp.keySet();
        for (String key : elsPadraoKeys) {
            if (key.equalsIgnoreCase(elArvore)) {
                return elsPadraoProp.getString(elArvore);
            }
        }
        return null;
    }

    private int getPosEl(String[] elsObrig, String elObrig) {
        List<String> a = Arrays.asList(elsObrig);
        return a.indexOf(elObrig);
    }
}
