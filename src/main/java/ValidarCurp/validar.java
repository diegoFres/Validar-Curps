package ValidarCurp;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.IOException;



public class validar {

    public static void main(String[] args) {
        //ruta del archivo
        String archivo = "C:\\Users\\diego\\OneDrive\\Documentos\\NetBeansProjects\\memorama\\imagen\\CURPS1.txt";

        // Expresión regular para validar CURP
        String regex = "^[A-Z]{4}\\d{6}[HM][A-Z]{2}[A-Z]{3}\\d{2}$";
        Pattern pat = Pattern.compile(regex);

        BufferedReader BR = null;
        try {
            BR = new BufferedReader(new FileReader(archivo));
            String linea;
            int lineaActual = 1;

            while ((linea = BR.readLine()) != null) {
                Matcher matcher = pat.matcher(linea);

                if (!matcher.matches()) {
                    System.out.println("CURP inválida: " + linea + " Fila " + lineaActual);
                }
                lineaActual++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
    }
    }
}