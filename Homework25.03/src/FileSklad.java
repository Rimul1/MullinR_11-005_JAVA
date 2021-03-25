import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class FileSklad implements Sklad {
    private static final String TEMP_FILE_NAME = "skladTMP.txt";
    private final String fileName;
    private final GoodConvertor goodConvertor;


    public FileSklad(String fileName, GoodConvertor goodConvertor) {
        this.fileName = fileName;
        this.goodConvertor = goodConvertor;
    }

    @Override
    public void add(Goods good) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(goodConvertor.goodToString(good));
            fileWriter.append("\n");

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeByName(String name) {

        try (
                InputStream inputStream = new FileInputStream(fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                FileWriter fileWriter = new FileWriter(TEMP_FILE_NAME, false);
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));
                Stream<String> linesStream = bufferedReader.lines();
        ) {
            linesStream
                    .map(goodConvertor::stringToGood)
                    .filter(good -> !name.equals(good.getName()))
                    .map(goodConvertor::goodToString)
                    .forEach(printWriter::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(fileName).delete();
        new File(TEMP_FILE_NAME).renameTo(new File(fileName));
    }

    @Override
    public void changeCountByName(String name, Integer count) {
        try (
                InputStream inputStream = new FileInputStream(fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                FileWriter fileWriter = new FileWriter(TEMP_FILE_NAME, false);
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(fileWriter));
                Stream<String> linesStream = bufferedReader.lines();
        ) {
            linesStream
                    .map(goodConvertor::stringToGood)
                    .peek(goods -> {
                        if (goods.getName().equals(name)) {
                            goods.setCount(count);
                        }
                    })
                    .map(goodConvertor::goodToString)
                    .forEach(printWriter::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(fileName).delete();
        new File(TEMP_FILE_NAME).renameTo(new File(fileName));
    }

    @Override
    public Goods getByName(String name) {
        try {
            return Files.lines(Paths.get(fileName))
                    .map(goodConvertor::stringToGood)
                    .filter(goods -> goods.getName().equals(name))
                    .findFirst().orElse(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void printSklad() {
        try {
            Files.lines(Paths.get(fileName))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
