<!doctype html>
<html>
<head>
   <#include "include/common.header.ftl" >
    <script type="text/javascript" src="${ctx}/js/cus.dev.plan.js"></script>
</head>
<body style="margin: 1px">
<table id="dg" title="客户开发计划管理" class="easyui-datagrid"
       fitColumns="true" pagination="true" rownumbers="true"
       url="${ctx}/sale_chance/list?state=1&sort=id.desc" fit="true" toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">编号</th>
        <th field="chanceSource" width="200" align="center" hidden="true">机会来源</th>
        <th field="customerName" width="80" align="center">客户名称</th>
        <th field="cgjl" width="50" align="center" hidden="true">成功几率</th>
        <th field="overview" width="150" align="center">概要</th>
        <th field="linkMan" width="80" align="center">联系人</th>
        <th field="linkPhone" width="100" align="center" hidden="true">联系电话</th>
        <th field="description" width="200" align="center" hidden="true">机会描述</th>
        <th field="createMan" width="80" align="center">创建人</th>
        <th field="createDate" width="150" align="center">创建时间</th>
        <th field="assignMan" width="50" align="center" >指派人</th>
        <th field="assignTime" width="150" align="center" >指派时间</th>
        <th field="devResult" width="100" align="center" formatter="formatDevResult">客户开发状态</th>
        <th field="a" width="100" align="center" formatter="formatAction">操作</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;客户名称：&nbsp;<input type="text" id="s_customerName" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
        &nbsp;概要：&nbsp;<input type="text" id="s_overview" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
        &nbsp;客户开发状态：&nbsp;<select class="easyui-combobox" id="s_devResult" editable="false" panelHeight="auto" >
        <option value="">请选择...</option>
        <option value="0">未开发</option>
        <option value="1">开发中</option>
        <option value="2">开发成功</option>
        <option value="3">开发失败</option>
    </select>
        <a href="javascript:searchSaleChance()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>


</body>
</html>