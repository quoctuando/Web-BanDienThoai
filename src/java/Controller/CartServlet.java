/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SanPhamDao;
import Model.item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("view")){
            //my-code
            doGet_DisplayCart(request,response);
        }
        else
        {
            if (action.equalsIgnoreCase("buy")){
                //my-code
                doGet_Buy(request,response);
            }
            else if(action.equalsIgnoreCase("remove")){
                //my-code
                doGet_Remove(request,response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		List<item> cart = (List<item>) session.getAttribute("cart");
		int index = isExisting(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect(request.getContextPath() + "/cart.jsp");
	}
    protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPhamDao spd = new SanPhamDao();
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        if (session.getAttribute("cart") == null) {
            List<item> cart = new ArrayList<item>();
            cart.add(new item(spd.getSanPham(id), 1));
            session.setAttribute("cart", cart);
        } else {
            List<item> cart = (List<item>) session.getAttribute("cart");

            int index = isExisting(id, cart);
            if (index == -1) {
                cart.add(new item(spd.getSanPham(id), 1));
            } else {
                int quantity = cart.get(index).getSoluong() + 1;
                cart.get(index).setSoluong(quantity);
            }
            session.setAttribute("cart", cart);
        }
        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
    private int isExisting(int id, List<item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getSp().getId()== id) {
                return i;
            }
        }
        return -1;
    }
}
