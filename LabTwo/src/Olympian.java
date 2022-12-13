public class Olympian {

    private int year;
    private String city, sportName, gender, discipline, medal, name;

    public Olympian(String rawData) {
        String splitedInfo = getNormallySplitedInfo(rawData);
        if (checkInputData(splitedInfo)) {
            String[] line = splitedInfo.split("//");
            this.year = Integer.parseInt(line[0]);
            this.city = line[1];
            this.sportName = line[2];
            this.name = line[3];
            this.gender = line[5];
            this.discipline = line[6];
            this.medal = line[7];
            addOlympianToHisCountry(line[4], this.year + " " + this.city);
            Country.fullListOfOlympicGames.add(line[0] + " " + line[1]);
            Sport.setOfAllSports.add(sportName);
        }
    }

    private boolean checkInputData(String normallySplitedString) {
        String[] line = normallySplitedString.split("//");
        if (line.length != 8) {
            printErrorMessage(normallySplitedString, "Недостаточное количество данных (" + line.length + " полей вместо 8)");
            return false;
        }
        if (!line[0].matches("(189[6-9])|(19[0-9][0-9])|(20(([01][0-9])|(2[0-2])))")) {
            printErrorMessage(normallySplitedString, "Год задан неверно (должен быть целым числом от 1896 до 2022)");
            return false;
        }
        if (!line[5].matches("Men|Women")) {
            printErrorMessage(normallySplitedString, "Пол задан неверно");
        }
        if (!line[7].matches("Gold|Silver|Bronze")) {
            printErrorMessage(normallySplitedString, "Медаль задана неправильно (может быть одна из трех: Gold, Silver, Bronze");
            return false;
        }
        return true;
    }

    private void printErrorMessage(String stringContainsError, String message) {
        System.out.println("При обработке строки «" + stringContainsError.replaceAll("//", ",") + "» возникла проблема: " + message);

    }
    public int getYear() { return this.year; }

    public String getGender() {
        return this.gender;
    }

    public String getSport() {
        return sportName;
    }

    public String getName() {
        return name;
    }

    public String getInfoToPrint() {
        return "Имя медалиста: " + this.name + "; Год: " + this.year + ", Город: " + this.city + "Соревнование: " + this.sportName + " (" + this.discipline + ")";
    }
    public void addOlympianToHisCountry(String codeOfCountry, String olympicGames) {
        if (Country.isCreatedBefore(codeOfCountry)) Country.getCountry(codeOfCountry).addOlympian(this, olympicGames);
        else {
            Country.listOfCountries.add(new Country(codeOfCountry));
            Country.getCountry(codeOfCountry).addOlympian(this, olympicGames);
        }
    }

    public String getMedal() {
        return medal;
    }

    public String getNormallySplitedInfo(String unsplitedStr) {
        StringBuilder returnedString = new StringBuilder();
        String[] str = unsplitedStr.split(",+");
        StringBuilder demoString = new StringBuilder();
        for (String i: str) {
            if (!i.contains("\"") && demoString.length() == 0) {
                returnedString.append(i).append("//");
            }
            else if (!i.contains("\"")) {
                demoString.append(i).append(",");
            }
            else if (i.startsWith("\"")) {
                demoString.append(i.substring(1)).append(",");
            }
            else if (i.endsWith("\"")) {
                demoString.append(i.substring(0, i.length()-1));
                returnedString.append(demoString.append("//"));
                demoString.delete(0, demoString.length());
            }
        }
        return returnedString.toString();
    }
}