//ҳ��ȫ�ֱ���
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



//������ĵ�����
function mulDocument(myUrl ,layerId )
{
	this.myUrl = myUrl;
	this.layerId = layerId;
}

//����һ��
function addDiv( titleName,titleName_Prompt , newUrl  )
{
	//alert("titlename:"+titleName+" prompt:"+titleName_Prompt+" newUrl:"+newUrl);
	if( titleName.length>8)
		titleName = titleName.substring(0,5)+'...';

	var flag = -1;
	//�Ѿ��򿪵Ĵ���
	for( var i =0 ; i < storeFrame.mulDocumentArray.length; i++ )
	{
		//alert(storeFrame.mulDocumentArray[i].myUrl+":::"+newUrl);
		//������еĲ�id
		if( storeFrame.mulDocumentArray[i].myUrl == newUrl )
			flag = i;
         
		//���ص���Ҫ��ʾ�Ĳ�
		if( DeDocument.getElementById(divLayer+i) && DeDocument.getElementById(divLayer+i).style.display=='')
		{
			DeDocument.getElementById(divTitle+i).className=tabNoActiveCssName;

			DeDocument.getElementById(divLayer+i).style.display='none';
		}
	}
	//����Ѿ����ڣ��򷵻ء�

	if( flag >= 0 )
	{
		//�����Ѵ򿪵Ĳ�Ϊ��ʾ״̬
		DeDocument.getElementById(divTitle+flag).className=tabActiveCssName;
		DeDocument.getElementById(divLayer+flag).style.display='';
			return;
	}

	flag = storeFrame.mulDocumentArray.length;
	//��������Ѿ����Ｋ��
	if( storeFrame.mulDocumentArray.length >= divNumber )
	{
		//ɾ����һ��
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

	//���Ҫɾ���Ĳ㲻���ڣ�����
	if( DeDocument.getElementById(divTitle+layerId) == null)
		return;

	//��ʾ��
	var showFlag = -1;
	if( DeDocument.getElementById(divLayer+layerId).style.display=='')
	{
		showFlag = layerId-1;
		if( showFlag < 0 )
			showFlag = 0;
	}


	//ɾ��Ҫɾ���Ĳ�
	DeDocument.getElementById(divTitleContainer).removeChild(DeDocument.getElementById(divTitle+layerId));
	DeDocument.getElementById(divLayerContainer).removeChild(DeDocument.getElementById(divLayer+layerId));


	//�������Զ���ǰ��

	for( var newLayer = layerId+1; newLayer < divNumber ; newLayer++ )
	{
		if( DeDocument.getElementById(divTitle+newLayer) == null)
			continue;
		(DeDocument.getElementById(divTitle+newLayer)).id = divTitle+(newLayer-1);
		(DeDocument.getElementById(divLayer+newLayer)).id = divLayer+(newLayer-1);
		storeFrame.mulDocumentArray[newLayer].layerId = newLayer-1;
	}
	//���ɾ
	(storeFrame.mulDocumentArray).splice( layerId , 1 );

	//��ʾ��

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
		DeDocument.getElementById("closeDiv").style.display="";//��ʾ�رհ�ť
	}else{
		DeDocument.getElementById("closeDiv").style.display="none";//���عرհ�ť
	}
}

function showDiv(layerId)
{
	for( var i =0 ; i < storeFrame.mulDocumentArray.length; i++ )
	{
		//���в����Ҫ���ص�
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

//ˢ�²��е�����
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
