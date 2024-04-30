<%@page import="org.hibernate.Transaction"%>
<%@page import="configuration.HibernateUtility"%>
<%@page import="org.hibernate.Session"%>
<%@page import="model.Teacher"%>
<%@page import="model.EQualification"%>
<%@page import="java.util.*"%>
<%@page import="java.util.List"%>
<%@page import="dao.TeacherDao"%>

<%
    String name = request.getParameter("name");
    String code = request.getParameter("code");
    String qualificationStr = request.getParameter("teacherType");
    EQualification qualification = EQualification.valueOf(qualificationStr);
    System.out.println("Hi");
    Teacher teacher = new Teacher(code, name, qualification, new HashSet<>());
    /* Teacher teacher = new Teacher(code, name, qualification, new ArrayList<>()); */
    System.out.println("Hi");
    TeacherDao dao = new TeacherDao();
    dao.registerTeacher(teacher);
    System.out.println("Hi");
    response.sendRedirect("displayTeacher.jsp");

   /*  try (Session session = HibernateUtility.getSession().openSession()) {
        Transaction transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();
        out.println("Teacher registered successfully!");
    } catch (Exception e) {
        e.printStackTrace();
        out.println("Error registering teacher: " + e.getMessage());
    } */
%>