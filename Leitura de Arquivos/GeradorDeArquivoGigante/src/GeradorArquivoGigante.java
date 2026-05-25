import java.io.BufferedWriter;
import java.io.FileWriter;

public class GeradorArquivoGigante {
    public static void main(String[] args) {
        String fileName = "benchmark.txt";
        String linhaBase = "Uma linha de exemplo";
        long tamanho = 200L * 1024 * 1024;
        
        try {
            long tamanhoAtual = 0;
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            
            while(tamanhoAtual < tamanho) {
                writer.write(linhaBase);
                tamanhoAtual += linhaBase.getBytes().length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
