package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction extends Action {
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		SubjectDao dao=new SubjectDao();
		List<Subject> list=dao.filter(teacher.getSchool());

		request.setAttribute("subjects", list);
		//JSPへフォワード
		request.getRequestDispatcher("subject_list.jsp").forward(request,response);
	}
}