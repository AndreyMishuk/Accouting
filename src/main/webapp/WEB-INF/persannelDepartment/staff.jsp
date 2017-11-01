<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h1>Hello staf</h1>

<p>ListUser is : ${nameUser}</p>
<div id="block-add">

    <form action="staff" method="Post">
        <p id="text-addUser">
            add user<input class="button-staf" id="batton-add" type="submit" value="add" name ="addButton">
        </p>
    </form>
</div>
<div class="blok_skrol-staf">

    <table class="table-staf">
        <thead>
            <tr class="tr_head-staf">
                <th id="th_id">ID</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Должность</th>
                <th>Категория</th>
                <th>Оклад</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${listUsers}">
                <tr class="tr_body-staf">

                    <td class="td-staf" align="center">
                        <form method="Post" action="staff">
                            <input name="userId" type="submit" value="${user.userId}">
                        </form>
                    </td>
                    <td>${user.userSurname}</td>
                    <td>${user.userName}</td>
                    <td>${user.userMiddleName}</td>
                    <td>${user.post.post}</td>
                    <td>${user.workCategory.category}</td>
                    <td>${user.post.salary}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>


<c:if test="${lPost != null}">
    <div class="block_editor-staf">
        <h2><p>ADD user</p></h2>
        <form method="Post" action="staff">
            <table class="table-staf">
                <thead>
                    <tr class="tr_head-staf">
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Отчество</th>
                        <th>Должность</th>
                        <th>Категория</th>
                    </tr>
                </thead>
                <tbody>
                <td><input type="text" name="surnameAdd"  value=""></td>
                <td><input type="text" name="nameAdd" value=""></td>
                <td><input type="text" name="middlenameAdd"  value=""></td>
                <td><select class="select" size="1" name="postAdd" >
                        <c:forEach var="post" items="${lPost}">
                            <option  value="${post.postId}">${post.post}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><select class="select" size="1" name="categoryAdd">
                        <c:forEach var="category" items="${lCategory}">
                            <option value="${category.categoryId}">${category.category}</option>   
                        </c:forEach>
                    </select></td>

                </tbody>
            </table>
            <input class="button-staf" type="submit" value="add" name="addRedact">
        </form>
    </div>
</c:if>

<c:if test="${listOneUser != null}">
    <div class="block_editor-staf">
        <h2><p>Editor</p></h2>
        <form method="Post" action="staff">
            <table class="table-staf">
                <thead>
                    <tr class="tr_head-staf">
                        <th>ID</th>
                        <th>Фамилия</th>
                        <th>Имя</th>
                        <th>Отчество</th>
                        <th>Должность</th>
                        <th>Категория</th>
                        <th>Оклад</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${listOneUser}">
                    <td><input type="text" readonly="readonly" name="id" size="1" value="${user.userId}"></td>
                    <td><input type="text" name="surname" size="25" value="${user.userSurname}"></td>
                    <td><input type="text" name="name" size="25" value="${user.userName}"></td>
                    <td><input type="text" name="middlename" size="25" value="${user.userMiddleName}"></td>
                    <td><select class="select" size="1" name="post" >
                            <option style="color: #008000"  value="${user.post.postId}">${user.post.post}</option>
                            <c:forEach var="post" items="${listPost}">
                                <option  value="${post.postId}">${post.post}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><select class="select" size="1" name="category">
                            <option style="color: #008000" value="${user.workCategory.categoryId}">${user.workCategory.category}</option>
                            <c:forEach var="category" items="${listCategory}">
                                <option value="${category.categoryId}">${category.category}</option>   
                            </c:forEach>
                        </select>
                    </td>
                    <td><input type="text" readonly="readonly" name="middlename" size="25" value="${user.post.salary}"></td>
                    </c:forEach>
                </tbody>
            </table>

            <input class="button-staf" type="submit" value="remove" name="remove">
            <input class="button-staf" type="submit" value="edit" name="edit">



        </form>

    </div>
</c:if>