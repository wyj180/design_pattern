<html>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
</head>

<body>

<div>
	<ul>
		<li>Supplier :    <b>${info.odm_supplier!}</b></li>
		<li>project:   <b>${info.project!}</b></li>
		<li>part:   <b>${info.part!}</b></li>
	</ul>
</div>

<#if itemGroups??>
	<div>
		Dear all,<br>

		Here comes the list of sample(s) taking effective today, please be noted, thanks.<br><br>

		<#-- 获取map中所有的key -->
		<#list itemGroups?keys as supplierName>
			<span>Supplier: ${supplierName!} <br></span>
			<#list itemGroups[supplierName]?keys as sampleCategory>
				Sample category :  ${sampleCategory!}
				<#if sampleCategory == "Limit Sample">
					<table style="border-spacing: 0;border: 1px solid #333;border-collapse: collapse;font-size: 12px;">
						<tr style="height: 30px;text-align: center; background-color: #24A9E1"">
						<th style="border: 1px solid #333;width: 125px;">ODM</th>
						<th style="border: 1px solid #333;width: 125px;">项目名</th>
						<th style="border: 1px solid #333;width: 125px;">样品编号</th>
						<th style="border: 1px solid #333;width: 125px;">样品属性</th>
						<th style="border: 1px solid #333;width: 125px;">部件</th>
						<th style="border: 1px solid #333;width: 125px;">部件良率</th>
						<th style="border: 1px solid #333;width: 125px;">颜色</th>
						<th style="border: 1px solid #333;width: 125px;">缺陷名称</th>
						<th style="border: 1px solid #333;width: 125px;">缺陷描述</th>
						<th style="border: 1px solid #333;width: 125px;">缺陷不良率</th>
						<th style="border: 1px solid #333;width: 125px;">PE签样人</th>
						<th style="border: 1px solid #333;width: 125px;">CXD签样人</th>
						<th style="border: 1px solid #333;width: 125px;">PQM签样人</th>
						<th style="border: 1px solid #333;width: 125px;">Other签样人</th>
						<th style="border: 1px solid #333;width: 125px;">签样日期</th>
						<th style="border: 1px solid #333;width: 125px;">分发工厂</th>
						<th style="border: 1px solid #333;width: 125px;">有效期</th>
						<th style="border: 1px solid #333;width: 125px;">存档时间</th>
						</tr>
						<#list itemGroups[supplierName][sampleCategory] as item>
							<tr style="height: 30px;text-align: left;">
								<td style="border: 1px solid #333;width: 125px;">${item.odm_supplier!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.project!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_id!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_type!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.part!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.fpy!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.color!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.bug_name!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.bug_desc!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.ratio!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_pe!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_cxd!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_pqm!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_other!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_date!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.factory!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.expiration_type!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_date!}</td>
							</tr>
						</#list>
					</table>
					<br/>
				</#if>

				<#if sampleCategory == "Golden Sample">
					<table style="border-spacing: 0;border: 1px solid #333;border-collapse: collapse;font-size: 12px;">
						<tr style="height: 30px;text-align: center; background-color: chocolate">
							<th style="border: 1px solid #333;width: 125px;">ODM</th>
							<th style="border: 1px solid #333;width: 125px;">项目名</th>
							<th style="border: 1px solid #333;width: 125px;">样品编号</th>
							<th style="border: 1px solid #333;width: 125px;">样品类型细分</th>
							<th style="border: 1px solid #333;width: 125px;">部件</th>
							<th style="border: 1px solid #333;width: 125px;">部件描述</th>
							<th style="border: 1px solid #333;width: 125px;">颜色</th>
							<th style="border: 1px solid #333;width: 125px;">供应商</th>
							<th style="border: 1px solid #333;width: 125px;">PE签样人</th>
							<th style="border: 1px solid #333;width: 125px;">CXD签样人</th>
							<th style="border: 1px solid #333;width: 125px;">PQM签样人</th>
							<th style="border: 1px solid #333;width: 125px;">Other签样人</th>
							<th style="border: 1px solid #333;width: 125px;">签样日期</th>
							<th style="border: 1px solid #333;width: 125px;">适用工厂</th>
							<th style="border: 1px solid #333;width: 125px;">有效期</th>
							<th style="border: 1px solid #333;width: 125px;">存档时间</th>
						</tr>
						<#list itemGroups[supplierName][sampleCategory] as item>
							<tr style="height: 30px;text-align: left;">
								<td style="border: 1px solid #333;width: 125px;">${item.odm_supplier!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.project!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_id!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_type!}</td> <#-- 样品类型细分 -->
								<td style="border: 1px solid #333;width: 125px;">${item.part!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.part_description!}</td> <#-- 部件描述 -->
								<td style="border: 1px solid #333;width: 125px;">${item.color!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.part_supplier!}</td>  <#-- 供应商 -->
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_pe!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_cxd!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_pqm!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_other!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_date!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.factory!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.expiration_type!}</td> <#-- 有效期 -->
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_date!}</td>
							</tr>
						</#list>
					</table>
					<br/>
				</#if>

				<#if sampleCategory != "Limit Sample" && sampleCategory != "Golden Sample">
					<table style="border-spacing: 0;border: 1px solid #333;border-collapse: collapse;font-size: 12px;">
						<tr style="height: 30px;text-align: center; background-color: darkgoldenrod">
							<th style="border: 1px solid #333;width: 125px;">ODM</th>
							<th style="border: 1px solid #333;width: 125px;">项目名</th>
							<th style="border: 1px solid #333;width: 125px;">样品编号</th>
							<th style="border: 1px solid #333;width: 125px;">部件</th>
							<th style="border: 1px solid #333;width: 125px;">颜色</th>
							<th style="border: 1px solid #333;width: 125px;">供应商</th>
							<th style="border: 1px solid #333;width: 125px;">PE签样人</th>
							<th style="border: 1px solid #333;width: 125px;">CXD签样人</th>
							<th style="border: 1px solid #333;width: 125px;">PQM签样人</th>
							<th style="border: 1px solid #333;width: 125px;">Other签样人</th>
							<th style="border: 1px solid #333;width: 125px;">签样日期</th>
							<th style="border: 1px solid #333;width: 125px;">适用工厂</th>
							<th style="border: 1px solid #333;width: 125px;">有效期</th>
							<th style="border: 1px solid #333;width: 125px;">存档时间</th>
						</tr>
						<#list itemGroups[supplierName][sampleCategory] as item>
							<tr style="height: 30px;text-align: left;">
								<td style="border: 1px solid #333;width: 125px;">${item.odm_supplier!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.project!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_id!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.part!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.color!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.part_supplier!}</td> <#-- 供应商 -->
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_pe!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_cxd!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_pqm!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_other!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_date!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.factory!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.expiration_type!}</td>
								<td style="border: 1px solid #333;width: 125px;">${item.sample_sign_date!}</td>
							</tr>
						</#list>
					</table>
					<br/>
				</#if>
			</#list>
		</#list>
	</div>

</#if>

<br/>
此邮件由系统自动生成，请勿回复!<br/>
This message is automatically generated by the system, please do not reply!
</body>
</html>