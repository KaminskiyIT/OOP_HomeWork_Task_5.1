package net.ukr.kaminskiy;

import java.io.File;
import java.io.FileFilter;

public class FileFilterOverride implements FileFilter {
    private String[] arr;

    public FileFilterOverride(String... arr) {
        super();
        this.arr = arr;
    }

    private boolean check(String value) {
        for (String stringExt : arr) {
            if (stringExt.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathName) {
        int index = pathName.getName().lastIndexOf(".");
        if (index == -1) {
            return false;
        }
        String value = pathName.getName().substring(index + 1);
        return check(value);
    }
}