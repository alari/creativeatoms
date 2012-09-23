<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
        <r:require modules="ca-app"/>
	</head>
	<body>

    <div ng-app="ca.app" ng-controller="CreativeAtomCtr" ng-include src="'${r.resource(plugin:'infra-ca', uri: 'html/root.html')}'">
    </div>

	</body>
</html>
