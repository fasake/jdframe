    /*************************************************************
     * 功能： 去除空格
     *************************************************************/
    var WHITE_SPACE = " \t\r\n";
    var validatemessages="";
    function trim( s )
    {
      if( s == null || s == "" )
        return s;

      // j, first non-whitespace char
      var j = -1;

      for( var i = 0; i < s.length; i++ )
      {
        if( WHITE_SPACE.indexOf( s.charAt( i ) ) == -1 )
        {
          j = i;
          break;
        }
      }

      if( j == -1 )
        return "";

      var k = j;

      for( var i = s.length - 1; i > j; i-- )
      {
        if( WHITE_SPACE.indexOf( s.charAt( i ) ) == -1 )
        {
          k = i;
          break;
        }
      }

      return s.substring( j, k + 1 );
    }

    /*************************************************************
     * 功能： e1.innerHTML 互换 e2.innerHTML
     *************************************************************/
    function swapContent( id_1, id_2 )
    {
      var e1 = document.getElementById(id_1);
      var e2 = document.getElementById(id_2);
      var s = e2.innerHTML;

      e2.innerHTML = e1.innerHTML;
      e1.innerHTML = s;
    }

    /*************************************************************
     * 功能： 设置 DISPLAY 属性
     *************************************************************/
    function setDisplay( id, display )
    {
            var element = document.getElementById( id );

            if( element && element.style )
                    element.style.display = display;
    }

    /*************************************************************
     * 功能： 切换 DISPLAY 属性( block, none )
     *************************************************************/
    function toggleDisplay( id )
    {
      var tmp = document.getElementById(id);

            if(!tmp )
                    return;

            tmp = tmp.style;

            if(!tmp.display || tmp.display == "block" )
                    tmp.display = "none";
            else
                    tmp.display = "block";
    }


    function toggleImage( img )
    {
      var i = img.src.lastIndexOf( "." );

      img.src = img.src.substring( 0, i - 1 ) + ( img.src.charAt( i - 1 ) % 2 + 1 ) + img.src.substring( i, img.src.length );
    }

    /*************************************************************
     * 功能： 设置 innerHTML 属性
     *************************************************************/
    function setContent( id, content )
    {
            document.getElementById(id).innerHTML = content;
    }

    /*************************************************************
     * 功能： TRIM 所有表单元素
     *************************************************************/
    function trimAll()
    {
            var form;

            for( var i = 0; i < document.forms.length; i++ )
            {
                    form = document.forms[i];

                    for( var j = 0; j < form.elements.length; j++ )
                    {
                            if( form.elements[j].value )
                                    form.elements[j].value = trim( form.elements[j].value );
                    }
            }
    }

    

    function setErrorStyle(e){
            e.style.backgroundColor='red';
    }

    function setNormalStyle(e){
            e.style.backgroundColor='';
    }
    /*************************************************************
     * 功能： 检查e值是否为空、是否选择
     *				 
     *				 
     *************************************************************/
    function validateNotNull(e){
            var val;            
            val = trim(e.value);
            if((e.type=="select-one" && val =="00") || val.length == 0 || isNotSelected(e)){
                    e.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            setNormalStyle(e);
            e.title = "";
            return true;
    }

    function isNotSelected(com){
      if(com.type != "radio"){
        return false;
      }      
      var comname = com.name;
      var radiocom = eval("document.all('" + comname + "')");
            
      var rt=true;    
      if(radiocom.length){
         for(var i=0;i<radiocom.length;i++){
           if(radiocom[i].checked == true){
             rt = false;
             break;
           }
         }
      }else{
        if(radiocom.checked == true){
          rt = false;
        }
      }
      return rt;
    }
    /*************************************************************
     * 功能： 检查e是否是数字
     *				-	e			DOM对象
     *				- lvalue 最小值
     *				- hvalue 最大值
     *				- scale  保留
     *				- precision  保留
     *				- requried 是否必须录入项
     *				- codeset 保留
     *************************************************************/
    function validateNumberInRange(e, lvalue, hvalue, scale, precision, requried, codeset){
            var val, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(isNaN(val)){
                    validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]为非正确的数值类型！</p>";
                    result = false;
            }
            else{
                    val = parseFloat(val);
                    if(val<lvalue || hvalue<val){
                            validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]不在[" + lvalue + "--" + hvalue +"]之内！</p>";
                            result = false;
                     }
            }
            if(result==false) {
                    this.title="该输入项取值范围为["+ lvalue + "--" + hvalue+"]!";
                    setErrorStyle(e);
            }
            else{
             this.title="";
             setNormalStyle(e);
            }
            return result;
    }
		/*************************************************************
     * 功能： 检查e是否是数字,并且不小于lvalue
     *				-	e			DOM对象
     *				- lvalue 最小值
     *				- hvalue 保留
     *				- scale  保留
     *				- precision  保留
     *				- requried 是否必须录入项
     *				- codeset 保留
     *************************************************************/
    function validateNumberAboveMin(e, lvalue, hvalue, scale, precision, requried, codeset){
            var val, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(isNaN(val)){
                    validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]为非正确的数值类型！</p>";
                    result = false;
            }
            else{
                    val = parseFloat(val);
                    if(val<lvalue){
                            validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]小于[" + lvalue + "]</p>";
                            result = false;
                     }
            }
            if(result==false) {
                    this.title="该输入项取值范围应大于等于["+ lvalue + "]!";
                    setErrorStyle(e);
            }
            else{
             this.title="";
             setNormalStyle(e);
            }
            return result;
    }
    /*************************************************************
     * 功能： 检查e是否是数字,并且不大于hvalue
     *				-	e			DOM对象
     *				- lvalue 保留
     *				- hvalue 最小值
     *				- scale  保留
     *				- precision  保留
     *				- requried 是否必须录入项
     *				- codeset 保留
     *************************************************************/
    function validateNumberBelowMax(e, lvalue, hvalue, scale, precision, requried, codeset ){
            var val, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(isNaN(val)){
                    validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]为非正确的数值类型！</p>";
                    result = false;
            }
            else{
                    val = parseFloat(val);
                    if(val>hvalue){
                            validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]大于[" + hvalue + "]</p>";
                            result = false;
                     }
            }
            if(result==false) {
                    this.title="该输入项取值范围应小于等于["+ hvalue + "]!";
                    setErrorStyle(e);
            }
            else{
             this.title="";
             setNormalStyle(e);
            }
            return result;
    }

    /*************************************************************
     * 功能： 检查e是否是数字,整数位数精度,小数位数精度是否满足
     *				-	e			DOM对象
     *				- lvalue 保留
     *				- hvalue 保留
     *				- scale  整数位数精度
     *				- precision  小数位数精度
     *				- requried 是否必须录入项
     *				- codeset 保留
     *************************************************************/
    function validateNumberInScale(e, lvalue, hvalue, scale, precision, requried, codeset ){
            var val, result, dotindex, intlen, declen;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(isNaN(val)){
                    validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]为非正确的数值类型！</p>";
                    result = false;
            }
            else{
                    dotindex = val.indexOf(".");
                    if(dotindex == -1) {
                            intlen = val.length;
                            declen = 0;
                    }
                    else{
                            intlen = dotindex;
                            declen = val.length - intlen - 1;
                    }
                    if(intlen > scale || declen > precision){
                            validatemessages = validatemessages + "<p>" + e.fieldname + "的输入值[" + val + "]不在[整数位为:" + scale + "--小数位为:" + precision +"]之内！</p>";
                            result = false;
                     }
            }
            if(result==false) {
                    this.title="该输入项取值范围为[整数位:"+ scale + "--小数位:" + precision+"]!";
                    setErrorStyle(e);
            }
            else{
             this.title="";
             setNormalStyle(e);
            }
            return result;
    }
    /*************************************************************
     * 功能： 检查e是否满足长度和必录项需求
     *				-	e			DOM对象
     *				- minlen 最小长度
     *				- maxlen 最大长度
     *				- scale  保留
     *				- precision  保留
     *				- requried 是否必须录入项
     *				- codeset 保留
     *************************************************************/

    function validateCharInRange(e, minlen, maxlen, scale, precision, requried, codeset){
            var val, result;
            result = true;
            val = trim(e.value);
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(val.length < minlen || val.length >maxlen){
                    validatemessages = validatemessages + "<p>" + e.fieldname + "的长度应在[" + minlen + "--" + maxlen +"]之内！</p>";
                    result = false;
            }
            if(result==false) {
                    this.title="该输入项字符长度应为["+ minlen + "--" + maxlen +"]之间!";
                    setErrorStyle(e);
            }
            else{
             this.title="";
             setNormalStyle(e);
            }
            return result;
    }
    
    function checkDate( str ) {
    	var reg = /^(\d{1,4})-(\d{1,2})-(\d{1,2})$/; //创建正则表达式校验时间对象
    	var r = str.match(reg);
    	if(r==null) {
    		return false;
    	} else {
    		var d= new Date(r[1], --r[2],r[3]);
    		if(d.getFullYear()!=r[1])
    			return false;
    		if(d.getMonth()!=r[2])
    			return false;
    		if(d.getDate()!=r[3])
    			return false;
    	}
    	return true;
    }

    /*************************************************************
     * 功能： 检查e是否满足必录项，是否是10位日期【YYYY-MM-DD】需求
     *				-	e			DOM对象
     *        - requried 是否必录项
     *************************************************************/
    function validateDateFormat(e, minlen, maxlen, scale, precision, requried, codeset){
            var val, month, year, day, sep1,sep2, yearnum, monthnum, daynum, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(val.length != 10){
                    this.title="该输入项的日期格式为YYYY-MM-DD!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    return false;
            }
            year = val.substr(0, 4);
            sep1 = val.substr(4, 1);
            month = val.substr(5,2);
            sep2 = val.substr(7,1);
            day = val.substr(8,2);

            if(isNaN(year)|| isNaN(month) || isNaN(day) || sep1 != "-" || sep2 != "-"){
                    this.title="该输入项的日期格式为YYYY-MM-DD!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    return false;
            }
            
            yearnum = parseFloat(year);
            monthnum = parseFloat(month);
            daynum = parseFloat(day);
            
            if(monthnum > 12 || monthnum < 1 || daynum > 31 || daynum < 1 ||yearnum < 1){
                    this.title="该输入项的日期格式为YYYY-MM-DD!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;              
                    return false;
            }
            
            //检查日期是否合法
            result = checkDate(yearnum + "-" + monthnum + "-" + daynum);
            if(result){
                    setNormalStyle(e);
                    this.title = "";
            }
            else{
                    this.title="该输入项的日期格式为YYYY-MM-DD!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
            }
            return result;
    }

    /*************************************************************
     * 功能： 检查e是否满足必录项，是否是7位日期【YYYY-MM】需求
     *				-	e			DOM对象
     *        - requried 是否必录项
     *************************************************************/
    function validateYYYYMMFormat(e, minlen, maxlen, scale, precision, requried, codeset){
            var val, month, year, sep1, monthnum, yearnum, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(val.length != 7){
                    this.title="该输入项的日期格式为YYYY-MM!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    return false;
            }
            year = val.substr(0, 4);
            sep1 = val.substr(4, 1);
            month = val.substr(5,2);

            if(isNaN(year)|| isNaN(month) || sep1 != "-"){
                    result = false;
            }
            yearnum = parseFloat(year);
            monthnum = parseFloat(month);
            if(monthnum > 12 || monthnum < 1 || yearnum < 1){
                    result = false;
            }
            if(result){
                    setNormalStyle(e);
                    this.title = "";
            }
            else{
                    this.title="该输入项的日期格式为YYYY-MM!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
            }
            return result;
    }

    /*************************************************************
     * 功能： 检查e是否满足必录项，是否是19位日期时间【YYYY-MM-DD HH24:MI:SS】需求
     *				-	e			DOM对象
     *        - requried 是否必录项
     *************************************************************/
    function validateDateTimeFormat(e, minlen, maxlen, scale, precision, requried, codeset){
            var val, month, year, day, hour, minute, second, result;
            var sep1,sep2,sep3, sep4, sep5, yearnum, monthnum, daynum, hhnum, mmnum, ssnum;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && requried) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(val.length != 19){
                    this.title="该输入项的日期格式为YYYY-MM-DD HH:MM:SS!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    return false;
            }
            year = val.substr(0, 4);
            sep1 = val.substr(4, 1);
            month = val.substr(5,2);
            sep2 = val.substr(7,1);
            day = val.substr(8,2);
            sep3 = val.substr(10,1);
            hour = val.substr(11,2);
            sep4 = val.substr(13,1);
            minute = val.substr(14,2);
            sep5 = val.substr(16,1);
            second = val.substr(17,2);

            if(isNaN(year)|| isNaN(month) || isNaN(day) || isNaN(hour) || isNaN(minute) ||
                    isNaN(second) || sep1 != "-" || sep2 != "-" || sep3 != " " || sep4 != ":" || sep5 != ":"){
                    result = false;
            }
            yearnum = parseFloat(year);
            monthnum = parseFloat(month);
            daynum = parseFloat(day);
            hhnum = parseFloat(hour);
            mmnum = parseFloat(minute);
            ssnum = parseFloat(second);
            if(yearnum < 1 || monthnum > 12 || monthnum < 1 || daynum > 31 || daynum < 1 ||
                    hhnum > 23 || hhnum < 0 || mmnum > 59 || mmnum < 0 || ssnum > 59 || ssnum < 0){
                    result = false;
            }
            //检查日期是否合法
            result = checkDate(yearnum + "-" + monthnum + "-" + daynum);
            if(result){
                    setNormalStyle(e);
                    this.title = "";
            }
            else{
                    this.title="该输入项的日期格式为YYYY-MM-DD HH:MM:SS!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
            }
            return result;

    }
    /*************************************************************
     * 功能： 检查e是否满足必录项，是否是8位时分秒【HH24:MI:SS】需求
     *				-	e			DOM对象
     *        - requried 是否必录项
     *************************************************************/
    function validateTimeFormat(e, minlen, maxlen, scale, precision, required, codeset){
            var val, hour, minute, second, sep1,sep2, hhnum, mmnum, ssnum, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && required) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(val.length != 8){
                    this.title="该输入项的时间格式为HH:MM:SS!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    return false;
            }
            hour = val.substr(0, 2);
            sep1 = val.substr(2, 1);
            minute = val.substr(3,2);
            sep2 = val.substr(5,1);
            second = val.substr(6,2);

            if(isNaN(hour)|| isNaN(minute) || isNaN(second) || sep1 != ":" || sep2 != ":"){
                    result = false;
            }
            hhnum = parseFloat(hour);
            mmnum = parseFloat(minute);
            ssnum = parseFloat(second);
            if(hhnum > 23 || hhnum < 0 || mmnum > 59 || mmnum < 0 || ssnum > 59 || ssnum < 0){
                    result = false;
            }
            if(result){
                    setNormalStyle(e);
                    this.title = "";
            }
            else{
                    this.title="该输入项的时间格式为HH:MM:SS!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
            }
            return result;
    }

    /*************************************************************
     * 功能： 检查e是否满足必录项，是否是5位小时分钟【HH24:MI】需求
     *				-	e			DOM对象
     *        - requried 是否必录项
     *************************************************************/
    function validateHHMMFormat(e, minlen, maxlen, scale, precision, required, codeset){
            var val, hour, minute, sep1, hhnum, mmnum, result;
            val = trim(e.value);
            result = true;
            if(val.length == 0 && required) {
                    this.title="该输入项不能为空!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            if(val.length != 5){
                    this.title="该输入项的时间格式为HH:MM!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    return false;
            }
            hour = val.substr(0, 2);
            sep1 = val.substr(2, 1);
            minute = val.substr(3,2);

            if(isNaN(hour)|| isNaN(minute) || sep1 != ":"){
                    result = false;
            }
            hhnum = parseFloat(hour);
            mmnum = parseFloat(minute);
            if(hhnum > 23 || hhnum < 0 || mmnum > 59 || mmnum < 0 ){
                    result = false;
            }
            if(result){
                    setNormalStyle(e);
                    this.title = "";
            }
            else{
                    this.title="该输入项的时间格式为HH:MM!";
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
            }
            return result;
    }
    /*************************************************************
     * 功能： 检查e是否满足必录项，是否是邮件格式
     *				-	e			DOM对象
     *        - requried 是否必录项
     *************************************************************/
    function validateEmailFormat(e, minlen, maxlen, scale, precision, required, codeset){
            var val, p;
            val = trim(e.value);
            if(val.length == 0 && required) {
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "不能为空!"+"</p>" ;
                    this.title="该输入项不能为空!";
                    return false;
            }
            if(val.length == 0) {this.title="";setNormalStyle(e); return true;}
            p=val.indexOf('@');
            if (p<1 || p==(val.length-1)) {
                    setErrorStyle(e);
                    validatemessages = validatemessages +  "<p>" +  e.fieldname + "的输入值[" + val +"]格式不正确!"+"</p>" ;
                    this.title="该输入项的格式为xxxx@xxx.com.cn!";
                    return false;
            }
            setNormalStyle(e);
            this.title="";
            return true;
    }
   
     
 
    /*************************************************************
     * 功能： 文本替换
     *				-	fullString			String对象
     *        - text      原字符串
		 *        - by    新字符串
     *************************************************************/    
    function replace(fullString,text,by) {
        // Replaces text with by in string
        var strLength = fullString.length, txtLength = text.length;
        if ((strLength == 0) || (txtLength == 0)) return fullString;

        var i = fullString.indexOf(text);
        if ((!i) && (text != fullString.substring(0,txtLength))) return fullString;
        if (i == -1) return fullString;

        var newstr = fullString.substring(0,i) + by;

        if (i+txtLength < strLength)
            newstr += replace(fullString.substring(i+txtLength,strLength),text,by);

        return newstr;
    }

    

    /*************************************************************
     * 功能： 显示日历，日历对象为cele_date
     *				-	d_start			int 初始年份
     *        - d_end      结束年份
		 *         
     *************************************************************/ 
    function init(d_start,d_end)
    {
         var temp_str;
         var i=0
         var j=0

   
         /**********************************************************************************************************/
         document.writeln("<div name=\"cele_date\" id=\"cele_date\"  style=\"display:none\"    style=\"LEFT: 69px; POSITION: absolute; TOP: 159px;Z-INDEX:99\" onClick=\"event.cancelBubble=true;\" onBlur=\"hilayer()\" onMouseout=\"lostlayerfocus()\">? </div>");
         /*******************************************MODIFY END*******************************************************************************/
         window.cele_date.innerHTML="";
         temp_str="<table border=\"1\" bgcolor=\"#4682b4\" bordercolor=\"white\"><tr><td colspan=7 onmouseover=\"overcolor(this)\">";
         temp_str+="<input type=\"Button\" value=\"<<\" onclick=\"change_date(-1,1)\" onmouseover=\"getlayerfocus()\" style=\"color: #FFFFFF; background-color: #5d7790; cursor: hand\">?";//左面的箭头


         temp_str+=""//年
         temp_str+="<select name=\"cele_date_year\" id=\"cele_date_year\" language=\"javascript\" onchange=\"change_date(this.value,0)\" onmouseover=\"getlayerfocus()\" onblur=\"getlayerfocus()\" style=\"font-size: 9pt; border: 1px #666666 outset; background-color: #F4F8FB\">"


         for (i=d_start;i<=d_end;i++)
         {
         temp_str+="<OPTION value=\""+i.toString()+"\">"+i.toString()+"</OPTION>";
         }
         temp_str+="</select>?";
         temp_str+=""//月
         temp_str+="<select name=\"cele_date_month\" id=\"cele_date_month\" language=\"javascript\" onchange=\"change_date(this.value,2)\" onmouseover=\"getlayerfocus()\" onblur=\"getlayerfocus()\" style=\"font-size: 9pt; border: 1px #666666 outset; background-color: #F4F8FB\">"

         
         for (i=1;i<=12;i++)
         {
         temp_str+="<OPTION value=\""+i.toString()+"\">"+i.toString()+"</OPTION>";
         }
         temp_str+="</select>?";
         temp_str+=""//右箭头
         temp_str+="<input type=\"Button\" value=\">>\" onclick=\"change_date(1,1)\" onmouseover=\"getlayerfocus()\"  style=\"color: #FFFFFF; background-color: #5d7790; cursor: hand\">";

        
         temp_str+="</td></tr><tr><td onmouseover=\"overcolor(this)\">"
         temp_str+="<font color=red>Su</font></td><td>";temp_str+="Mo</td><td>"; temp_str+="Tu</td><td>"; temp_str+="We</td><td>"
         temp_str+="Th</td><td>";temp_str+="Fr</td><td>"; temp_str+="Sa</td></tr>";
         for (i=1 ;i<=6 ;i++)
         {
         temp_str+="<tr>";
            for(j=1;j<=7;j++){
                temp_str+="<td name=\"c"+i+"_"+j+"\"id=\"c"+i+"_"+j+"\" style=\"CURSOR: hand\" style=\"COLOR:#000000\" language=\"javascript\" onmouseover=\"overcolor(this)\" onmouseout=\"outcolor(this)\" onclick=\"td_click(this)\">?</td>"
                }
         temp_str+="</tr>"
         }
         temp_str+="</td></tr></table>";
         window.cele_date.innerHTML=temp_str;
    }
    
    function set_cele_date(year,month)
    {
       var i,j,p,k
       var nd=new Date(year,month-1,1);
       event.cancelBubble=true;
       cele_date_year.value=year;
       cele_date_month.value=month;
       k=nd.getDay()-1
       var temp;
       for (i=1;i<=6;i++)
          for(j=1;j<=7;j++)
          {
          eval("c"+i+"_"+j+".innerHTML=\"\"");
          eval("c"+i+"_"+j+".bgColor=\"#4682b4\"");
          eval("c"+i+"_"+j+".style.cursor=\"hand\"");
          }
       while(month-1==nd.getMonth())
        { j=(nd.getDay() +1);
          p=parseInt((nd.getDate()+k) / 7)+1;
          eval("c"+p+"_"+j+".innerHTML="+"\""+nd.getDate()+"\"");
          if ((nd.getDate()==today.getDate())&&(cele_date_month.value==today.getMonth()+1)&&(cele_date_year.value==today.getYear())){
             eval("c"+p+"_"+j+".bgColor=\"#EFFB64\"");
          }
          if (nd>date_end || nd<date_start)
          {
          eval("c"+p+"_"+j+".bgColor=\"#FF9999\"");
          eval("c"+p+"_"+j+".style.cursor=\"text\"");
          }
          nd=new Date(nd.valueOf() + 86400000)
        }
    }
 
    /*************************************************************
     * 功能：  显示日期时间选择框
     *				-	eP			   输入框对象
     *        - d_start      开始年份
		 *        - d_end        结束年份
     *************************************************************/ 
    function show_cele_date(eP,d_start,d_end,t_object)
    {
    window.cele_date.style.display="";
    window.cele_date.style.zIndex=99
    var s,cur_d
    var eT = eP.offsetTop;
    var eH = eP.offsetHeight+eT;
    var dH = window.cele_date.style.pixelHeight;
    var sT = document.body.scrollTop;
    var sL = document.body.scrollLeft;
    event.cancelBubble=true;
    window.cele_date.style.posLeft = event.clientX-event.offsetX+sL-5;
    window.cele_date.style.posTop = event.clientY-event.offsetY+eH+sT-5;
    if (window.cele_date.style.posLeft+window.cele_date.clientWidth>document.body.clientWidth) window.cele_date.style.posLeft+=eP.offsetWidth-window.cele_date.clientWidth;
   
    if (d_start!=""){
        if (d_start=="today"){
            date_start=new Date(today.getYear(),today.getMonth(),today.getDate());
        }else{
            s=d_start.split(separator);
            date_start=new Date(s[0],s[1]-1,s[2]);
        }
    }else{
        date_start=new Date(1900,1,1);
    }

    if (d_end!=""){
        s=d_end.split(separator);
        date_end=new Date(s[0],s[1]-1,s[2]);
    }else{
        date_end=new Date(3000,1,1);
    }

    g_object=t_object

    cur_d=new Date()
    set_cele_date(cur_d.getYear(),cur_d.getMonth()+1);
    window.cele_date.style.display="block";
    window.cele_date.focus();
    }
    
    function td_click(t_object)
    {
    var t_d
    if (parseInt(t_object.innerHTML,10)>=1 && parseInt(t_object.innerHTML,10)<=31 )
    { t_d=new Date(cele_date_year.value,cele_date_month.value-1,t_object.innerHTML)
    if (t_d<=date_end && t_d>=date_start)
    {
    var year = cele_date_year.value;
    var month = cele_date_month.value;
    var day = t_object.innerHTML;
    if (parseInt(month)<10) month = "0" + month;
    if (parseInt(day)<10) day = "0" + day;
    if(!document.all(g_object).readOnly) {
      document.all(g_object).value=year+separator+month+separator+day;
    }
    window.cele_date.style.display="none";};
    }

    }
    function h_cele_date()
    {
    	window.cele_date.style.display="none";
    }

    function overcolor(obj)
    {
      if (obj.style.cursor=="hand") obj.style.color = "#FFFFFF";
      inover=true;
      window.cele_date.focus();
    }

    function outcolor(obj)
    {
      obj.style.color = "#000000";
      inover=false;
    }
    /*************************************************************
     * 功能：  获取当前日期的的YYYY-MM-DD ,并初始化到o
     *		  -	o			   输入框对象
     *        -  
	 *        -  
     *************************************************************/  
    function getNow(o){
        var Stamp=new Date();
        var year = Stamp.getYear();
        var month = Stamp.getMonth()+1;
        var day = Stamp.getDate();
        if(month<10){
            month="0"+month;
        }
        if(day<10){
            day="0"+day;
        }
        o.value=year+separator+month+separator+day;
    }
 
    function hilayer()
    {
            if (inover==false)
            {
                    var lay=document.all.cele_date;
                    lay.style.display="none";
            }
    }
    function getlayerfocus()
    {
            inover=true;
    }
    function lostlayerfocus()
    {
            inover=false;
    }
  
     /*************************************************************
     * 功能：  判断按键KEY是否输入数字
     *				-	 
     *        -  
		 *        -  
     *************************************************************/  
  function numInput(){
     var key = event.keyCode;
     var textbox = event.srcElement;    
     if (key==9 || key == 13 || key == 190 || key == 110){
        return true;
     } else if (key==8){ //backspace                                           
        return true;
     } else if ( (key>47&&key<58)) {                              
        return true;
     } else if ( (key>95&&key<106)){                   
        return true;
     }     
     return false;
  }
  
 
	
  
 

    /*************************************************************
     * 功能：  屏蔽鼠标右键、Ctrl+n、shift+F10、F5刷新、退格键   
     *				-	 
     *        -  
		 *        -  
     *************************************************************/  
   function   KeyDown(){     
    //屏蔽鼠标右键、Ctrl+n、shift+F10、F5刷新、退格键   
    //  alert("ASCII代码是："+event.keyCode);   
      if   ((window.event.altKey)&&   
              ((window.event.keyCode==37)||       //屏蔽   Alt+   方向键   ←   
                (window.event.keyCode==39))){     //屏蔽   Alt+   方向键   →   
            alert("不能使用ALT+方向键前进或后退网页！");   
            event.returnValue=false;   
            }   
      if   ((event.keyCode==8)     ||                                   //屏蔽退格删除键   
              (event.keyCode==116)||                                   //屏蔽   F5   刷新键   
              (event.keyCode==112)||                                   //屏蔽   F1   刷新键   
              (event.ctrlKey   &&   event.keyCode==82)){   //Ctrl   +   R   
            event.keyCode=0;   
            event.returnValue=false;   
            }   
      if   ((event.ctrlKey)&&(event.keyCode==78))       //屏蔽   Ctrl+n   
            event.returnValue=false;   
      if   ((event.shiftKey)&&(event.keyCode==121))   //屏蔽   shift+F10   
            event.returnValue=false;   
      if   (window.event.srcElement.tagName   ==   "A"   &&   window.event.shiftKey)     
              window.event.returnValue   =   false;     //屏蔽   shift   加鼠标左键新开一网页   
      if   ((window.event.altKey)&&(window.event.keyCode==115)){   //屏蔽Alt+F4   
              window.showModelessDialog("about:blank","","dialogWidth:1px;dialogheight:1px");   
              return   false;} 
      if   (window.event.keyCode==8 ||event.keyCode==78 ||event.keyCode==37   
            ||event.keyCode==39 ||event.keyCode==116 ||event.keyCode==82   
            ||event.keyCode==121 ||event.keyCode==115  
            ||(window.event.srcElement.tagName   ==   "A"   &&   window.event.shiftKey))   
      {   
             window.event.returnValue=false;   
      }   
  
  }     

    /*************************************************************
     * 功能：  显示/隐藏某一区域（层）
     *				-	oLayer 区域（层）名，为对象，并非字符串
     *        - oImg 图片区域对象名&lt;img id="img_switch" src="img_open"&gt;
		 *        - sImg1 区域显示时的图片 
		 *        - sImg2 区域隐藏时的图片
     *************************************************************/  
function switchLayer(oLayer, oImg, sImg1, sImg2) {
	var flag = oLayer.style.display;
	if (flag == "none") {
		oLayer.style.display = "block";
		oImg.src = sImg1;
	} else {
		oLayer.style.display = "none";
		oImg.src = sImg2;
	}
}
 
 



    /*************************************************************
     * 功能：  清空当前文档的input输入框值
     *				-	 
     *        -  
		 *        -  
		 *        -  
     *************************************************************/   
 
 
function clearInputs(){
    var obj = document.getElementsByTagName("INPUT");
    for(var i=0;i<obj.length;i++){
      for (prop in obj[i]){
        if(prop=="type" && obj[i].type=="text"){
          obj[i].value = "";
        }
      }
    }
  }

    /*************************************************************
     * 功能：  打开文件选择框
     *				-	 
     *        -  
		 *        -  
		 *        -  
     *************************************************************/
function browseFolder() {
	try {
			var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息
			var Shell = new ActiveXObject("Shell.Application"); 
			var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
			if (Folder != null) {
					Folder = Folder.items(); // 返回 FolderItems 对象
					Folder = Folder.item(); // 返回 Folderitem 对象
					Folder = Folder.Path; // 返回路径
					if (Folder.charAt(Folder.length - 1) != "") {
						Folder = Folder + ""; 
					}
					return Folder; 
			}
	}catch (e) {
		alert(e.message); 
	}
}


    /*************************************************************
     * 功能：  保存table数据到XLS
     *				-	 
     *        -  
		 *        -  
		 *        -  
     *************************************************************/ 
function saveAsXLS(mytable) { 
  var txt = mytable.outerHTML;
	window.clipboardData.setData("Text",txt);   
  try   
  {   
  var   ExApp   =   new   ActiveXObject("Excel.Application")   
  var   ExWBk   =   ExApp.workbooks.add()   
  var   ExWSh   =   ExWBk.worksheets(1)   
  ExApp.DisplayAlerts   =   false   
  ExApp.visible   =   true   
  }       
  catch(e)   
  {   
  alert("您的电脑没有安装Microsoft Excel软件！")   
  return   false   
  }     
    ExWBk.worksheets(1).Paste;  
        
}
