
// IMPORTANT: notice the next request is scheduled only after the
//            previous request is fully processed either successfully
//	      or not.

function refreshTable() {
	var request = new XMLHttpRequest();
        var vBoard=document.getElementById("table");
        
        request.onload = function() {
            vBoard.innerHTML = this.responseText;
            vBoard.style.color="black";
            setTimeout(refreshTable, 2000);
            };
            
        request.ontimeout = function() {
            vBoard.innerHTML = "Server timeout, still trying ...";
            vBoard.style.color="red";
            setTimeout(refreshTable, 100);
        };
        
        request.onerror = function() {
            vBoard.innerHTML = "No server reply, still trying ...";
            vBoard.style.color="red";
            setTimeout(refreshTable, 5000);
        };
        
  	request.open("GET", "/table", true);
	request.timeout = 15000;
  	request.send();
}


