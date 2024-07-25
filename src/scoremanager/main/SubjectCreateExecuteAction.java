package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction extends Action{

	//オーバーライド
	public void execute(HttpServletRequest req,
		HttpServletResponse res)throws Exception{
		HttpSession session = req.getSession();//セッション開始
		Teacher teacher = (Teacher)session.getAttribute("user");
		Map<String, String> errors = new HashMap<>(); // エラーメッセージ

		//リクエストバラメーターの取得()
		String cd = req.getParameter("cd");//科目コード
		String name = req.getParameter("name");//科目名

		SubjectDao sDao = new SubjectDao();
		Subject judge = sDao.get(cd,teacher.getSchool());

	// 科目コードが3文字ではない時
		if (cd.length() != 3) {
			req.setAttribute("cd", cd);
			req.setAttribute("name", name);
			errors.put("cd", "科目コードは3文字で入力してください");
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("subject_create.jsp").forward(req, res);
	// 科目コードの重複がある場合
		} else if (judge != null){
			req.setAttribute("cd", cd);
			req.setAttribute("name", name);
			errors.put("cd", "科目コードが重複しています");
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("subject_create.jsp").forward(req, res);
		} else {
			//Subjectへ登録するデータをセット
			Subject subject = new Subject();
			subject.setCd(cd);
			subject.setName(name);
			subject.setSchool(teacher.getSchool());
			sDao.save(subject);
				}

		//JSPへフォワード(登録完了)
		req.getRequestDispatcher("subject_create_done.jsp").forward(req,res);
	}
}