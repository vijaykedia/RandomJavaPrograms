package com.kediavijay;

import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * Created by vijaykedia on 29/10/15.
 * This will copy the files from src directory to destination directory
 */
public class CopyFilesBetweenDirectories {

    public static void main(@NotNull final String[] args) throws IOException {
        final String srcDirPath = "/Users/vijaykedia/Downloads/srcDir";
        final String destDirPath = "/Users/vijaykedia/Downloads/Temp";

        final File srcDir = new File(srcDirPath);
        final File destDir = new File(destDirPath);

        FileUtils.copyDirectoryToDirectory(srcDir, destDir);
    }
}
