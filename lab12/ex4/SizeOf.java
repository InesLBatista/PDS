import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class SizeOf {

    public static void main(String[] args) {

        String directoryPathString = null;
        boolean recursiveTemp = false; // variável temporária

        if (args.length == 2 && args[0].equals("-r")) {
            recursiveTemp = true;
            directoryPathString = args[1];
        } else if (args.length == 1) {
            directoryPathString = args[0];
        } else {
            System.err.println("Uso: java -jar sizeOf.jar [-r] <diretório>");
            return;
        }

        // Agora sim: variável FINAL usada na lambda
        final boolean recursiveFlag = recursiveTemp;

        try {
            Path rootPath = Paths.get(directoryPathString);

            if (!Files.isDirectory(rootPath)) {
                System.err.println("Erro: O caminho especificado não é um diretório ou não existe.");
                return;
            }

            DirectorySizeVisitor visitor = new DirectorySizeVisitor(rootPath, recursiveFlag);

            Files.walkFileTree(rootPath, visitor);

            visitor.getFileSizes().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    long sizeKB = (long) Math.ceil((double) entry.getValue() / 1024);

                    String fileName = entry.getKey();
                    if (recursiveFlag && !fileName.contains("/")) {
                        System.out.println(fileName + ": " + sizeKB + " kB");
                    } else if (recursiveFlag && fileName.contains("/")) {
                        System.out.println("-> " + fileName + ": " + sizeKB + " kB");
                    } else {
                        System.out.println(fileName + ": " + sizeKB + " kB");
                    }
                });

            long totalSizeKB = (long) Math.ceil((double) visitor.getTotalSize() / 1024);
            System.out.println("Total: " + totalSizeKB + " kB");

        } catch (IOException e) {
            System.err.println("Erro no diretório: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
