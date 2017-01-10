import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCart extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		cart shoppingCart;
		shoppingCart = (cart) session.getAttribute("cart");
		if (shoppingCart == null) {
			shoppingCart = new cart();
			session.setAttribute("cart", shoppingCart);
		}
		String name = request.getParameter("name");
		Integer price = Integer.parseInt(request.getParameter("price"));
		shoppingCart.addToCart(name, price);
		session.setAttribute("cart", shoppingCart);
		try (PrintWriter out = response.getWriter()) {

			HashMap<String, Integer> items = shoppingCart.getCartItems();
			out.println("<table border='1px'>");

			for (String key : items.keySet()) {
				out.println("<tr><td>" + key + " - </td><td>" + "$" + items.get(key) + "</td></tr>");
			}

		}
	}
}
