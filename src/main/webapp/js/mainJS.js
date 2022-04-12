var next = document.getElementById("nextProduct");
var pri = document.getElementById("prvProduct") ;
var numb = 1 ;

function nextProduct( ){
	numb++ ;
	document.getElementById("numberProduct").value = numb ;
}

function preProduct(){
	numb-- ;
	if( numb == 0 ){
		document.getElementById("numberProduct").value = 1 ; 
	}else{
		document.getElementById("numberProduct").value = numb ;
	}
}
