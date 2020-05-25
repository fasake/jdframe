//页面全局变量
var divNumber = 8;
storeFrame = "";
DeDocument = "";
mulDocumentArray = new Array();
var divTitleContainer = "tabtitle";
var divLayerContainer = "tabcontent";
var divTitle = 'tab_div';
var divLayer = 'divlayer';
var tabActiveCssName = "Tab_LiActive";
var tabNoActiveCssName = "Tab_LiNoActive";



//定义多文档对象
function mulDocument(myUrl ,layerId )
{
	this.myUrl = myUrl;
	this.layerId = layerId;
}

//增加一层
function addDiv( titleName,titleName_Prompt , newUrl  )
{
	//alert("titlename:"+titleName+" prompt:"+titleName_Prompt+" newUrl:"+newUrl);
	if( titleName.length>8)
		titleName = titleName.substring(0,5)+'...';

	var flag = -1;
	//已经打开的处理
	for( var i =0 ; i < storeFrame.mulDocumentArray.length; i++ )
	{
		//alert(storeFrame.mulDocumentArray[i].myUrl+":::"+newUrl);
		//标记已有的层id
		if( storeFrame.mulDocumentArray[i].myUrl == newUrl )
			flag = i;
         
		//隐藏掉需要显示的层
		if( DeDocument.getElementById(divLayer+i) && DeDocument.getElementById(divLayer+i).style.display=='')
		{
			DeDocument.getElementById(divTitle+i).className=tabNoActiveCssName;

			DeDocument.getElementById(divLayer+i).style.display='none';
		}
	}
	//如果已经存在，则返回。

	if( flag >= 0 )
	{
		//设置已打开的层为显示状态
		DeDocument.getElementById(divTitle+flag).className=tabActiveCssName;
		DeDocument.getElementById(divLayer+flag).style.display='';
			return;
	}

	flag = storeFrame.mulDocumentArray.length;
	//如果层数已经到达极限
	if( storeFrame.mulDocumentArray.length >= divNumber )
	{
		//删掉第一层
		subDiv(0);
		flag--;
	}


	storeFrame.mulDocumentArray[flag] = new mulDocument(newUrl,flag);


	var newDiv = DeDocument.createElement("div");
	newDiv.id = divTitle + flag;
	newDiv.align= "center";
	newDiv.className = tabActiveCssName;
	newDiv.innerHTML = getTabTitle(flag,titleName,newUrl);
	newDiv.title=titleName_Prompt;
	
	DeDocument.getElementById(divTitleContainer).appendChild(newDiv);
	var newDivContent = DeDocument.createElement("divContent");
	newDivContent.id = divLayer+flag;
	newDivContent.innerHTML = getTabLayer(flag,newUrl,titleName_Prompt);

	DeDocument.getElementById(divLayerContainer).appendChild(newDivContent);
   // alert(document.parentWindow.parent.document.getElementsByName('main')[0].getAttribute('height'));
   

   // alert(document.body.innerHTML);
}


function subDiv( layerId )
{

	//如果要删除的层不存在，返回
	if( DeDocument.getElementById(divTitle+layerId) == null)
		return;

	//显示层
	var showFlag = -1;
	if( DeDocument.getElementById(divLayer+layerId).style.display=='')
	{
		showFlag = layerId-1;
		if( showFlag < 0 )
			showFlag = 0;
	}


	//删除要删除的层
	DeDocument.getElementById(divTitleContainer).removeChild(DeDocument.getElementById(divTitle+layerId));
	DeDocument.getElementById(divLayerContainer).removeChild(DeDocument.getElementById(divLayer+layerId));


	//其他层自动往前移

	for( var newLayer = layerId+1; newLayer < divNumber ; newLayer++ )
	{
		if( DeDocument.getElementById(divTitle+newLayer) == null)
			continue;
		(DeDocument.getElementById(divTitle+newLayer)).id = divTitle+(newLayer-1);
		(DeDocument.getElementById(divLayer+newLayer)).id = divLayer+(newLayer-1);
		storeFrame.mulDocumentArray[newLayer].layerId = newLayer-1;
	}
	//最后删
	(storeFrame.mulDocumentArray).splice( layerId , 1 );

	//显示层

	if( DeDocument.getElementById(divLayer+showFlag)!=null)
	{
		DeDocument.getElementById(divTitle+showFlag).className=tabActiveCssName;
		DeDocument.getElementById(divLayer+showFlag).style.display='';
	}
}

function subDivUrl()
{
	for( var i = 0 ; i < storeFrame.mulDocumentArray.length ; i++ )
	{
		if (DeDocument.getElementById(divLayer+storeFrame.mulDocumentArray[i].layerId).style.display==''){
			subDiv(storeFrame.mulDocumentArray[i].layerId);
		}
		showCloseBtn();
	}
	
}

function showCloseBtn(){
	if (storeFrame.mulDocumentArray.length>0){
		DeDocument.getElementById("closeDiv").style.display="";//显示关闭按钮
	}else{
		DeDocument.getElementById("closeDiv").style.display="none";//隐藏关闭按钮
	}
}

function showDiv(layerId)
{
	for( var i =0 ; i < storeFrame.mulDocumentArray.length; i++ )
	{
		//所有层均需要隐藏掉
		DeDocument.getElementById(divTitle+i).className=tabNoActiveCssName;
		DeDocument.getElementById(divLayer+i).style.display='none';

	}
	DeDocument.getElementById(divTitle+layerId).className=tabActiveCssName;
	DeDocument.getElementById(divLayer+layerId).style.display='';
   // var h =  window.top['main'].getAttribute('height');
    var h =  window.top['main'].screen.availHeight;
    
    h = new Number(h) -50;
	DeDocument.getElementById("if"+divLayer+layerId).height=h;
	//alert(DeDocument.getElementById("if"+divLayer+layerId).height);
	
	
	
}

function showDivUrl( myUrl )
{

	for( var i = 0 ; i < storeFrame.mulDocumentArray.length ; i++ )
	{
		if( myUrl == storeFrame.mulDocumentArray[i].myUrl )
		{
			showDiv(storeFrame.mulDocumentArray[i].layerId);
			break;
		}
	}
}

function getTabTitle( layerId , titleName, myUrl )
{

	var content =  "<div onclick=\"showDivUrl('"+myUrl+"')\">"
			+titleName
			+"</div>";
	return content;
}

//刷新层中的内容
function refurbishDIV(layerId , muUrl, urlName){
	newDivContent = DeDocument.getElementById(divLayer+layerId);
	newDivContent.innerHTML = getTabLayer(layerId,muUrl,urlName);
	
}

function getTabLayer( layerId , muUrl, urlName )
{
	var h = window.top['main'].screen.availHeight
        h = new Number(h) -50;
	var content = "<table width='100%' height='100%' border=\"0\" class=\"line_top\">\n"
		+"<tr  width='100%' height='100%'>\n"
		+"<td  colspan='2'>\n"
		+"<iframe id='if"+divLayer+layerId+"'  width='100%' height='"+h+"px' frameborder='0' scrolling='yes' src='"+muUrl+"'>\n"
		+"</iframe>\n"
		+"</td>\n"
		+"</tr>\n"
		+"</table>\n";
		showCloseBtn();
	return content;
}
