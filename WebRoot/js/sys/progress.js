function doprogress(){
    	try{
	     var w = document.body.clientWidth; 
	     var h = document.body.clientHeight;	
	     var cdiv = document.createElement("DIV");  
	     cdiv.id='cdosubmitdiv';
	     cdiv.style.position = "absolute"; 
	     cdiv.style.zIndex = "99";
	     cdiv.style.left = "0px";
	     cdiv.style.top =  "0px";
	     cdiv.style.width = w+"px"; 
	     cdiv.style.height = h+"px";
	     cdiv.style.background ='#fff';
	     document.body.appendChild(cdiv);
	     document.body.style.cursor = 'wait';
	    /** var cimg = document.createElement("IMG");
	     cimg.src = "/images/sys/bg/progressImg.gif"; 
	     cimg.style.marginLeft  = (w/2)+"px";
	     cimg.style.marginBottom  = (h/2)+"px";
	     document.body.appendChild(cimg);
	     */
    	}catch(e){}
}  
function doconfirmDel(msg){
	var message = "删除记录后将无法恢复，确定要删除吗?";
	if(msg){
		message = msg;
	}
	
	if(confirm(message)){
		  doprogress();
		  return true;
	   }else{
		  return false;
	   }
}