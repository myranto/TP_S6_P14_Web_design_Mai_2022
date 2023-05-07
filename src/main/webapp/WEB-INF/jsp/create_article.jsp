<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.springmvc_v_finale.model.Category" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Myranto
  Date: 17/03/2023
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create article page</title>
    <link rel="stylesheet" href="<c:url value='/ressources/theme/bootstrap/css/bootstrap.min.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/fonts/font-awesome.min.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/css/Login-Form-Basic-icons.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/css/Sidebar-Menu-sidebar.css' />">
    <link rel="stylesheet" href="<c:url value='/ressources/theme/css/Sidebar-Menu.css' />">
</head>
<body>
<%
    ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("list");
%>
<div class="card">
    <div class="card-header">
        <div id="wrapper">

            <div class="page-content-wrapper">
                <div class="container-fluid"><a class="btn btn-link" role="button" id="menu-toggle" href="#menu-toggle"><i class="fa fa-bars"></i></a>
                    <div class="row">
                        <div class="col-md-12">
                            <div>

                                <form action="<%= request.getContextPath() %>/save" method="post">
                                    <p>nom de l'article : <input name="name" type="text" required />
                                    <p>
                                       category:
                                        <select name="idcategory">
                                            <option value="vide">choisir category</option>
                                            <% for (Category d : list) { %>
                                            <option value="<%= d.getIdcategory() %>"><%= d.getName_category() %>
                                            </option>
                                            <% } %>
                                        </select>
                                    </p>
                                    <p>Description : <textarea name="description" rows="6" cols="40" placeholder="Enter your text here..."></textarea>
                                    </p>
                                    <p>image :
                                        <input class="form-control" type="file" class="form-control" id="selectImage" name="images">
                                        <input type="hidden" name="image" id="imageCode">
                                    </p>
                                    <p>content :
                                        <textarea id="contenu" name="content"></textarea><br><br>
                                    </p>
                                    <input type="submit" value="enregistrer">
                                </form>
                                	<a href="<%= request.getContextPath() %>/test %>">ExporterPDf</a>

 <script src="<c:url value='/ressources/theme/ckeditor.js' />"></script>
                              <script>
                                ClassicEditor
                                  .create( document.querySelector('#contenu'))
                                  .catch( error => {
                                      console.error( error );
                                  } );
                              </script>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
    const input = document.getElementById("selectImage");
    const imageCode = document.getElementById("imageCode");
    const convertBase64 = (file) => {
        return new Promise((resolve, reject) => {
            const fileReader = new FileReader();
            fileReader.readAsDataURL(file);
            fileReader.onload = () => {
                resolve(fileReader.result);
            };
            fileReader.onerror = (error) => {
                reject(error);
            };
        });
    };
    const uploadImage = async (event) => {
        const file = event.target.files[0];
        const base64 = await convertBase64(file);
        imageCode.value = base64;
        console.log(imageCode.value);
    };
    input.addEventListener("change", (e) => {
        uploadImage(e);
    });
</script>
</body>
</html>
