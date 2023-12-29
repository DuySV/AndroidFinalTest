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

        List<String> options1 = Arrays.asList(" H20", " Chất bột", " Chất xám", " Không có chất gì");
        Question question1 = new Question("Chất gì trong con người nhiều hơn chất ?", options1, " Chất xám");

        List<String> options2 = new ArrayList<>();
        options2.addAll(Arrays.asList("Là chữ U", "Là thằng cu", "Là chữ ngu", "Không có đường gì cả"));
        questionArrayList.add(new Question(
                "Ở cuối con đường tình yêu là gì?", options2, "Đường chữ U"));

        this.addAllQuestion(questionArrayList);
    }

    private void addAllQuestion(List<Question> questionArrayList) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (Question question: questionArrayList){
                values.put(QUESTION, question.getQuestion());
                List<String> options = question.getOptions();
                if (options != null && options.size() >= 4) {
                    values.put(OPTA, options.get(0));
                    values.put(OPTB, options.get(1));
                    values.put(OPTC, options.get(2));
                    values.put(OPTD, options.get(3));
                } else {
                    Log.d("AllQ", "Option bị null!");
                }
                values.put(ANSWER, question.getAnswer());
                database.insert(TABLE_NAME, null, values);
            }
            database.setTransactionSuccessful();

        }finally {
            database.endTransaction();
            database.close();
        }
    }
    public List<Question> getAllofTheQuestion(){
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        database.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = database.query(TABLE_NAME, coloumn, null, null, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()){
                Question question = new Question();
                question.setId(cursor.getInt(0));
                question.setQuestion(cursor.getString(1));
                List<String> options = new ArrayList<>();
                options.add(cursor.getString(2));
                options.add(cursor.getString(3));
                options.add(cursor.getString(4));
                options.add(cursor.getString(5));
                question.setOptions(options);
                questionList.add(question);
                Log.d("get", cursor.getString(1));            }
        }

        database.setTransactionSuccessful();
        database.endTransaction();
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
