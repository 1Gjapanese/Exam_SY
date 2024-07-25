<%-- 科目削除JSP --%>
<%@page language="java" contentType="text/html; charset-UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
	<c:param name="title">得点管理システム</c:param>
	<c:param name="scripts"></c:param>
	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目情報削除</h2>
			<form action="SubjectDeleteExecute.action" method="post">
				<div class="mb-3">
					<input type=hidden name="cd" value="${subject_date.cd}">
					<label class="form-label" for="subject-cd-input">
					「${subject_date.name}(${subject_date.cd})」を削除してもよろしいですか</label>
				</div>
					<input type="submit" value="削除">
				<br>
				<a href="SubjectList.action">戻る</a>
			</form>
		</section>
	</c:param>
</c:import>