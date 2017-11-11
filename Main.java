package net.ukr.kaminskiy;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        FileFilterOverride ffo = new FileFilterOverride("docx", "txt", "jpg");
        File folderFrom = new File("folderFrom");
        File folderTo = new File("folderTo");
        try {
            FileOperation.copyFolder(folderFrom, folderTo, ffo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}