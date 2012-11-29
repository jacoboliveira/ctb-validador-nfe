/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ctb.validador.nfe.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;

/**
 *
 * @author jacob
 */
public class ResourceBundleUtil {

    private PropertyResourceBundle propertyResourceBundle;

    public ResourceBundleUtil(FileInputStream fis) throws IOException {
        propertyResourceBundle = new PropertyResourceBundle(fis);
    }

    public ResourceBundleUtil(String path_file) throws IOException {
        propertyResourceBundle = new PropertyResourceBundle(new FileInputStream(new File(path_file)));
    }

    public PropertyResourceBundle getPropertyResourceBundle() {
        return propertyResourceBundle;
    }
    //alternativa
//    private Properties props;
//    private Map<String,Object> lookup;
//
//    public ResourceBundleUtil(String path) {
//        props = new Properties();
//        FileInputStream fis=null;
//        try {
//            fis = new FileInputStream(new File(path));
//            props.load(fis);
//        } catch (IOException ex) {
//            Logger.getLogger(ResourceBundleUtil.class.getName()).log(Level.SEVERE, null, ex);
//        }finally{
//            if(fis!=null){
//                try {
//                    fis.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(ResourceBundleUtil.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        lookup = new HashMap(props);
//    }
}
