<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav>
        <ul>
            <li class="navigatie-link"><a href="Controller?command=Home">Home</a></li>
            <li class="navigatie-link"><a href="Controller?command=userOverview">Users</a></li>
            <li class="navigatie-link"><a href="Controller?command=registerPage">Register</a></li>
            <c:if test="${sessionScope.user!=null}">

                <li class="navigatie-link"><a href="Controller?command=projectOverview">Project</a></li>
            </c:if>
            <c:if test="${sessionScope.user!=null && sessionScope.user.role != 'EMPLOYEE'}">

                <li class="navigatie-link"><a href="Controller?command=addProjectPage">Add project</a></li>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <li class="navigatie-link"><a href="Controller?command=workOrderOverviewPage">Work order</a></li>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <li class="navigatie-link"><a href="Controller?command=addWorkOrderPage">Add work order</a></li>
            </c:if>
        </ul>

    </nav>

</header>
