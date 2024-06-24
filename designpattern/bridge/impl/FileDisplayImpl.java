package designpattern.bridge.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

public class FileDisplayImpl extends DisplayImpl {

    private String filePath;
    private BufferedReader bufferedReader;

    public FileDisplayImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void rawOpen() {
        printLine("file open");
    }

    @Override
    public void rawPrint() {
        try {
            List<String> strings = Files.readAllLines(Path.of(filePath));
            strings.forEach(str -> {
                System.out.print("> ");
                System.out.println(str);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void rawClose() {
        printLine("file close");
    }

    private void printLine(String message) {
        System.out.print("+");
        IntStream.range(0, 10).forEach(elt -> System.out.print("*"));
        System.out.print("  " + message + "  ");
        IntStream.range(0, 10).forEach(elt -> System.out.print("*"));
        System.out.println("-");
    }
}
