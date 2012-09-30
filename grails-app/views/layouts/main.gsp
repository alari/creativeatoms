<!DOCTYPE html>
<html ng-app="ca.app">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>{{title}}<g:layoutTitle/></title>
    <r:require modules="custom-bootstrap,ca-app,angular-bootstrap"/>
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body ng-controller="LayoutCtr">

<div class="container">

    <div class="navbar">
        <div class="navbar-inner">
            <a class="brand" href="/">Mirari</a>
            <ul class="nav">
                <li ng-repeat="pile in corePiles"><a ng-href="{{pile.title}}">{{pile.title}}</a></li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="span10 offset2">
            <ul class="breadcrumb">
                <li ng-repeat="step in steps">{{step}}</li>
            </ul>
        </div>
    </div>

    <div class="row">
        <div class="span2">
            <div>
                <ul class="nav nav-tabs nav-stacked">
                    <li ng-repeat="pile in relatedPiles">{{pile}}</li>
                </ul>
            </div>
            <div class="well">
                <ul class="nav nav-list">
                    <li ng-repeat="nav in relatedNav">{{nav}}</li>
                </ul>
            </div>
        </div>
        <div class="span10">
            <g:layoutBody/>
        </div>
    </div>

    <div class="navbar">
        <div class="navbar-inner">
            <ul class="nav">
                <li ng-repeat="site in relatedSites"><a ng-href="{{site.title}}">{{site.title}}</a></li>
            </ul>
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