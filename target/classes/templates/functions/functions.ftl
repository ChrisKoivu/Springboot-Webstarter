<#function getFoundationTemplate name>
  <#local templateName = "">
  <#switch name>  
	  <#case "card">
	    <#local templateName="foundation-templates/card.ftl">
	    <#break>
	  <#case "panel">
	    <#local templateName="foundation-templates/panel.ftl">
	    <#break>
	  <#default>
	    <#local templateName="foundation-templates/standard.ftl">
	    <#break>
   </#switch>
   <#return templateName>
</#function>