<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2-heading">User Profile. Login: ${user.login}</div>
<div class="form-style-2 label">First name: ${user.firstName}; Last name: ${user.lastName}</div>
<div class="form-style-2 label">State: ${user.state}; Role: ${user.role}</div>
<div class="form-style-2 label">Money: ${bill}$</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Checks:
    </div>
    <table>
        <tr>
            <th>User</th>
            <th>Biller</th>
            <th>Amount</th>
        </tr>
    <#list checks as check>
        <tr>
            <td>${check.user.login}</td>
            <td>${check.bill.accountHolder.login}</td>
            <td>${check.amount}</td>
        </tr>
    </#list>
    </table>
</div>



<a href="/logout">Выход</a>
</body>
</html>