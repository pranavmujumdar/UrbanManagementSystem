/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.db4o.ext.Db4oException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.google.common.io.Files;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static userinterface.TrafficCopRole.ViewDetailsAreaJPanel.getExtensionByGuava;

/**
 *
 * @author pranav
 */

public class ProcessImage {
    
    public static final String ACCESS_TOKEN = "xS7UOF7s5IAAAAAAAAAAD6ERwh_Eln_z7Kj8-uOxS3Ads2viRBIXsElEk_eJ2n0h";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String getExtensionByGuava(String filename) {
        return Files.getFileExtension(filename);
    }
    

    public static String upload(String path) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("sample", "en_US");
        DbxClientV2 client = new DbxClientV2(config, EcoSystem.ACCESS_TOKEN);

        // Upload "test.txt" to Dropbox
        String root = "/jaadu/";
        String randomName = randomAlphaNumeric(10);
        
        root = root + randomName + "." + getExtensionByGuava(path);
        
        try (InputStream in = new FileInputStream(path)) {
            FileMetadata metadata = client.files().uploadBuilder(root)
                .uploadAndFinish(in);
        }
        
        return root;
    }
    
    public static String download(String webPath) throws Db4oException, IOException, DbxException 
    {
        DbxRequestConfig config = new DbxRequestConfig("sample", "en_US");
        DbxClientV2 client = new DbxClientV2(config, EcoSystem.ACCESS_TOKEN);
        
        String fileSeparator = System.getProperty("file.separator");
        System.out.println(fileSeparator);
        
        String root = "/home/pranav/group2/thebugslayers/Urban/UrbanMaven/resources/";
        String newname = randomAlphaNumeric(5);
        DbxDownloader<FileMetadata> downloader = client.files().download(webPath);        
        try {
            
            newname = newname + "." + getExtensionByGuava(webPath);
//            File file = new File(root+newname);
//            FileOutputStream out = new FileOutputStream(newname);
            FileOutputStream out = new FileOutputStream(root+newname);
            downloader.download(out);
            out.close();
        } catch (DbxException ex) {
            System.out.println("unable to create a local file for product path "+ newname);
        }
        System.out.println(root+newname);
        return root+newname;
    }
    
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
        int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

   
    
    
}
