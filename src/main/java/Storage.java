import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

class Storage {
    private File dbFile;

    public Storage(String filename) {
        String currDirPath = System.getProperty("user.dir");

        // Creates a new directory to store all the files if it does not exist
        String dbDirPath = currDirPath + "/db";
        File dbDir = new File(dbDirPath);
        if (!dbDir.exists()) {
            dbDir.mkdir();
        }

        // Creates a new text file within the database directory if it does not exist
        File dbFile = new File(dbDir, filename);
        try {
            dbFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }

        this.dbFile = dbFile;
    }

    public ArrayList<Task> load() {
        ArrayList<Task> db = new ArrayList<>();
        try {
            BufferedReader readData = new BufferedReader(new FileReader(dbFile));
            String input;
            try {
                while ((input = readData.readLine()) != null) {
                    db.add(textToTask(input));
                }
                readData.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return db;
    }

    private static Task textToTask(String text) {
        String[] textComponent = text.split("\\|");
        Task newTask = null;
        switch (textComponent[0]) {
        case "T":
            newTask = new Todo(textComponent[2]);
            break;
        case "D":
            newTask = new Deadline(textComponent[2], textComponent[3]);
            break;
        case "E":
            newTask = new Event(textComponent[2], textComponent[3]);
            break;
        }
        if (textComponent[1].equals("1")) {
            newTask.doneTask();
        }
        return newTask;
    }
}