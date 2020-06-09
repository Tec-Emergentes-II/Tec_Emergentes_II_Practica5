package com.emergentes.controlador;

import com.emergentes.modelo.Producto;
import com.emergentes.dao.ProductoDao;
import com.emergentes.dao.ProductoDaoImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Eva Carmen Huaylliri Ajata
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {   
                ProductoDao dao = new ProductoDaoImp();
               
               int id;
               // para gestionar los registros 
               Producto pro = new Producto();
                String accion = (request.getParameter("accion")!= null) ? request.getParameter("accion") : "view";
                switch (accion){
                    case "nuevo":
                        request.setAttribute("producto", pro);
                        request.getRequestDispatcher("fromproducto.jsp").forward(request, response);
                    break;
                    case "editar": 
                            id = Integer.parseInt(request.getParameter("id"));
                            pro = dao.getById(id);
                            request.setAttribute("producto", pro);
                            request.getRequestDispatcher("fromproducto.jsp").forward(request, response);
                    break;
                    case "eliminar": 
                            id = Integer.parseInt(request.getParameter("id"));
                            dao.delete(id);
                            response.sendRedirect(request.getContextPath()+"/Inicio");                            
                    break;
                    default:
                        
                        List<Producto> lista = dao.getAll();
                        request.setAttribute("productos", lista);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;           
                }                    
        } catch (Exception e) {
            System.out.println("error "+e.getMessage());;
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductoDao dao = new ProductoDaoImp();
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        Producto pro = new Producto();
        pro.setId(id);
        pro.setDescripcion(descripcion);
        pro.setStock(stock);
        if (id == 0 )
        {         
            try {
                dao.insert(pro);
                response.sendRedirect("Inicio");
            } catch (Exception ex) {
                System.out.println("error "+ex.getMessage());;
            }            
        }
        else
        {
            try {
                dao.update(pro);
                response.sendRedirect("Inicio");
            } catch (Exception ex) {
                System.out.println("error "+ex.getMessage());;
            }
        }           
    }
}
