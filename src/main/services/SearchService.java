package searchService;

import java.io.*;

public class SearchService {
    private Result result = new Result();

    public Result findNumber(int number, File dir) {
        File[] files = dir.listFiles();
        for (File i : files) {
            if (searchInFile(number, i)) {
                result.setFileNames(i.getName());
            }
        }
        return checkResultFields(result);
    }

    private Result checkResultFields(Result result) {
        if (result.getCode() == null && result.getFileNames().isEmpty()) {
            result.setCode("01.Result.NotFound");
        }
        if (result.getError() != null) {
            result.setCode("02.Result.Error");
        }
        return result;
    }

    private boolean searchInFile(int number, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str;
            StringBuilder numberForMatching = new StringBuilder();
            char[] ch;
            while ((str = br.readLine()) != null) {
                ch = str.toCharArray();
                for (char c : ch) {
                    if (c == ',') {
                        if (Integer.parseInt(numberForMatching.toString()) != number) {
                            numberForMatching.delete(0, numberForMatching.length());
                        } else {
                            result.setCode("00.Result.OK");
                            return true;
                        }
                    } else {
                        numberForMatching.append(c);
                    }
                }
            }
        } catch (IOException e) {
            result.setError(e.toString());
        }
        return false;
    }
}
