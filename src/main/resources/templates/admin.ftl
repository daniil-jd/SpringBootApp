<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2-heading">Admin Page</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already in System!
    </div>
    <table>
        <tr>
            <th>Login</th>
            <th>Role</th>
            <th>State</th>
            <th>Money</th>
        </tr>
    <#list usersFromServer as user>
        <tr>
            <td>${user.login}</td>
            <td>${user.role}</td>
            <td>${user.state}</td>
            <td>${user.bill.money}$</td>
        </tr>
    </#list>
    </table>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        All Checks:
    </div>
    <table>
        <tr>
            <th>User</th>
            <th>Biller</th>
            <th>Amount</th>
        </tr>
    <#list allChecks as check>
        <tr>
            <td>${check.user.login}</td>
            <td>${check.bill.accountHolder.login}</td>
            <td>${check.amount}$</td>
        </tr>
    </#list>
    </table>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Add new Check:
    </div>
    <form method="post" action="/admin">
        <label for="userLogin">User Login
            <input class="input-field" type="text" id="userLogin" name="userLogin">
        </label>
        <br>
        <label for="billerLogin">Biller Login
            <input class="input-field" type="text" id="billerLogin" name="billerLogin">
        </label>
        <br>
        <label for="amount">Amount
            <input class="input-field" type="text" id="amount" name="amount">
        </label>

        <input type="submit" value="Add">
        <br>
    </form>
</div>

<a href="/logout">Выход</a>
</body>
</html>