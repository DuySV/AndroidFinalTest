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
        questionArrayList.add(new Question(
                "Chất gì trong con người nhiều hơn chất?",
                new String[]{"H2O", "Chất bột", "Chất xám", "Không có chất gì"}, "Chất xám"));
        questionArrayList.add(new Question(
                "Ở cuối con đường tình yêu là gì?",
                new String[]{"Là chữ U", "Là thằng cu", "Là chữ ngu", "Không có đường gì cả"}, "Là chữ U"));
        questionArrayList.add(new Question(
                "Ronaldo là người nước nào?",
                new String[]{"Tây Ban Nha", "Bồ Đào Nha", "Pháp", "Anh"}, "Bồ Đào Nha"));
        questionArrayList.add(new Question(
                "Tôi luôn mang giày đi ngủ. Tôi là ai?",
                new String[]{"Con người", "Con ngựa", "Con mèo", "Con chim"}, "Con ngựa"));
        questionArrayList.add(new Question(
                "Bạn làm việc gì đầu tiên mỗi buổi sáng?",
                new String[]{"Đánh răng", "Mở mắt", "Thức dậy", "Cầm điện thoại"}, "Mở mắt"));
        questionArrayList.add(new Question(
                "Có một đàn vịt, cho biết 1 con đi trước thì có 2 con đi sau, 1 con đi sau thì có 2 con đi trước, 1 con đi giữa thì có 2 con đi 2 bên. Hỏi đàn vịt đó có mấy con?",
                new String[]{"1", "2", "3", "4"}, "3"));
        questionArrayList.add(new Question(
                "Sở thú bị cháy, con gì chạy ra đầu tiên?",
                new String[]{"Con người", "Con ngựa", "Con mèo", "Con chim"}, "Con người"));
        questionArrayList.add(new Question(
                "Có một tàu điện đi về hướng nam. Gió hướng tây bắc. Vậy khói từ con tàu sẽ theo hướng nào?",
                new String[]{"Đông", "Tây", "Bắc", "Không hướng nào"}, "Không hướng nào"));
        questionArrayList.add(new Question(
                "Làm thế nào để không đụng phải ngón tay khi bạn đập búa vào một cái móng tay?",
                new String[]{"Cầm búa bằng cả 2 tay", "Cầm búa bằng tay trái", "Cầm búa bằng tay phải", "Cầm búa bằng chân"},
                "Cầm búa bằng cả 2 tay"));
        questionArrayList.add(new Question(
                "Nếu bạn nhìn thấy con chim đang đậu trên nhánh cây, làm sao để lấy nhánh cây mà không làm động con chim?",
                new String[]{"Bắt chim bỏ ra ngoài", "Đợi chim bay đi.", "Ru chim ngủ rồi lấy", "Cứ đến mà lấy"},
                "Đợi chim bay đi."));
        questionArrayList.add(new Question(
                "Từ gì mà 100% người Việt Nam đều phát âm sai?",
                new String[]{"Đúng", "Sai", "Khó quá bỏ qua", "Không biết "}, "Sai"));
        questionArrayList.add(new Question(
                "Miệng rộng lớn nhưng không nói một từ, là con gì?",
                new String[]{"Con cá voi", "Con khỉ đột", "Con sông", "Con chim "}, "Con sông"));
        questionArrayList.add(new Question(
                "Có bao nhiêu chữ C trong câu sau: \"Cơm, canh, cá, tất cả em đều thích\"?",
                new String[]{"1", "2", "4", "5"}, "1"));
        questionArrayList.add(new Question(
                "Loại nước giải khát nào chứa Canxi và Sắt?",
                new String[]{"CoCa", "Pepsi", "Cafe", "Sinh tố"}, "Cafe"));
        questionArrayList.add(new Question(
                "Cái gì bạn không mượn mà trả?",
                new String[]{"Tiền", "Lời cảm ơn", "Tình", "Không có thứ gì"}, "Lời cảm ơn"));
        questionArrayList.add(new Question(
                "Vào lúc nửa đêm đồng hồ bất chợt gõ 13 tiếng, chuyện gì xảy ra?",
                new String[]{"Có ma", "Chuyện xấu sẽ đến", "Ngày tận thế", "Mang đồng hồ đi sửa"}, "Mang đồng hồ đi sửa"));
        questionArrayList.add(new Question(
                "Cái gì luôn đi đến mà không bao giờ đến nơi?",
                new String[]{"Cơn gió", "Tình yêu", "Ngày mai", "Không biết là cái gì"}, "Ngày mai"));
        questionArrayList.add(new Question(
                "Tìm điểm sai trong câu: \"Dưới ánh nắng sương long lanh triệu cành hồng khoe sắc thắm\".",
                new String[]{"Ánh nắng sương", "Triệu cành hồng", "Khoe sắc thắm", "Sương long lanh"}, "Khoe sắc thắm"));
        questionArrayList.add(new Question(
                "8 chia 4 = ?",
                new String[]{"1/4", "1/2", "3/4", "4/3"}, "4/3"));
        questionArrayList.add(new Question(
                "Một anh thanh niên đánh 1 bà già hỏi anh ấy mất gì?",
                new String[]{"Mất tiền.", "Mất trí.", "Mất sức.", "Mất dạy."}, "Mất dạy."));
        questionArrayList.add(new Question(
                "Có 2 người cha và 2 người con cùng chia đều số tiền là 27 nghìn. Hỏi mỗi người được bao nhiêu?",
                new String[]{"6,75", "7", "7,5", "9"}, "9"));
        questionArrayList.add(new Question(
                "Có 1 đàn chuột điếc đi ngang qua hố cống, hỏi có mấy con?",
                new String[]{"12", "18", "24", "30"}, "24"));
        questionArrayList.add(new Question(
                "Cái gì mà đi thì nằm, đứng cũng nằm, nhưng nằm lại đứng?",
                new String[]{"Cái bàn", "Cái ghế", "Bàn chân", "Bàn tay"}, "Bàn chân"));
        questionArrayList.add(new Question(
                "Bố mẹ có 6 người con trai, mỗi người con trai có một đứa em gái. Vậy gia đình đó có mấy người?",
                new String[]{"8", "9", "10", "11"}, "9"));
        questionArrayList.add(new Question(
                "Chồng người da đen, vợ người da trắng vừa sinh một đứa bé, răng của nó màu gì?",
                new String[]{"Trắng", "Đen", "Vàng", "Đỏ"}, "Trắng"));
        questionArrayList.add(new Question(
                "Đầu đuôi vuông vắn như nhau. Thân chia nhiều đốt rất mau rất đều. Tính tình chân thực đáng yêu. Muốn biết dài ngắn mọi điều có em. Là cái gì?",
                new String[]{"Cái thước kẻ", "Cái bút chì", "Cục tẩy", "Cái bảng"}, "Cái thước kẻ"));
        questionArrayList.add(new Question(
                "Cày trên đồng ruộng trắng phau. Khát xuống uống nước giếng sâu đen ngòm. Là cái gì?",
                new String[]{"Cái cặp sách", "Quyển vở", "Cái bút mực", "Cái bút chì màu"}, "Cái cặp sách"));
        questionArrayList.add(new Question(
                "Hè về áo đỏ như son. Hè đi thay lá xanh non mượt mà. Bao nhiêu tay toả rộng ra. Như vẫy như đón bạn ta đến trường. Là cây gì?",
                new String[]{"Cây phượng", "Cây bằng lăng", "Cây bàng", "Cây dừa"}, "Cây phượng"));
        questionArrayList.add(new Question(
                "Bằng cái hạt cây. Ba gian nhà đầy còn tràn ra sân. Là cái gì?",
                new String[]{"Đèn dầu", "Bóng đèn", "Que diêm", "Nước"}, "Đèn dầu"));
        questionArrayList.add(new Question(
                "Anh mặt đen, anh da trắng. Anh mình mỏng, anh nhọn đầu. Khác nhau mà rất thân nhau. Khi đi khi ở chẳng bao giờ rời. Là cái gì?",
                new String[]{"Bảng và phấn", "Giấy và bút", "Giấy và cục tẩy", "Bảng và bút"}, "Bảng và phấn"));
        questionArrayList.add(new Question(
                "Hạt gieo tới tấp. Rải đều khắp ruộng đồng. Nhưng hạt gieo chẳng nảy mầm. Để bao hạt khác mừng thầm mọc xanh.",
                new String[]{"Hạt rau", "Hạt cát", "Hạt mưa", "Phân bón"}, "Hạt mưa"));
        questionArrayList.add(new Question(
                "Thân em xưa ở bụi tre. Mùa đông xếp lại mùa hè mở ra. Là cái gì?",
                new String[]{"Cái quạt giấy", "Cái chổi rễ", "Cái rổ tre", "Không đáp án nào đúng"}, "Cái quạt giấy"));
        questionArrayList.add(new Question(
                "Ao tròn vành vạnh. Nước lạnh như tiền. Con gái như tiên. Trần mình xuống lội",
                new String[]{"Bánh đa", "Bánh trôi nước", "Quả hồng ngâm", "A & B đúng "}, "Bánh trôi nước"));
        questionArrayList.add(new Question(
                "Cái dạng quan anh xấu lạ lùng. Khom lưng uốn gối cả đời cong. Lưỡi to ra sức mà ăn khoét. Đành phải theo đuôi có thẹn không?",
                new String[]{"Cái cuốc", "Con trâu", "Cái cày", "Cái xẻng"}, "Cái cày"));
        questionArrayList.add(new Question(
                "Con gì đạp thì sống không đập thì chết",
                new String[]{"Con ma", "Con tym", "Con mắt", "Con tim"}, "Con tim"));
        questionArrayList.add(new Question(
                "Vuông vuông cửa đóng 2 đầu 100 thẳng chệt lần hỏi chui ra Thằng nào không mũ thì tha Thằng nào có mũ đem ra đốt đầu ",
                new String[]{"Que tăm", "Que diêm", "Que củi", "Que kem"}, "Que diêm"));
        questionArrayList.add(new Question(
                "Ở nơi cao nhất trên đầu. Chẳng đen như tóc lại màu đỏ tươi. Lúc khoẻ đẹp như mặt trời. Đến khi đau yếu màu tươi xám dần",
                new String[]{"Băng đô", "Tóc giả", "Vòng nguyệt quế", "Mào gà"}, "Mào gà"));
        questionArrayList.add(new Question(
                "Bốn chữ đi khắp một đời. Ai sinh ra cũng phải thời trải qua ",
                new String[]{"Xuân Hạ Thu Đông", "Công Dung Ngôn Hạnh", "Sinh Lão Bệnh Tử", "Môn Đăng Hộ Đối"}, "Sinh Lão Bệnh Tử"));
        questionArrayList.add(new Question(
                "Nơi nào có phố Kỳ lừa có nàng Tô Thị có chùa Tam Thanh ",
                new String[]{"Chùa Hương", "Quảng Bình", "Đồng Lộc", "Đồng Đăng"}, "Đồng Đăng"));
        questionArrayList.add(new Question(
                "Mặt gì bằng phẳng thênh thang, người đi muôn lối dọc ngang phố phường",
                new String[]{"Mặt trăng", "Mặt trời", "Mặt trận", "Mặt đất"}, "Mặt đất"));
        questionArrayList.add(new Question(
                "\"Áo đơn áo kép đứng nép bờ ao\" là cây gì? ",
                new String[]{"Cây tre", "Cây chuối", "Cây gạo", "Cây đa"}, "Cây chuối"));
        questionArrayList.add(new Question(
                "\"Nắng 3 năm ta không bỏ bạn \n Mưa một ngày bạn lại bỏ ta \" ",
                new String[]{"Cái mũ", "Cái áo", "Cái bóng", "Cây dù"}, "Cái bóng"));
        questionArrayList.add(new Question(
                "Cái gì càng kéo càng ngắn?",
                new String[]{"Sợi dây", "Điếu thuốc", "Cao su", "Cái ấy"}, "Điếu thuốc"));
        questionArrayList.add(new Question(
                "Một con ngựa bị buộc vào cổ bởi sợi dây 10m. Nhưng cách đó 11m có bụi cỏ xanh mướt. Hỏi con ngựa có ăn được cỏ không",
                new String[]{"Có", "Không", "Không biết", "Bỏ qua"}, "Có"));
        questionArrayList.add(new Question(
                "Ngày 20 tháng 11 là ngày kỷ niệm nhà giáo Việt Nam. Nước Mỹ có ngày 20 tháng 11 hay không?",
                new String[]{"Có ", "Không", "Không biết nữa", "Khó quá bỏ qua"}, "Có "));
        questionArrayList.add(new Question(
                "Trong 1 năm, tháng thì có ngày 31, tháng thì có ngày 30, vậy có bao nhiêu tháng có ngày 28?",
                new String[]{"1 ", "2", "7", "12"}, "12"));
        questionArrayList.add(new Question(
                "Trung bình 1 người có ít nhất bao nhiêu ngày sinh nhật",
                new String[]{"1  ", "Ít nhất 1", "2 ", "Nhiều hơn 2"}, "1  "));
        questionArrayList.add(new Question(
                "Điền vào chỗ trống : 1, 2, 3, 5, 8 , (…)",
                new String[]{"13", "11", "6  ", "15"}, "13"));
        questionArrayList.add(new Question(
                "Có tất cả 4 trái xoài trên bàn, bạn lấy đi 3, hiện giờ bạn có bao nhiêu quả xoài?",
                new String[]{"1", "2", "3", "4"}, "3"));
        questionArrayList.add(new Question(
                "Điều này có hợp lý hay không nếu 1 người đàn ông ở Sài Gòn cưới cô em gái của bà vợ quả phụ của ông ta",
                new String[]{"Hợp lí", "Không hợp lý", "Bỏ qua", "Tất cả đều đúng"}, "Hợp lí"));
        questionArrayList.add(new Question(
                "Bạn tham dự vào 1 cuộc chạy thi, bạn vượt người thứ 2, vậy vị trí của bạn là thứ mấy?",
                new String[]{"1", "3", "2", "4"}, "2"));
        questionArrayList.add(new Question(
                "Bạn có 1000 cộng thêm 40. Bây giờ bạn cộng thêm 1000 khác. Và giờ thì cộng thêm 30...Cộng thêm 1000 nữa. Cộng thêm 20. Cộng thêm 1000 khác. Cộng thêm 10. Tổng là bao nhiêu vậy?",
                new String[]{"5000", "5100", "4100", "3900"}, "4100"));
        questionArrayList.add(new Question(
                "Lịch nào dài nhất?", new String[]{"Lịch sử", "Lịch trình", "Lịch thi", "Tất cả đều đúng"}, "Lịch sử"));
        questionArrayList.add(new Question(
                "Đố ai quét sạch quân Đường\n" + "\n" + "Nổi danh Bố Cái Đại Vương thuở nào\n" +
                        "\n" + "Tiếc thay mệnh bạc tài cao\n" + "\n" + "Giang sơn đành phải rơi vào ngoại bang?",
                new String[]{"Phú Hưng", "Khải Định", "Lê Chiêu Thống", "Đồng Khánh"}, "Phú Hưng"));
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
