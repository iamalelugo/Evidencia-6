import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;


public class ArchivosEx{
	public static void main(String[] args) {
		FileWriter fw = null;
		PrintWriter salida = null;

		try{
			//creamos el archivo en el directorio, el nombre del usuario puede cambiar por lo que es importante
			//que validen cual seria su carpeta.
			File lffd = new File("C:\\Users\\Win\\Documents\\archivos\\LFFD.txt");
			if(lffd.createNewFile()){
				System.out.println("El archivo fue creado");
			} else{
				System.out.println("El archivo NO fue creado");
			}

			String nombre = "Capacitacion Java 2021-2022";

			fw = new FileWriter(lffd);
			salida = new PrintWriter(fw);
			salida.println(nombre);//guardamos texto en la variable de salida
			salida.flush();//escribe lo guardado en la variable salida

		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (IOException ex){
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
        } finally {
			salida.close();
		}

		//La siguiente parte es solo de lectura del texto que ingresamos en el archivo
		//imprimiendo contenido del archivo: 
        //se crean las variables para manejar la lectura 
        File archivo = null;
        FileReader archivoOpener = null;
        BufferedReader lector = null;

        try {
            //operaciones para obtener el texto.
            archivo = new File("C:\\Users\\Win\\Documents\\archivos\\LFFD.txt");
            archivoOpener = new FileReader(archivo);
            lector = new BufferedReader(archivoOpener);
            String line = "";
            System.out.println("Impresion de contenido: ");
            while ((line = lector.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        } finally{
            //finalmente se intenta cerrar el archivo, en caso de error se informa al user con el catch
            try {
                archivoOpener.close();
            } catch (IOException e) {
                System.out.println("No se pudo cerrar el archivo. "+e.toString());
            }
            
        }

	}
}