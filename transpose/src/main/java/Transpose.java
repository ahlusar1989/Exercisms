public class Transpose {
    public String transpose(String toTranspose) {

        StringBuilder transposedOutput = new StringBuilder();
        String[] rows = toTranspose.split("\n");

        int maxRowSize = 0;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i].length() > maxRowSize) {
                maxRowSize = rows[i].length();
            }
        }

        padRowsToTheLeft(rows);

        for (int newRowOldCol = 0; newRowOldCol < maxRowSize; newRowOldCol++) {
            for (int newColOldRow = 0; newColOldRow < rows.length; newColOldRow++) {
                if (newRowOldCol < rows[newColOldRow].length()) {
                    transposedOutput.append(rows[newColOldRow].charAt(newRowOldCol));
                }
            }

            if (newRowOldCol != maxRowSize - 1) {
                transposedOutput.append("\n");
            }
        }

        return transposedOutput.toString();
    }



    private void padRowsToTheLeft(String[] rows) {
        for (int i = 0; i < rows.length; i++) {
            for (int j = i; j < rows.length; j++) {
                if(rows[j].length() > rows[i].length()) {
                    rows[i] = String.format("%-" + rows[j].length() + "s", rows[i]);
                }
            }
        }
    }
}