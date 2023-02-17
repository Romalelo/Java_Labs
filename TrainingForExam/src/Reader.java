import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    private static final String COMMA_DELIMITER = ",", QUOTES_DELIMITER = "\"";
    public static int lineNumber = 0;
    public static List<String> title = new ArrayList<>(), subject = new ArrayList<>(), director = new ArrayList<>();
    public static List<Integer> year = new ArrayList<>(), length = new ArrayList<>(), popularity = new ArrayList<>();
    public static List<Boolean> awards = new ArrayList<>();

    public static void read() {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("data_film.csv"));) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                records.add(getRecordFromLine(scanner.nextLine()));
                new Film();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> getRecordFromLine(String line) {

        List<String> values = new ArrayList<String>();

        int index = 1, counter = 0, buff, index2 = 1, index3 = 0;
        try (Scanner rowScanner = new Scanner(line)) {
            Scanner rowScanner2 = new Scanner(line);
            Scanner rowScanner3 = new Scanner(line);
            rowScanner2.useDelimiter(QUOTES_DELIMITER);
            rowScanner3.useDelimiter(QUOTES_DELIMITER);

            while (rowScanner3.hasNext()) {
                String data3 = rowScanner3.next();
                index3++;
            }

            while (rowScanner2.hasNext()) {
                String data2 = rowScanner2.next();
                rowScanner.useDelimiter(COMMA_DELIMITER);
                if (index3 == 3) {
                    if (index2 == 1) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 1) {
                                try {
                                    buff = Integer.parseInt(data);
                                    year.add(buff);
                                } catch (NumberFormatException e) {
                                    year.add(0);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                            } else if (index == 2)
                                try {
                                    buff = Integer.parseInt(data);
                                    length.add(buff);
                                } catch (NumberFormatException e) {
                                    length.add(0);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                            else if (index == 3)
                                try {
                                    title.add(data);
                                } catch (NumberFormatException e) {
                                    title.add("NULL");
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                            else if (index == 4) {
                                try {
                                    subject.add(data);
                                } catch (NumberFormatException e) {
                                    subject.add("NULL");
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                values.add(data);
                                break;
                            }
                            index++;
                            values.add(data);
                        }
                    } else if (index2 == 2) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 5) {
                                try {
                                    director.add(data2);
                                } catch (NumberFormatException e) {
                                    director.add("NULL");
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                values.add(data);
                                break;
                            }
                            index++;
                            values.add(data);
                        }
                    } else if (index2 == 3) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 7)
                                try {
                                    buff = Integer.parseInt(data);
                                    popularity.add(buff);
                                } catch (NumberFormatException e) {
                                    popularity.add(0);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                            else if (index == 8) {
                                try {
                                    if (data == "Yes") {
                                        awards.add(Boolean.TRUE);
                                    } else {
                                        awards.add(Boolean.FALSE);
                                    }
                                } catch (NumberFormatException e) {
                                    awards.add(Boolean.TRUE);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                values.add(data);
                                break;
                            }
                            index++;
                            values.add(data);
                        }
                    }
                } else if (index3 == 5) {
                    if (index2 == 1) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 1) {
                                try {
                                    buff = Integer.parseInt(data);
                                    year.add(buff);
                                } catch (NumberFormatException e) {
                                    year.add(0);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                            } else if (index == 2) {
                                try {
                                    buff = Integer.parseInt(data);
                                    length.add(buff);
                                } catch (NumberFormatException e) {
                                    length.add(0);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                values.add(data);
                                break;
                            }
                            index++;
                            values.add(data);
                        }
                    } else if (index2 == 2) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 3) {
                                try {
                                    title.add(data2);
                                } catch (NumberFormatException e) {
                                    title.add("NULL");
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                index2++;
                                values.add(data2);
                                break;
                            }
                        }
                        continue;
                    } else if (index2 == 3) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 5) {
                                try {
                                    subject.add(data);
                                } catch (NumberFormatException e) {
                                    subject.add("NULL");
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                values.add(data);
                                break;
                            }
                            index++;
                        }
                    } else if(index2 == 4) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 6) {
                                try {
                                    director.add(data2);
                                } catch (NumberFormatException e) {
                                    director.add("NULL");
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                index2++;
                                values.add(data2);
                                break;
                            }
                        }
                        continue;
                    } else if (index2 == 5) {
                        while (rowScanner.hasNext()) {
                            String data = rowScanner.next();
                            if (index == 8)
                                try {
                                    buff = Integer.parseInt(data);
                                    popularity.add(buff);
                                } catch (NumberFormatException e) {
                                    popularity.add(0);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                            else if (index == 9){
                                try {
                                    if (data == "Yes") {
                                        awards.add(Boolean.TRUE);
                                    } else {
                                        awards.add(Boolean.FALSE);
                                    }
                                } catch (NumberFormatException e) {
                                    awards.add(Boolean.TRUE);
                                    System.out.println("Неверные данные в строке " + lineNumber);
                                }
                                index++;
                                values.add(data);
                                break;
                            }
                            index++;
                            values.add(data);
                        }
                    }

                }
                index2++;
            }
        }
        return values;
    }
}


