<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>
<style type="text/css">
    table {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        width: 100%;
        border-collapse: collapse;
    }

    td, th {
        font-size: 1em;
        border: 1px solid #5B4A42;
        padding: 3px 7px 2px 7px;
    }

    th {
        font-size: 1.1em;
        text-align: center;
        padding-top: 5px;
        padding-bottom: 4px;
        background-color: #24A9E1;
        color: #ffffff;
    }
</style>
<body>
<div id="saHistoryData">
    工厂：${factory} <br/>
    用户-年龄：${name} + ${age} <br/>
    用户-年龄2：${name}${age} <br/>

    <#assign factoryOther="${(!(factory=='WH'||factory=='JAG'||factory=='Manaus'||factory=='ARG'||factory=='IN'))?c}" />

    <input type="checkbox" ${(factory=='WH')?string('checked','')} name="WH" value="WH"
           style="outline: none;">WH</input>

    <input type="checkbox" ${(factory=='JAG')?string('checked','')} name="JAG" value="JAG"
           style="outline: none;">JAG</input>

    <br/>factoryOther：${factoryOther} <br/>
    <input type="checkbox" ${(factoryOther=='true')?string('checked','')} name="Other"
           value="Other" style="outline: none;">Other</input>
    <span style="height: 18px;
                display: inline-block;
                border-bottom: 1px solid #333;
                width: 50px;">${(factoryOther=='true')?string(factory,'')}</span>

    <br/><span style="height: 18px;display: inline-block;border-bottom: 1px solid #333;width: 50px;">
        <#-- expiration + expiration_unit 这里，中间不加 + 号会报错 -->
                    ${(expiration_type=='短期-限时'||expiration_type=='短期-限量')?string(expiration + expiration_unit,"")}</span></input>

</div>
<br/>
此邮件由系统自动生成，请勿回复!<br/>
This message is automatically generated by the system, please do not reply!
</body>
</html>