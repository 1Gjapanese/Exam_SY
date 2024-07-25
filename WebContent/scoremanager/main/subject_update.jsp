<%-- 科目変更JSP --%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="scripts"></c:param>
	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報変更</h2>
			<form action="SubjectUpdateExecute.action" method="post">
				<div class="mb-3">
					<label class="form-label" for="subject-cd-input">科目コード</label>
					<input readonly class="form-control-plaintext ms-3" type="text"
						id="student-no-input" name="cd" value="${subject_date.cd}" />
				</div>
				<div class="form-group mt-2 text-warning">${errors.get("cd")}</div>
				<label>科目名</label>
					<input type="text" name="name" value="${subject_date.name}" maxlength="20" required >
				<br>
					<input type="submit" value="変更">
				<br>
				<a href="SubjectList.action">戻る</a>
			</form>
		</section>
	</c:param>
</c:import>