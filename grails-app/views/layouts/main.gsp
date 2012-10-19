<!DOCTYPE html>
<html ng-app="ca.app">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>{{title}}<g:layoutTitle/></title>
    <r:require modules="custom-bootstrap,ca-app,angular-bootstrap,bootstrap-modal"/>
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body ng-controller="LayoutCtr">

<div class="container">

    <div class="navbar">
        <div class="navbar-inner">
            <a class="brand" href="/">Mirari</a>
            <ul class="nav">
                <li><a ng-href="/">root pile is static</a></li>
            </ul>
            <span ng-controller="AuthCtr">
                <ul class="nav">
                    <li ui-if="!isAuthenticated"><a data-toggle="modal" href="#regModal">Регистрация</a></li>
                    <li ui-if="!isAuthenticated"><a data-toggle="modal" href="#signInModal">Вход</a></li>
                    <li ui-if="isAuthenticated"><a ng-click="signOut()">Выйти</a></li>
                </ul>

                <div ui-if="!isAuthenticated" ng-include src="'/html/auth/signUp.html'"></div>

                <div ui-if="!isAuthenticated" ng-include src="'/html/auth/signIn.html'"></div>
            </span>
        </div>
    </div>

    <div class="row">
        <div class="span12">
            <g:layoutBody/>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container">
        footer
    </div>
</footer>

<r:layoutResources/>
</body>
</html>