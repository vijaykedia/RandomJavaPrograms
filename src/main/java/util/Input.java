package util;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by vijaykedia on 02/11/15.
 * Sample Input Implementation
 */
public class Input {

    private static final String CHARSET = StandardCharsets.UTF_8.name();
    private static final Locale LOCALE = Locale.US;

    private final Scanner scanner;

    public Input() {
        this(new BufferedInputStream(System.in));
    }

    public Input(@NotNull final InputStream inputStream) {
        scanner = new Scanner(inputStream, CHARSET);
        scanner.useLocale(LOCALE);
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public void close() {
        scanner.close();
    }
}
