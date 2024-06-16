package exercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.io.File;
import java.util.concurrent.ExecutionException;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String firstFile, String secondFile, String resultFile)
            throws IOException, ExecutionException, InterruptedException {

        Path firstFilePath = Path.of(firstFile).toAbsolutePath().normalize();
        if (!Files.exists(firstFilePath)) {
            throw new NoSuchFileException(firstFile);
//            throw new FileNotFoundException(firstFile);
        }
        Path secondFilePath = Path.of(secondFile).toAbsolutePath().normalize();
        if (!Files.exists(secondFilePath)) {
            throw new NoSuchFileException(secondFile);
//            throw new FileNotFoundException(secondFile);
        }
        Path resultFilePath = Path.of(resultFile).toAbsolutePath().normalize();

        CompletableFuture<String> firstFileReadAsync = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(firstFilePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> secondFileReadAsync = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(secondFilePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> resultFileCreeateAsync = firstFileReadAsync.thenCombine(secondFileReadAsync, (first, second) -> {
            String result = first + second;
            return result;
        }).exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return null;
        });

        Files.writeString(resultFilePath, resultFileCreeateAsync.get(), StandardOpenOption.CREATE);
        return resultFileCreeateAsync;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/resultFile.txt" );
        // END
    }
}

