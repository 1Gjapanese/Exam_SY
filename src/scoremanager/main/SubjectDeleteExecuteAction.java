package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Subject;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action{

	//オーバーライド
	public void execute(HttpServletRequest req,
		HttpServletResponse res)throws Exception{

		String cd = req.getParameter("cd");//科目コード

		Subject subject = new Subject();
		subject.setCd(cd);

		SubjectDao sDao = new SubjectDao();
		sDao.delete(subject);

		//JSPへフォワード(登録完了)
		req.getRequestDispatcher("subject_delete_done.jsp").forward(req,res);
		}
}