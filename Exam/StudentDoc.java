package Exam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDoc {
    private static final String STUDENTS_FILE_NAME = "Students.dat";

    public void write(List<Students> studentList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        oos.writeObject(studentList);
        try {
            fos = new FileOutputStream(new File(STUDENTS_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    public List<Students> read() {
        List<Students> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(STUDENTS_FILE_NAME));
            ois = new ObjectInputStream(fis);
            studentList = (List<Students>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}