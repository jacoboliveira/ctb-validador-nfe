/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.tablemodel;

import br.com.ctb.validador.nfe.entities.ElFaltante;
import br.com.ctb.validador.nfe.entities.InfoErros;
import br.com.ctb.validador.nfe.util.CollectionsUtils;
import br.com.ctb.validador.nfe.util.SO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yaaqovtatas777
 */
public class InfoErrosTableModel extends AbstractTableModel {

    String[] colunas = {
        "Nome Arquivo", "Caminho Completo", "Tags que faltam"
    };
    List<InfoErros> list;

    public InfoErrosTableModel() {
    }

    public void setList(List<InfoErros> list) {
        this.list = list;
        fireTableDataChanged();
    }

    public List<InfoErros> getList() {
        return list;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void limparTabela(){
        list.clear();
        fireTableDataChanged();
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if(CollectionsUtils.isEmpty(list)){
            return null;
        }
        InfoErros linhaCorrente = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return linhaCorrente.getNomeArquivo();
            case 1:
                return linhaCorrente.getCaminhoAbsoluto()+SO.getSepArqSO()+linhaCorrente.getNomeArquivo();
            case 2:
                return linhaCorrente.getElFaltantes();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         if(CollectionsUtils.isEmpty(list)){
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
        InfoErros linhaCorrente = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                linhaCorrente.setNomeArquivo((String)aValue);
                break;
            case 1:
                linhaCorrente.setCaminhoAbsoluto((String)aValue);
                break;
            case 2:
                linhaCorrente.setElFaltantes((ArrayList<ElFaltante>)aValue);
        }
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    public void adicionarLinha(InfoErros infoErros){        
        list.add(infoErros);
        int linha = list.size()-1;
        fireTableRowsInserted(linha, linha);
    }

    public void removerLinha(int linhaSelecionada){
        list.remove(linhaSelecionada);
        fireTableRowsDeleted(linhaSelecionada, linhaSelecionada);
    }

    public void removerLinha(InfoErros infoErros){
        int index = list.indexOf(infoErros);
        list.remove(index);
        fireTableRowsDeleted(index,index);
    }

    public void removerTodos(){
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            fireTableRowsDeleted(i, i);
        }
    }


}

