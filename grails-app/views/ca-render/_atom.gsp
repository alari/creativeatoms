<div>
    <g:if test="${atom.title}"><h2>{{atom.title}}</h2></g:if>
    <g:render template="${atom.type}" model="[atom: atom]"/>
</div>