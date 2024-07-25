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

public class SubjectUpdateExecuteAction extends Action{

	//オーバーライド
	public void execute(HttpServletRequest req,
		HttpServletResponse res)throws Exception{
		HttpSession session = req.getSession();//セッション開始

		Teacher teacher = (Teacher)session.getAttribute("user");

		//リクエストバラメーターの取得()
		String cd = req.getParameter("cd");//科目コード
		String name = req.getParameter("name");//科目名

		Map<String, String> errors = new HashMap<>(); // エラーメッセージ
		SubjectDao sDao = new SubjectDao();
		Subject judge = sDao.get(cd,teacher.getSchool());

		if (judge == null){
			req.setAttribute("cd", cd);
			req.setAttribute("name", name);
			errors.put("cd", "科目が存在していません");
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("subject_update.jsp").forward(req, res);

		} else {
		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());
		sDao.save(subject);

		//JSPへフォワード(登録完了)
		req.getRequestDispatcher("subject_update_done.jsp").forward(req,res);
		}
	}
}