package com.duy_63133792.projectnhanhnhchp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;
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
                "Chất gì trong con người nhiều hơn chất ?", "A. H20", "B. Chất bột", "C. Chất xám", "D. Không có chất gì", "C. Chất xám"));
        questionArrayList.add(new Question(
                "Ở cuối con đường tình yêu là gì?", "A. Là chữ U", "B. Là thằng cu", "C. Là chữ ngu", "D. Không có đường gì cả", "A. Đường chữ U"));
        questionArrayList.add(new Question(
                "Ronaldo là người nước nào?", "A. Tây Ban Nha", "B. Bồ Đào Nha", "C. Pháp", "D. Anh", "B. Bồ Đào Nha"));
        questionArrayList.add(new Question(
                "Tôi luôn mang giày đi ngủ. Tôi là ai?", "A. Con người", "B. Con ngựa", "C. Con mèo ", "D. Con chim ", "B. Con ngựa"));
        questionArrayList.add(new Question(
                "Bạn làm việc gì đầu tiên mỗi buổi sáng?", "A. Đánh răng", "B. Mở mắt", "C. Thức dậy", "D. Cầm điện thoại", "B. Mở mắt"));
        questionArrayList.add(new Question(
                "Có một đàn vịt, cho biết 1 con đi trước thì có 2 con đi sau, 1 con đi sau thì có 2 con đi trước, 1 con đi giữa thì có 2 con đi 2 bên. Hỏi đàn vịt đó có mấy con?","A. 1", "B. 2", "C. 3", "D. 4", "C. 3"));
        questionArrayList.add(new Question(
                "Sở thú bị cháy, con gì chạy ra đầu tiên?", "A. Con người", "B. Con ngựa  ", "C. Con mèo ", "D. Con chim ", "A. Con người"));
        questionArrayList.add(new Question(
                "Có một tàu điện đi về hướng nam. Gió hướng tây bắc. Vậy khói từ con tàu sẽ theo hướng nào?", "A. Đông", "B. Tây", "C. Bắc", "D. Không hướng nào", "D. Không hướng nào"));
        questionArrayList.add(new Question(
                "Làm thế nào để không đụng phải ngón tay khi bạn đập búa vào một cái móng tay?", "A. Cầm búa bằng cả 2 tay", "B. Cầm búa bằng tay trái", "C. Cầm búa bằng tay phải", "D. Cầm búa bằng chân", "A. Cầm búa bằng cả 2 tay"));
        questionArrayList.add(new Question(
                "Nếu bạn nhìn thấy con chim đang đậu trên nhánh cây, làm sao để lấy nhánh cây mà không làm động con chim?", "A. Bắt chim bỏ ra ngoài", "B. Đợi chim bay đi.", "C. Ru chim ngủ rồi lấy", "D. Cứ đến mà lấy", "B. Đợi chim bay đi."));
        questionArrayList.add(new Question(
                "Từ gì mà 100% người Việt Nam đều phát âm sai?", "A. Đúng", "B. Sai", "C. Khó quá bỏ qua", "D. Không biết ", "B. Sai"));
        questionArrayList.add(new Question(
                "Miệng rộng lớn nhưng không nói một từ, là con gì?", "A. Con cá voi", "B. Con khỉ đột", "C. Con sông", "D. Con chim ", "C. Con sông"));
        questionArrayList.add(new Question(
                "Có bao nhiêu chữ C trong câu sau: \"Cơm, canh, cá, tất cả em đều thích\"?", "A. 1", "B. 2", "C. 4", "D. 5", "A. 1"));
        questionArrayList.add(new Question(
                "Loại nước giải khát nào chứa Canxi và Sắt?", "A. CoCa", "B. Pepsi", "C. Cafe", "D. Sinh tố", "C. Cafe"));
        questionArrayList.add(new Question(
                "Cái gì bạn không mượn mà trả?", "A. Tiền", "B. Lời cảm ơn", "C. Tình", "D. Không có thứ gì", "B. Lời cảm ơn"));
        questionArrayList.add(new Question(
                "Vào lúc nửa đêm đồng hồ bất chợt gõ 13 tiếng, chuyện gì xảy ra?", "A. Có ma", "B. Chuyện xấu sẽ đến", "C. Ngày tận thế", "D. Mang đồng hồ đi sửa", "D. Mang đồng hồ đi sửa"));
        questionArrayList.add(new Question(
                "Cái gì luôn đi đến mà không bao giờ đến nơi?", "A. Cơn gió", "B. Tình yêu", "C. Ngày mai", "D. Không biết là cái gì", "C. Ngày mai"));
        questionArrayList.add(new Question(
                "Tìm điểm sai trong câu: \"Dưới ánh nắng sương long lanh triệu cành hồng khoe sắc thắm\".", "A. Ánh nắng sương", "B. Triệu cành hồng", "C. Khoe sắc thắm", "D. Sương long lanh", "C. Khoe sắc thắm"));
        questionArrayList.add(new Question(
                "8 chia 4 = ?", "A. 1/4", "B. 1/2", "C. 3/4", "D. 4/3", "D. 4/3"));
        questionArrayList.add(new Question(
                "Một anh thanh niên đánh 1 bà già hỏi anh ấy mất gì?", "A. Mất tiền.", "B. Mất trí.", "C. Mất sức.", "D. Mất dạy.", "D. Mất dạy."));
        questionArrayList.add(new Question(
                "Có 2 người cha và 2 người con cùng chia đều số tiền là 27 nghìn. Hỏi mỗi người được bao nhiều?", "A. 6,75", "B. 7", "C. 7,5", "D. 9", "D. 9"));
        questionArrayList.add(new Question(
                "Có 1 đàn chuột điếc đi ngang qua hố cống, hỏi có mấy con?", "A. 12", "B. 18", "C. 24", "D. 30", "C. 24"));
        questionArrayList.add(new Question(
                "Cái gì mà đi thì nằm, đứng cũng nằm, nhưng nằm lại đứng?", "A. Cái bàn", "B. Cái ghế", "C. Bàn chân", "D. Bàn tay", "C. Bàn chân"));
        questionArrayList.add(new Question(
                "Bố mẹ có 6 người con trai, mỗi người con trai có một đứa em gái. Vậy gia đình đó có mấy người?", "A. 8", "B. 9", "C. 10", "D. 11", "B. 9"));
        questionArrayList.add(new Question(
                "Chồng người da đen, vợ người da trắng vừa sinh một đứa bé, răng của nó màu gì?", "A. Trắng", "B. Đen", "C. Vàng", "D. Đỏ", "A. Trắng"));
        questionArrayList.add(new Question(
                "Đầu đuôi vuông vắn như nhau. Thân chia nhiều đốt rất mau rất đều. Tính tình chân thực đáng yêu. Muốn biết dài ngắn mọi điều có em. Là cái gì?", "A. Cái thước kẻ", "B. Cái bút chì", "C. Cục tẩy", "D. Cái bảng", "A. Cái thước kẻ"));
        questionArrayList.add(new Question(
                "Cày trên đồng ruộng trắng phau. Khát xuống uống nước giếng sâu đen ngòm. Là cái gì?", "A. Cái cặp sách", "B. Quyển vở", "C. Cái bút mực", "D. Cái bút chì màu", "A. Cái cặp sách"));
        questionArrayList.add(new Question(
                "Hè về áo đỏ như son. Hè đi thay lá xanh non mượt mà. Bao nhiêu tay toả rộng ra. Như vẫy như đón bạn ta đến trường. Là cây gì?", "A. Cây phượng", "B. Cây bằng lăng", "C. Cây bàng", "D. Cây dừa", "A. Cây phượng"));
        questionArrayList.add(new Question(
                "Bằng cái hạt cây. Ba gian nhà đầy còn tràn ra sân. Là cái gì?", "A. Đèn dầu", "B. Bóng đèn", "C. Que diêm", "D. Nước", "A. Đèn dầu"));
        questionArrayList.add(new Question(
                "Anh mặt đen, anh da trắng. Anh mình mỏng, anh nhọn đầu. Khác nhau mà rất thân nhau. Khi đi khi ở chẳng bao giờ rời. Là cái gì?", "A. Bảng và phấn", "B. Giấy và bút", "C. Giấy và cục tẩy", "D. Bảng và bút", "A. Bảng và phấn"));
        questionArrayList.add(new Question(
                "Hạt gieo tới tấp. Rải đều khắp ruộng đồng. Nhưng hạt gieo chẳng nảy mầm. Để bao hạt khác mừng thầm mọc xanh.", "A. Hạt rau", "B. Hạt cát", "C. Hạt mưa", "D. Phân bón", "C. Hạt mưa"));
        questionArrayList.add(new Question(
                "Thân em xưa ở bụi tre. Mùa đông xếp lại mùa hè mở ra. Là cái gì?", "A. Cái quạt giấy", "B. Cái chổi rễ", "C. Cái rổ tre", "D. Không đáp án nào đúng", "A. Cái quạt giấy"));
        questionArrayList.add(new Question(
                "Ao tròn vành vạnh. Nước lạnh như tiền. Con gái như tiên. Trần mình xuống lội", "A. Bánh đa", "B. Bánh trôi nước", "C. Quả hồng ngâm", "D. A & B đúng ", "B. Bánh trôi nước"));
        questionArrayList.add(new Question(
                "Cái dạng quan anh xấu lạ lùng. Khom lưng uốn gối cả đời cong. Lưỡi to ra sức mà ăn khoét. Đành phải theo đuôi có thẹn không?", "A. Cái cuốc", "B. Con trâu", "C. Cái cày", "D. Cái xẻng", "C. Cái cày"));
        questionArrayList.add(new Question(
                "Con gì đạp thì sống không đập thì chết", "A. Con ma", "B. Con tym", "C. Con mắt", "D. Con tim", "D. Con tim"));
        questionArrayList.add(new Question(
                "Vuông vuông cửa đóng 2 đầu 100 thẳng chệt lần hỏi chui ra Thằng nào không mũ thì tha Thằng nào có mũ đem ra đốt đầu ", "A. Que tăm", "B. Que diêm", "C. Que củi", "D. Que kem", "B. Que diêm"));
        questionArrayList.add(new Question(
                "Ở nơi cao nhất trên đầu. Chẳng đen như tóc lại màu đỏ tươi. Lúc khoẻ đẹp như mặt trời. Đến khi đau yếu màu tươi xám dần", "A. Băng đô", "B. Tóc giả", "C. Vòng nguyệt quế", "D. Mào gà", "D. Mào gà"));
        questionArrayList.add(new Question(
                "Bốn chữ đi khắp một đời. Ai sinh ra cũng phải thời trải qua ", "A. Xuân Hạ Thu Đông", "B. Công Dung Ngôn Hạnh", "C. Sinh Lão Bệnh Tử", "D. Môn Đăng Hộ Đối", "C. Sinh Lão Bệnh Tử"));
        questionArrayList.add(new Question(
                "Nơi nào có phố Kỳ lừa có nàng Tô Thị có chùa Tam Thanh ", "A. Chùa Hương", "B. Quảng Bình", "C. Đồng Lộc", "D. Đồng Đăng", "D. Đồng Đăng"));
        questionArrayList.add(new Question(
                "Mặt gì bằng phẳng thênh thang, người đi muôn lối dọc ngang phố phường", "A. Mặt trăng", "B. Mặt trời", "C. Mặt trận", "D. Mặt đất", "D. Mặt đất"));
        questionArrayList.add(new Question(
                "\"Áo đơn áo kép đứng nép bờ ao\" là cây gì? ", "A. Cây tre", "B. Cây chuối", "C. Cây gạo", "D. Cây đa", "B. Cây chuối"));
        questionArrayList.add(new Question(
                "\"Nắng 3 năm ta không bỏ bạn \n Mưa một ngày bạn lại bỏ ta \" ", "A. Cái mũ", "B. Cái áo", "C. Cái bóng", "D. Cây dù", "C. Cái bóng"));
        questionArrayList.add(new Question(
                "Cái gì càng kéo càng ngắn?", "A. Sợi dây", "B. Điếu thuốc", "C. Cao su", "D. Cái ấy", "B. Điếu thuốc"));
        questionArrayList.add(new Question(
                "Một con ngựa bị buộc vào cổ bởi sợi dây 10m. Nhưng cách đó 11m có bụi cỏ xanh mướt. Hỏi con ngựa có ăn được cỏ không", "A. Có", "B. Không", "C. Không biết", "D. Bỏ qua", "A. Có"));
        questionArrayList.add(new Question(
                "Ngày 20 tháng 11 là ngày kỷ niệm nhà giáo Việt Nam. Nước Mỹ có ngày 20 tháng 11 hay không?", "A. Có ", "B. Không", "C. Không biết nữa", "D. Khó quá bỏ qua", "A. Có "));
        questionArrayList.add(new Question(
                "Trong 1 năm, tháng thì có ngày 31, tháng thì có ngày 30, vậy có bao nhiêu tháng có ngày 28?", "A. 1 ", "B.2", " C. 7", "D. 12", "D. 12"));
        questionArrayList.add(new Question(
                "Trung bình 1 người có ít nhất bao nhiêu ngày sinh nhật",  "A. 1  ", "B. Ít nhất 1", "C.2 ", " D.Nhiều hơn 2", "A. 1  "));
        questionArrayList.add(new Question(
                "Điền vào chỗ trống : 1, 2, 3, 5, 8 , (…)", "A. 13", "B. 11", "C. 6  ", " D.15", "A. 13"));
        questionArrayList.add(new Question(
                "Có tất cả 4 trái xoài trên bàn, bạn lấy đi 3, hiện giờ bạn có bao nhiêu quả xoài?", "A. 1", "B. 2", "C. 3", "D. 4", "C. 3"));
        questionArrayList.add(new Question(
                "Điều nầy có hợp lý hay không nếu 1 người đàn ông ở Sài Gòn cưới cô em gái của bà vợ quả phụ của ông ta", "A. Hợp lí", "B. Không hợp lý", "C. Bỏ qua", "D. Tất cả đều đúng", "A. Con người"));
        questionArrayList.add(new Question(
                "Bạn tham dự vào 1 cuộc chạy thi, bạn vượt người thứ 2, vậy vị trí của bạn là thứ mấy?", "A. 1", "B. 3", "C. 2 ", "D. 4", "C. 2 "));
        questionArrayList.add(new Question(
                "Bạn có 1000 cộng thêm 40. Bây giờ bạn cộng thêm 1000 khác. Và giờ thì cộng thêm 30...Cộng thêm 1000 nữa. Cộng thêm 20. Cộng thêm 1000 khác. Cộng thêm 10.Tổng là bao nhiêu vậy? ", "A. 5000 ", "B. 5100", "C. 4100", "D. 3900", "C. 4100"));
        questionArrayList.add(new Question(
                " Lịch nào dài nhất?", "A. Lịch sử", "B. Lịch trình", "C. Lịch thi ", "D. Tất cả đều đúng", "A. Lịch sử"));
        questionArrayList.add(new Question(
                "Đố ai quét sạch quân Đường\n" +
                        "\n" +
                        "Nổi danh Bố Cái Đại Vương thuở nào\n" +
                        "\n" +
                        "Tiếc thay mệnh bạc tài cao\n" +
                        "\n" +
                        "Giang sơn đành phải rơi vào ngoại bang?", "A. Phú Hưng", "B. Khải Định ", "C. Lê Chiêu Thống", "D. Đồng Khánh ", "A. Phú Hưng"));

        this.addAllQuestion(questionArrayList);
    }

    private void addAllQuestion(ArrayList<Question> questionArrayLists) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (Question question: questionArrayLists){
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOpta());
                values.put(OPTB, question.getOptb());
                values.put(OPTC, question.getOptc());
                values.put(OPTD, question.getOptd());
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
        while (cursor.moveToNext()){
            Question question = new Question();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOpta(cursor.getString(2));
            question.setOptb(cursor.getString(3));
            question.setOptc(cursor.getString(4));
            question.setOptd(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionList.add(question);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
        cursor.close();
        database.close();
        return questionList;
    }
}
