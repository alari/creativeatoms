<%--
  By alari
  Since 9/1/12 9:35 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta content="main" name="layout">
    <title>Blocks main</title>
    <r:require modules="jquery-file-upload,angular-ui"/>
</head>

<body>

<div ng-app="CreativeAtom" ng-controller="CreativeAtomCtr">

    <fieldset>
        <input type="file" name="file" data-url="/rest/creativeAtom" ui-jq="fileupload" ui-options="{dataType:'json',add:pushFile,done:fileDone}" />
        <input placeholder="title" ng-model="newAtom.title"/>
        <input placeholder="external url" ng-model="newAtom.externalUrl"/>
        <textarea ng-model="newAtom.text"></textarea>
        <button ng-click="push()">Submit</button>
    </fieldset>

    <div ng-repeat="atom in atoms">
        <div ng-include src="'/html/atom/'+atom.type+'.html'"></div>
    </div>
</div>

</body>
</html>