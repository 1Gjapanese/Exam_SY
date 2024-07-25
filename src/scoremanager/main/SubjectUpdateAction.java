package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action{

	//オーバーライド
		public void execute(HttpServletRequest req,
				HttpServletResponse res )throws Exception{

	//処理内容(シーケンス図から)
		//シ:科目の詳細データを取得
			HttpSession session = req.getSession();//セッション開始
			Teacher teacher = (Teacher)session.getAttribute("user");
			String cd = req.getParameter("cd");//変更対象の科目コードの取得
			SubjectDao sDao = new SubjectDao();
			Subject sub = sDao.get(cd,teacher.getSchool());//変更対象の科目詳細データを取得

		//シ:画面表示
			req.setAttribute("subject_date",sub);//科目の詳細データ
			//JSPへフォワード
			req.getRequestDispatcher("subject_update.jsp").forward(req,res);
		}
}