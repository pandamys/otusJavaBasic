$(document).ready(function(){
    console.log("ready");
    let buttonAdd = $("#add-student");
    buttonAdd.on('click',addStudentToTable);
});

function addStudentToTable(){
    console.log("add student");
    let name, birthday, sex;

    name = $("#name").val();
    sex = $("#sex").val();
    birthday = $("#birthday").val();

    if (checkForm(name, birthday)){
        console.log("add student: " + name + " " + sex + " " + birthday);
        addRowTable(name, birthday, sex);
    }
}

function checkForm(name, birthday){
    if (name == ""){
        alert("Введите имя");
        return false;
    } else if (birthday == ""){
        alert("Не введена дата рождения");
        return false;
    }
    return true;
}

function addRowTable(name, birthday, sex){
    let tableBody, newRow, newCell, lastRow;
    tableBody = $("#table-students").find("tbody").children();
    lastRow = tableBody[tableBody.length - 2];

    newRow = $("<tr>");
    newCell = $("<td>").append(name);
    newRow.append(newCell);
    newCell = $("<td class=text-center>").append(sex);
    newRow.append(newCell);
    newCell = $("<td class=text-center>").append(humanDate(birthday));
    newRow.append(newCell);
    newCell = $("<td class=text-center>").append(getAge(birthday));
    newRow.append(newCell);

    $(lastRow).before(newRow);

    getAvgAge();
}

function humanDate(birthday){
    let dateHuman, split_birthday;

    split_birthday = birthday.split("-");
    dateHuman = split_birthday[2] + "." + split_birthday[1] + "." + split_birthday[0];
    return dateHuman;
}

function getAge(date){
    let age, nowDate, birthday;

    birthday = new Date(date);
    nowDate = new Date();
    age = nowDate.getFullYear() - birthday.getFullYear();

    return age;
}

function getAvgAge(){
    let table, lastRow, lastCol, rows, countRows, totalAge = 0, avgAge = 0;

    tableBody = $("#table-students").find("tbody").children();
    countRows = tableBody.length - 2;
    lastCol = tableBody[0].cells.length - 1;
    lastRow = tableBody[tableBody.length - 1];

    for (i = 0; i < countRows; i++){
        age = Number(tableBody[i].cells[lastCol].textContent);
        totalAge += age;
    }

    avgAge = totalAge / countRows;

    lastRow.cells[1].textContent = avgAge;
}