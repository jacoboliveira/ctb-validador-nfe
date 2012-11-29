/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ctb.validador.nfe.util;

import br.com.jacob.util.BeanHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

/**
 *
 * @author jacoboliveira
 */
public class CollectionsUtils {
    /**
     *
     * @param <T>
     * @param destino
     * @param origem
     * @return
     */
    public static <T> List<T> clone(List destino, List origem) {
        copy(origem,destino);
        return destino;
    }

    /**
     * 
     * @param <T>
     * @param src
     * @param dest
     */
    public static <T> void copy(List<T> src,List dest) {
        if (dest == null) {
            dest = new ArrayList();
        }
        if (src == null || src.isEmpty()) {
            return;
        }
        for (ListIterator si = src.listIterator(); si.hasNext();) {
            dest.add(si.next());
        }
    }

     public static <T> List transformArrayObjToListBean(Object[] a,Class<? extends T[]> classe){
        return Arrays.asList(Arrays.copyOf(a, a.length, classe));
     }
     public static <T> List<T> transformar(List<T> src, final Class classe) throws Exception {

        CollectionUtils.transform(src, new Transformer() {

            @Override
            public Object transform(Object o) {
                Object bean = null;
                try {
                    bean = BeanHelper.newInstance(classe);
                    BeanHelper.copiarPropriedade(o, bean);
                } catch (Exception ex) {
                    //Logger.getLogger(CollectionsUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                return bean;
            }
        });
        return src;
    }

     public static boolean isEmpty(Collection list) {
        return list == null || list.isEmpty();
    }
}
