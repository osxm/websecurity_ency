function REVERSE_INULL() {
	var myObj = getObj();
	var myFamilyName = "";
	var myName = myObj.name;  //先使用
	if (myObj != null) {  //后判空
		myFamilyName = myObj.myFamilyName;
	}
	return myFamilyName + myName;
}

function REVERSE_INULL_repair() {
	var myObj = getObj();
	var myFamilyName = "";
	var myName = "";
	  //先使用
	if (myObj != null) {  //后判空
	    myName = myObj.name;
		myFamilyName = myObj.myFamilyName;
	}
	return myFamilyName + myName;
}