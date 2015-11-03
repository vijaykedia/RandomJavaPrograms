package util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Created by vijaykedia on 02/11/15.
 * Sample Output implementation
 */
public class Output implements AutoCloseable {

    private static final String CHARSET = StandardCharsets.UTF_8.name();

    @NotNull private PrintWriter out;

    public Output() throws IOException {
        this(System.out);
    }

    public Output(@NotNull final OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, CHARSET);
        out = new PrintWriter(outputStreamWriter, true);
    }

    @Override
    public void close() {
        out.close();
    }

    public void print(@NotNull final String message) {
        out.println(message);
    }

    public void print(final boolean status) {
        out.println(status);
    }

    public void print(final int value) {
        out.println(value);
    }

    public void print(final char character) {
        out.println(character);
    }

}
