<%--
  By alari
  Since 9/1/12 9:35 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Blocks main</title>
</head>
<body>

<g:form method="post" controller="blocks" action="create" enctype="multipart/form-data">
    <g:field type="text" name="title"/>
    <g:field type="text" name="externalUrl"/>
    <g:submitButton name="sbm"/>
</g:form>

<hr/>

<g:each in="${blocks}" var="block">
    <div>
        <h1>${block.title}</h1>
        <h2>${block.type}</h2>
        <pre>${block.data}</pre>
    </div>
    <hr/>
</g:each>

</body>
</html>