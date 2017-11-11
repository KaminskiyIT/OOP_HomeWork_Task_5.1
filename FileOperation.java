package net.ukr.kaminskiy;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {
    public static void copyFile(File fileFrom, File fileTo) throws IOException {
        if (fileFrom == null || fileTo == null) {
            throw new IllegalArgumentException("null file pointer");
        }
        try (FileInputStream fis = new FileInputStream(fileFrom); FileOutputStream fos = new FileOutputStream(fileTo)) {
            byte[] buffer = new byte[1024 * 1024];
            int readByte = 0;
            for (; (readByte = fis.read(buffer)) > 0;) {
                fos.write(buffer, 0, readByte);
            }
        }

    }

    public static void copyFolder(File folderFrom, File folderTo, FileFilter ffilt) throws IOException {
        if (folderFrom == null || folderTo == null || ffilt == null) {
            throw new IllegalArgumentException("null file pointer");
        }

        File[] files = folderFrom.listFiles(ffilt);

        if(files.length == 0) {
            System.out.println("There are no objects to process!");
        }
        for (File file : files) {
            copyFile(file, new File(folderTo, file.getName()));
        }
        if(files.length > 0) {
            System.out.println("Copying completed!");
        }
    }
}

