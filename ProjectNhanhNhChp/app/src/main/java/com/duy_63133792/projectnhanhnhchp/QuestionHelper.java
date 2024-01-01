package com.duy_63133792.projectnhanhnhchp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME = "NhanhNhuChop.db";
    private static final int DB_VERSION = 3;
    private static final String TABLE_NAME = "TQ";
    private static final String UID = "_UID";
    private static final String QUESTION = "QUESTION";
    private static final String OPTA = "OPTA";
    private static final String OPTB = "OPTB";
    private static final String OPTC = "OPTC";
    private static final String OPTD = "OPTD";
    private static final String ANSWER = "ANSWER";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " +
            "" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " +
            "" + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " +
            "" + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public QuestionHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }
    public void allQuestion(){
        ArrayList<Question> questionArrayList = new ArrayList<>();

        questionArrayList.add(new Question("We have lived in Hanoi............... 4 years.",
                new String[]{"in", "since", "for", "at"},
                "at"));
        questionArrayList.add(new Question("2",
                new String[]{"1", "2", "3", "4"},
                "2"));

        this.addAllQuestion(questionArrayList);
    }

    private void addAllQuestion(List<Question> questionArrayList) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values;
            for (Question question : questionArrayList) {
                values = new ContentValues();
                values.put(QUESTION, question.getQuestion());
                String[] options = question.getOptions();
                if (options != null && options.length >= 4) {
                    values.put(OPTA, options[0]); // Gán giá trị của OPTA từ mảng options
                    values.put(OPTB, options[1]); // Gán giá trị của OPTB từ mảng options
                    values.put(OPTC, options[2]); // Gán giá trị của OPTC từ mảng options
                    values.put(OPTD, options[3]); // Gán giá trị của OPTD từ mảng options
                    Log.d("add", question.getAnswer());
                } else {
                    Log.d("AllQ", "Option bị null hoặc không đủ phần tử!");
                }
                values.put(ANSWER, question.getAnswer());
                database.insert(TABLE_NAME, null, values);
            }
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
            database.close();
        }
    }
    public List<Question> getAllofTheQuestion() {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = database.query(TABLE_NAME, coloumn, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));

                String[] options = new String[4];

                options[0] = cursor.getString(2);
                options[1] = cursor.getString(3);
                options[2] = cursor.getString(4);
                options[3] = cursor.getString(5);

                question.setOptions(options);
                question.setAnswer(cursor.getString(6));

                Log.d("get", question.getQuestion());
                Log.d("get", Arrays.toString(question.getOptions()));

                questionList.add(question);
            }
        }

        cursor.close();
        database.close();
        return questionList;
    }
    public void dropTable() {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(DROP_TABLE);
        onCreate(database); // Tạo lại bảng sau khi xóa
        database.close();
    }
    public void clearTable() {
        SQLiteDatabase database = this.getWritableDatabase();
        try {
            database.delete(TABLE_NAME, null, null);
        } finally {
            database.close();
        }
    }
}
