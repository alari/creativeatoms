<%--
  By alari
  Since 9/1/12 9:35 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title>Blocks main</title>
</head>

<body>

<g:form method="post" controller="restCreativeAtom" action="create" enctype="multipart/form-data">
    <g:field type="file" name="file" placeholder="file"/>
    <g:submitButton name="sbm"/>
</g:form>

<hr/>

<div ng-app="CreativeAtom" ng-controller="CreativeAtomCtr">
    <fieldset>
        <input placeholder="title" ng-model="newAtom.title"/>
        <input placeholder="external url" ng-model="newAtom.externalUrl"/>
        <textarea ng-model="newAtom.text"></textarea>
        <button ng-click="push()">Submit</button>
    </fieldset>

    <div ng-repeat="atom in atoms">
        <div ng-include src="'/html/atom/'+atom.type+'.html?5'"></div>
    </div>
</div>

</body>
</html>