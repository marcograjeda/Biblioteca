/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
/**
 *
 * @author Marco
 */
public class FileHelper {
    private static final Charset CHARSET = Charset.forName("UTF-8");
    
    public static String leerArchivo(File archivo) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = Files.newBufferedReader(archivo.toPath(), CHARSET);
        String linea = null;
        while((linea = reader.readLine()) != null){
            stringBuilder.append(linea);
        }
        reader.close();
        
        return stringBuilder.toString();
    }
    
    public static void guardarArchivo(String contenido, File archivo) throws IOException{
        BufferedWriter writer = Files.newBufferedWriter(archivo.toPath(), CHARSET);
        writer.write(contenido, 0, contenido.length());
        writer.close();
    }
}
