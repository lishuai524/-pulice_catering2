<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>FreeMarker Web</title>
    <script>
        function ou(o) {
            var dao= document.getElementById("dao")
            if(o == "1"){
                dao.action="/uname/select.do";
            }else{
                dao.action="/uname/output.do";
            }
            dao.submit();
        }
    </script>
</head>
<body>
    主页<a href="/uname/toInsert.do">添加</a>
    <form id="dao" action="#" method="post">
        姓名:<input type="text" name="name"/>
        工作:<input type="text" name="job"/>
        职务:<select name="did">
        <option value="0">请选择</option>
        <#list udeptList as d>
            <option value="${d.id}">${d.dept}</option>
        </#list>
    </select>
        <input type="button" onclick="ou('1')" value="查询"/>
        <input type="button" onclick="ou('2')" value="导出"/>
    </form>
    <form action="/uname/input.do" method="post" enctype="multipart/form-data">
        <input type="file" name="file"/>
        <input type="submit" value="导入"/>
    </form>
    <table border="1">
        <tr><td>姓名</td><td>工作</td><td>职务</td><td>操作</td></tr>
        <#list unameList as u>
            <tr><td>${u.name}</td><td>${u.job}</td><td>${u.udept.dept}</td><td><a href="/uname/toUpdate.do?id=${u.id}">修改</a><a href="/uname/delete.do?id=${u.id}">删除</a></td></tr>
        </#list>
    </table>
    <a href="/uname/select.do">首页</a>
    <a href="/uname/select.do?currentPage=<#if uPage.currentPage-1 lt 1>
        ${uPage.currentPage}
        <#else>
            ${uPage.currentPage-1}
    </#if>">《上一页</a>
<#--    <c:forEach items="${totalPage}" var="total" varStatus="ind">
        <a href="/uname/select.do?currentPage=${ind.index+1}">${ind.index+1}</a>
    </c:forEach>-->
    <a href="/uname/select.do?currentPage=<#if uPage.currentPage+1 lt 1>
        ${uPage.currentPage}
        <#else>
            ${uPage.currentPage+1}
    </#if>">下一页》</a>
    第${uPage.currentPage}页&nbsp&nbsp&nbsp共${uPage.totalPage}页
    <a href="/uname/select.do?currentPage=${uPage.totalPage}">尾页</a>
</body>
</html>