
var JSON=[[1,2,3,4],["name1","name2","name3","name4","name5"],[41,42,43,44,45]];
function change(){
	JSON=receiveJsonFromJava()
}
let len=JSON.length; 
let row;let col;
let table=document.getElementById("table");
let values=[];

function addColumns(values){
    for(let i=0;i<values.length+2;i++){//+2 for 2 buttons
        col=document.createElement("td");
        if(i==values.length){
            delete_button=document.createElement("button");
            delete_button.innerText="delete";
            col.appendChild(delete_button);}
        else if(i==values.length+1){
            edit_button=document.createElement("button");
            edit_button.innerText="edit";
            col.appendChild(edit_button);}
        else{col.innerText=values[i];}
        row.appendChild(col);}
}
function addRow(col_values){
        row=document.createElement("tr");
        addColumns(col_values);
        table.appendChild(row);
}
function writeTable(){
	for(let i=0;i<JSON[0].length;i++)  { 
    	for(let j=0;j<len;j++){
        	values[j]=JSON[j][i];
    	}
    	addRow(values);
	}
}



