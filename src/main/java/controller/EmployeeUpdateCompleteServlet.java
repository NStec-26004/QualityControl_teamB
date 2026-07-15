package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dto.Employee;

/**
 * P014【社員更新完了画面】用 コントローラー<br>
 * URL: /empupdatecomp
 *
 * @author Fullness, Inc.
 *
 */
@WebServlet("/empupdatecomp")

public class EmployeeUpdateCompleteServlet extends HttpServlet {

    /**
     * P014【社員更新完了画面】用 コントローラー<br>
     * URL: /empupdatecomp
     *
     * @author Fullness, Inc.
     *
     */

    /**
     * 社員更新完了画面を表示<br>
     * セッションに社員の値が保存されていない場合、エラーメッセージをセッションに保存してメニュー画面にリダイレクト
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        Employee employee = (Employee) session.getAttribute("delEmpComplete");
        if (employee == null) {
            session.setAttribute("illegalOperationMsg", "不正な操作です");
            resp.sendRedirect("menu");
        }
        session.setAttribute("empDeletedFlg", true);

        session.removeAttribute("delEmpComplete");
        req.setAttribute("delEmpCompleteViewData", employee);
        req.getRequestDispatcher("WEB-INF/jsp/employee/delete/employeedeletecomplete.jsp").forward(req, resp);
        return;

    }
}
