package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class SubjectCreateAction extends Action{

	//オーバーライド
	public void execute(HttpServletRequest req,
			HttpServletResponse res)throws Exception{

	//JSPへフォワード
		req.getRequestDispatcher("subject_create.jsp").forward(req,res);
	}
}