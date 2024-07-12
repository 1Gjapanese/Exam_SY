package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action{

	//オーバーライド
	public void execute(HttpServletRequest req,
			HttpServletResponse res)throws Exception{

	//処理内容(シーケンス図から)
		//シ:セッションデータを取得
		HttpSession session= req.getSession();//セッション開始
		Teacher teacher = (Teacher)session.getAttribute("user");

	//シ:セレクトボックス用のクラス番号一覧の取得
		ClassNumDao class_num = new ClassNumDao();
		List<String> class_list = class_num.filter(teacher.getSchool());

	//student_create.jspの入学年度リストの取得
		LocalDate todaysDate = LocalDate.now();//LocalDateインスタンスを取得
		int year = todaysDate.getYear();//現在の年を取得
		//リストを初期化
		List<Integer> entYearSet = new ArrayList<>();
		//10年前から10年後まで年をリストに追加
		for(int i = year - 10;i < year + 11; i++){
			entYearSet.add(i);
		}
		//レスポンス値をセット
		//リクエストに入学年度をセット
		req.setAttribute("ent_year_set",entYearSet);

	//リクエストにデータをセット
		req.setAttribute("class_select",class_list);

	//JSPへフォワード
		req.getRequestDispatcher("student_create.jsp").forward(req,res);
	}
}