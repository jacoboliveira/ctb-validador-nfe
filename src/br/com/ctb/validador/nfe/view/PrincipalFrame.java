/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on 22/11/2012, 22:48:05
 */
package br.com.ctb.validador.nfe.view;

import br.com.ctb.validador.nfe.entities.ElFaltante;
import br.com.ctb.validador.nfe.entities.InfoArq;
import br.com.ctb.validador.nfe.entities.InfoErros;
import br.com.ctb.validador.nfe.tablemodel.InfoErrosTableModel;
import br.com.ctb.validador.nfe.util.AbstractFrame;
import br.com.ctb.validador.nfe.util.CollectionsUtils;
import br.com.ctb.validador.nfe.util.Constants;
import br.com.ctb.validador.nfe.util.FileHelper;
import br.com.ctb.validador.nfe.util.JMessageUtil;
import br.com.ctb.validador.nfe.util.PropertiesUtil;
import br.com.ctb.validador.nfe.util.SO;
import br.com.ctb.validador.nfe.util.StringHelper;
import br.com.ctb.validador.nfe.valnfe.ValidadorNFe;
import br.com.swing.componentes.personalizados.ui.LocalizarCampoPanelExtend;
import br.com.swing.componentes.personalizados.util.JFileChooserUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.netbeans.jemmy.operators.JTableOperator;

/**
 *
 * @author yaaqovtatas777
 */
public class PrincipalFrame extends AbstractFrame implements Constants {

    private List<InfoErros> infoErrosList;
    private InfoErrosTableModel infoErrosTableModel;
    private JTableOperator infoErrosTOperator;
    private PropertiesUtil propsUtil;
    static String appPath = FileHelper.getLocationAppPath();

    /** Creates new form MainFrame */
    public PrincipalFrame() {
        super();
        initComponents();
        appPath += SO.getSepArqSO() + PATH_RECURSO_CONFIG;
        infoErrosList = new CopyOnWriteArrayList<InfoErros>();
        infoErrosTOperator = new JTableOperator(infoErrosTable);
        infoErrosTableModel = new InfoErrosTableModel();
        propsUtil = new PropertiesUtil();
        localizarArqXmlPanel.setDefaultListModel(arquivosXmlList.getListModel());
        infoErrosTableModel.setList(new ArrayList<InfoErros>());
        infoErrosTable.setModel(infoErrosTableModel);
        caminhoDeCorrecaoPanel.getField().setEditable(false);
        caminhoDeCorrecaoPanel.setTipoFileChoorser(LocalizarCampoPanelExtend.ONE_FILE);
        caminhoDeCorrecaoPanel.setTipoArquivos(JFileChooserUtil.SOMENTE_DIRETORIOS);

        limparTelaMItem.setVisible(false);

        //modificando a coluna 'Tags que faltam'
        TableColumn tableColumn = infoErrosTable.getColumn(2);
        tableColumn.setCellRenderer(new TableCellRenderer() {

            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                //TODO ajusta a deteccao do tipo generic da lista
                if (value instanceof ArrayList) {
                    List<ElFaltante> els = (List<ElFaltante>) value;
                    StringBuilder s = new StringBuilder();
                    for (ElFaltante elFaltante : els) {
                        s.append("<").append(elFaltante.getNomeElemento()).append(">").append(",");
                    }
                    return renderer.getTableCellRendererComponent(table, StringHelper.removeEnd(s.toString(), ","), isSelected, hasFocus, row, column);
                }
                return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            }
        });

        arquivosXmlList.setCellRenderer(new ListCellRenderer() {

            DefaultListCellRenderer renderer = new DefaultListCellRenderer();

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof InfoArq) {
                    InfoArq infoArq = (InfoArq) value;
                    return renderer.getListCellRendererComponent(list, infoArq.getNomeArquivo(), index, isSelected, cellHasFocus);
                } else {
                    return renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        centroPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        localizarArqXmlPanel = new br.com.ctb.validador.nfe.comp.ui.LocalizarCampoPanelExtend();
        jPanel3 = new javax.swing.JPanel();
        caminhoDeCorrecaoPanel = new br.com.swing.componentes.personalizados.ui.LocalizarCampoPanelExtend();
        marcaIdemCamValidCBox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoErrosTable = new org.jdesktop.swingx.JXTable();
        jPanel4 = new javax.swing.JPanel();
        removerItensListButton = new javax.swing.JButton();
        arquivosXmlList = new br.com.swing.componentes.personalizados.ui.ListaComFiltroTest();
        jPanel5 = new javax.swing.JPanel();
        corrigirButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        msg1Label = new javax.swing.JLabel();
        analisarButton = new javax.swing.JButton();
        statusBar = new org.jdesktop.swingx.JXStatusBar();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        sisMenu = new javax.swing.JMenu();
        limparTelaMItem = new javax.swing.JMenuItem();
        sairMItem = new javax.swing.JMenuItem();
        configSisMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validador NF-e (Nota Fiscal Eletrônica)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        localizarArqXmlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Passo 1:"));
        localizarArqXmlPanel.setToolTipText("Localize e selecione aqui, o(s) arquivo(s) NF-e p/ validar"); // NOI18N
        localizarArqXmlPanel.setAlterarDimensaoLabel(new java.awt.Dimension(350, 14));
        localizarArqXmlPanel.setLabelText("Localize e selecione aqui o(s) arquivo(s): "); // NOI18N
        localizarArqXmlPanel.setPreferredSize(new java.awt.Dimension(200, 47));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Passo 3:"));

        caminhoDeCorrecaoPanel.setAlterarDimensaoLabel(new java.awt.Dimension(300, 14));
        caminhoDeCorrecaoPanel.setLabelText("Localize ou marque ao lado o caminho para correção:");

        marcaIdemCamValidCBox.setFont(new java.awt.Font("Tahoma", 0, 10));
        marcaIdemCamValidCBox.setText("O mesmo caminho da Validação");
        marcaIdemCamValidCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaIdemCamValidCBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(caminhoDeCorrecaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(marcaIdemCamValidCBox))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(caminhoDeCorrecaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(marcaIdemCamValidCBox))
        );

        infoErrosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(infoErrosTable);

        jPanel4.setLayout(new java.awt.BorderLayout());

        removerItensListButton.setText("Remover Lista");
        removerItensListButton.setPreferredSize(new java.awt.Dimension(100, 23));
        removerItensListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerItensListButtonActionPerformed(evt);
            }
        });
        jPanel4.add(removerItensListButton, java.awt.BorderLayout.SOUTH);

        arquivosXmlList.setLabelText("Filtrar:");
        jPanel4.add(arquivosXmlList, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Passo 4, clique no botão corrigir, abaixo:"));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        corrigirButton.setText("Corrigir");
        corrigirButton.setToolTipText("efetua a correção dos arquivos"); // NOI18N
        corrigirButton.setEnabled(false);
        corrigirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corrigirButtonActionPerformed(evt);
            }
        });
        jPanel5.add(corrigirButton);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Passo 2, clique em analisar:"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        jPanel1.add(msg1Label);

        analisarButton.setText("Analisar");
        analisarButton.setToolTipText("clique em analisar p/ verificar os erros presente nos arquivos"); // NOI18N
        analisarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analisarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(analisarButton);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                        .addComponent(localizarArqXmlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(localizarArqXmlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout centroPanelLayout = new javax.swing.GroupLayout(centroPanel);
        centroPanel.setLayout(centroPanelLayout);
        centroPanelLayout.setHorizontalGroup(
            centroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centroPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        centroPanelLayout.setVerticalGroup(
            centroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(centroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(centroPanel, java.awt.BorderLayout.CENTER);

        jLabel1.setText(" ");
        statusBar.add(jLabel1);

        getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);

        sisMenu.setMnemonic('s');
        sisMenu.setText("Sistema");

        limparTelaMItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        limparTelaMItem.setMnemonic('l');
        limparTelaMItem.setText("Limpar Tela");
        sisMenu.add(limparTelaMItem);

        sairMItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        sairMItem.setMnemonic('a');
        sairMItem.setText("Sair");
        sairMItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairMItemActionPerformed(evt);
            }
        });
        sisMenu.add(sairMItem);

        menuBar.add(sisMenu);

        configSisMenu.setMnemonic('c');
        configSisMenu.setText("Configurações");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('i');
        jMenuItem1.setText("Config. do Sistema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        configSisMenu.add(jMenuItem1);

        menuBar.add(configSisMenu);

        setJMenuBar(menuBar);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-649)/2, (screenSize.height-686)/2, 649, 686);
    }// </editor-fold>//GEN-END:initComponents

    private void removerItensListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerItensListButtonActionPerformed

        arquivosXmlList.removeAllItens();

    }//GEN-LAST:event_removerItensListButtonActionPerformed

    private void analisarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisarButtonActionPerformed

        //limpo os erros para re-analise
        infoErrosList.clear();
        
        Object[] a = arquivosXmlList.getListModel().toArray();
        List<InfoArq> infoArqs = CollectionsUtils.transformArrayObjToListBean(a, InfoArq[].class);

        corrigirButton.setEnabled(false);
        boolean isHouveErros = false;
        for (InfoArq infoArq : infoArqs) {
            try {
                ValidadorNFe analisarNFe = new ValidadorNFe();
                analisarNFe.setNfeXml(new File(infoArq.getCaminhoAbsoluto() + SO.getSepArqSO() + infoArq.getNomeArquivo()));
                analisarNFe.setInfoErrosList(infoErrosList);
                analisarNFe.analisarArqNFe();
            } catch (Exception ex) {
                JMessageUtil.showWarningMessage(this, ex.getMessage());
                isHouveErros = true;
                this.logSis.erro(ex.getMessage(), ex);
                break;
            }
        }

        if (!isHouveErros && !CollectionsUtils.isEmpty(infoErrosList)) {
            infoErrosTableModel.setList(infoErrosList);
            corrigirButton.setEnabled(true);
            msg1Label.setText("Encontrado(s) " + infoErrosList.size() + " arquivo(s) p/ correção!");
            msg1Label.setFont(new Font("Tahoma", Font.PLAIN, 12));
            msg1Label.setForeground(Color.red);
        } else if (!isHouveErros) {
            msg1Label.setText("Nenhum dos arquivos contem erros!");
            msg1Label.setForeground(new Color(51, 153, 0));
            msg1Label.setFont(new Font("Tahoma", Font.BOLD, 12));
            //TODO o metodo removerTodos() nao esta removendo a linha da tabela
            infoErrosTableModel.removerTodos();
        }

    }//GEN-LAST:event_analisarButtonActionPerformed

    private void corrigirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corrigirButtonActionPerformed
        
        try {
            ValidadorNFe corrigirNFe = new ValidadorNFe();
            corrigirNFe.setInfoErrosList(infoErrosList);
            corrigirNFe.corrigirErrosDocNFe(marcaIdemCamValidCBox.isSelected(), new File(caminhoDeCorrecaoPanel.getField().getText()), infoErrosTableModel);
            corrigirButton.setEnabled(false);
            JMessageUtil.showSucessMessage(this, "Arquivo(s) corrigido(s) com sucesso!");
        } catch (Exception ex) {
            JMessageUtil.showWarningMessage(this, ex.getMessage());
            this.logSis.erro(ex.getMessage(), ex);
        }
        
    }//GEN-LAST:event_corrigirButtonActionPerformed

    private void marcaIdemCamValidCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaIdemCamValidCBoxActionPerformed
        if (localizarArqXmlPanel.isEmptyField()) {
            marcaIdemCamValidCBox.setSelected(false);
            JMessageUtil.showWarningMessage(this, "Por Favor, localize primeiro o caminho de valição acima!");
            return;
        }
        caminhoDeCorrecaoPanel.getBotaoLocalizar().setEnabled(!marcaIdemCamValidCBox.isSelected());
        caminhoDeCorrecaoPanel.getField().setText(
                marcaIdemCamValidCBox.isSelected()
                ? localizarArqXmlPanel.getField().getText() : "");

    }//GEN-LAST:event_marcaIdemCamValidCBoxActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            //SO.getSepArqSO() + PATH_RECURSO_CONFIG
            propsUtil.lerArqProps(appPath);

            //verifico se o usuario marcou a opção para salvar as alterções do sistema
            boolean isSalvarAltSis = Boolean.parseBoolean(propsUtil.getString(PROP_CSD_SALVAR_CHECK));
            if (isSalvarAltSis) {
                Logger.getLogger(ConfigSisDialog.class.getName()).log(Level.INFO, "carregando info. do sistema...");
                //se sim obtenho as alteracoes e seto nos componentes
                localizarArqXmlPanel.getField().setText(propsUtil.getString(PROP_PF_LOC_FIELD));
                String p = propsUtil.getString(PROP_PF_ARQ_ITENS);
                if (StringHelper.isNotBlank(p)) {
                    if (p.indexOf("|") != -1) {
                        String[] propPfArqItens = StringHelper.split(p, "|");
                        for (String item : propPfArqItens) {
                            String nomeArquivo = StringHelper.substringAfterLast(item, SO.getSepArqSO());
                            String caminhoArq = StringHelper.substringBeforeLast(item, SO.getSepArqSO());
                            arquivosXmlList.getListModel().addElement(new InfoArq(nomeArquivo, caminhoArq));
                        }
                    } else {
                        String nomeArquivo = StringHelper.substringAfterLast(p, SO.getSepArqSO());
                        String caminhoArq = StringHelper.substringBeforeLast(p, SO.getSepArqSO());
                        arquivosXmlList.getListModel().addElement(new InfoArq(nomeArquivo, caminhoArq));
                    }
                }
                caminhoDeCorrecaoPanel.getField().setText(propsUtil.getString(PROP_PF_CAM_CORRECAO_FIELD));
                marcaIdemCamValidCBox.setSelected(Boolean.parseBoolean(propsUtil.getString(PROP_PF_MARCAR_CHECK)));

            }

        } catch (Exception ex) {
            JMessageUtil.showWarningMessage(this, ex.getMessage());
            this.logSis.erro(ex.getMessage(), ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConfigSisDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });



    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO implementar: realizar uma futura impl. para salvar quando o usuario digitar em cada componente, ao inves de só quando ele fechar
        try {
            //SO.getSepArqSO() + PATH_RECURSO_CONFIG
            propsUtil.lerArqProps(appPath);
            //verifico se o usuario marcou a opção para salvar as alterções do sistema
            boolean isSalvarAltSis = Boolean.parseBoolean(propsUtil.getString(PROP_CSD_SALVAR_CHECK));
            if (isSalvarAltSis) {
                Logger.getLogger(ConfigSisDialog.class.getName()).log(Level.INFO, "Salvando alterações do sistema...");
                Properties props = propsUtil.getProperties();

                //transformo a lista array em uma lista de beans
                Object[] a = arquivosXmlList.getListModel().toArray();
                List<InfoArq> infoArqs = CollectionsUtils.transformArrayObjToListBean(a, InfoArq[].class);

                //realizo a concatenação do path completo do arquivo
                StringBuilder concatCaminhosArq = new StringBuilder();
                for (InfoArq infoArq : infoArqs) {
                    concatCaminhosArq.append(infoArq.getCaminhoAbsoluto()).append(SO.getSepArqSO()).append(infoArq.getNomeArquivo()).append("|");
                }
                //retiro o ultimo pipe e armazeno no properties
                props.setProperty(PROP_PF_ARQ_ITENS, StringHelper.removeEnd(concatCaminhosArq.toString(), "|"));
                props.setProperty(PROP_PF_CAM_CORRECAO_FIELD, caminhoDeCorrecaoPanel.getField().getText());
                props.setProperty(PROP_PF_LOC_FIELD, localizarArqXmlPanel.getField().getText());
                props.setProperty(PROP_PF_MARCAR_CHECK, String.valueOf(marcaIdemCamValidCBox.isSelected()));

                //escrevo as alterações feitas no objeto properties e as escrevo no arquivo properties
                propsUtil.escreverArqProps(props, PATH_RECURSO_CONFIG);
            }
        } catch (Exception ex) {
            JMessageUtil.showWarningMessage(this, ex.getMessage());
            this.logSis.erro(ex.getMessage(), ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void sairMItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairMItemActionPerformed

        System.exit(0);

    }//GEN-LAST:event_sairMItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analisarButton;
    private br.com.swing.componentes.personalizados.ui.ListaComFiltroTest arquivosXmlList;
    private br.com.swing.componentes.personalizados.ui.LocalizarCampoPanelExtend caminhoDeCorrecaoPanel;
    private javax.swing.JPanel centroPanel;
    private javax.swing.JMenu configSisMenu;
    private javax.swing.JButton corrigirButton;
    private org.jdesktop.swingx.JXTable infoErrosTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem limparTelaMItem;
    private br.com.ctb.validador.nfe.comp.ui.LocalizarCampoPanelExtend localizarArqXmlPanel;
    private javax.swing.JCheckBox marcaIdemCamValidCBox;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel msg1Label;
    private javax.swing.JButton removerItensListButton;
    private javax.swing.JMenuItem sairMItem;
    private javax.swing.JMenu sisMenu;
    private org.jdesktop.swingx.JXStatusBar statusBar;
    // End of variables declaration//GEN-END:variables
}
