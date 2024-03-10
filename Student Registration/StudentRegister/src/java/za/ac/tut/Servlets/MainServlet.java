/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.SessionBeans.StudentFacade;
import za.ac.tut.entities.Student;


/**
 *
 * @author frans
 */
public class MainServlet extends HttpServlet {

    @EJB
    StudentFacade studentFacade;

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
        response.setContentType("text/html;charset=UTF-8");
        
        //Select a button
        String SelectButton = request.getParameter("Request");
        //call output method
        PrintWriter out = response.getWriter();
        
        //Get the data from a database
        String studentNo = request.getParameter("studenno");
        long studenno = Long.parseLong(studentNo); //convert to long
        
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String contactNo = request.getParameter("contactno");
        String email = request.getParameter("email");
        String degree = request.getParameter("degree");
        
        
        //which button is selected
        if (SelectButton.equalsIgnoreCase("Register"))
        {
            //Instatiate the student object
            Student objStudent = new Student();
            //Create a values to the database
            objStudent.setStudenno(studenno);
            objStudent.setFirstname(firstName);
            objStudent.setLastname(lastName);
            objStudent.setContactno(contactNo);
            objStudent.setEmail(email);
            objStudent.setDegree(degree);

            studentFacade.create(objStudent); //Send the input data to the database
            out.println("<h1>Sudent successfully registered</h1>");
        }else if (SelectButton.equalsIgnoreCase("View List"))
        {
            //find the records and display   
            //fubd al froom database
            List<Student> StudentList = studentFacade.findAll();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Display Records</h1>");
            out.println("<table>");
            for(Student student : StudentList)
            {
                out.println("<tr>");
                out.println("<td>"+student.getStudenno() +"</td><td>"+ student.getFirstname() +"</td><td>"+ student.getLastname() +"</td><td>"+student.getDegree() +"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
