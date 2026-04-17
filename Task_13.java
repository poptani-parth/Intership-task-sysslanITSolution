// Automated file organizer by file type

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Task_13 {

    // Method to get file category
    static String getCategory(String fileName) {
        String name = fileName.toLowerCase();

        if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg"))
            return "Images";
        else if (name.endsWith(".pdf") || name.endsWith(".doc") || name.endsWith(".txt"))
            return "Documents";
        else if (name.endsWith(".mp4") || name.endsWith(".mkv"))
            return "Videos";
        else if (name.endsWith(".mp3") || name.endsWith(".wav"))
            return "Audio";
        else
            return "Others";
    }

    public static void main(String[] args) {
        // Change path as needed
        String folderPath = "D:\\TestFolder";

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path!");
            return;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {

                String category = getCategory(file.getName());

                // Create category folder
                File newDir = new File(folderPath + "\\" + category);
                if (!newDir.exists()) {
                    newDir.mkdir();
                }

                // Move file
                File newFile = new File(newDir, file.getName());

                try {
                    Files.move(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Moved: " + file.getName() + " → " + category);
                } catch (IOException e) {
                    System.out.println("Error moving file: " + file.getName());
                }
            }
        }

        System.out.println("File organization completed!");
    }
}