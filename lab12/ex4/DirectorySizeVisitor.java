import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class DirectorySizeVisitor extends SimpleFileVisitor<Path> {

    private AtomicLong totalSize = new AtomicLong(0);
    private Map<String, Long> fileSizes = new HashMap<>();
    private final Path rootPath;
    private final boolean isRecursive;

    public DirectorySizeVisitor(Path rootPath, boolean isRecursive) {
        this.rootPath = rootPath;
        this.isRecursive = isRecursive;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size = attrs.size();
        totalSize.addAndGet(size);
        
        if (!isRecursive && file.getParent().equals(rootPath)) {
             fileSizes.put(file.getFileName().toString(), size);
        } else if (isRecursive) {
             fileSizes.put(rootPath.relativize(file).toString(), size);
        }

        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (!isRecursive && !dir.equals(rootPath)) {
            return FileVisitResult.SKIP_SUBTREE; 
        }
        return FileVisitResult.CONTINUE;
    }

    public Map<String, Long> getFileSizes() {
        return fileSizes;
    }

    public long getTotalSize() {
        return totalSize.get();
    }
}