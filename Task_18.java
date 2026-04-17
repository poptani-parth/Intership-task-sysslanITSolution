import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Task_18 {

    public static void main(String[] args) {
        // Change paths as needed
        String sourcePath = "D:\\SourceFolder";
        String backupPath = "D:\\BackupFolder";

        File sourceDir = new File(sourcePath);
        File backupDir = new File(backupPath);

        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Invalid source folder!");
            return;
        }

        // Create backup folder if not exists
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File[] files = sourceDir.listFiles();

        if (files == null) {
            System.out.println("No files to backup.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                Path sourceFile = file.toPath();
                Path targetFile = Paths.get(backupPath, file.getName());

                try {
                    Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copied: " + file.getName());
                } catch (IOException e) {
                    System.out.println("Error copying: " + file.getName());
                }
            }
        }

        System.out.println("Backup completed successfully!");
    }
}