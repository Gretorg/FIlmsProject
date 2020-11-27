<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<style>
	body{
		background: #1D1B26;
	}
	header{
		background: #1D1B26;
  		display: block;
	   
	}
	footer {
 	 	background: #1D1B26;
  		display: block;
	    height: 205px;
	}
    #filter-table{
        width: 100%;
    }
    #filter-table th{
        background-color: #1D1B26;
    }
    #filter-table td, #filter-table th{
        padding: 5px;
        border-bottom: 1px solid #ccc;
    }
    th{
    color: #f1c40f;
    }
    td{
    color: #f1c40f;
    }
    a {
 	 text-decoration: none;
  	 outline: none;
  	 display: inline-block;
 	 margin: 10px 20px;
 	 padding: 10px 30px;
 	 position: relative;
 	 border: 2px solid #f1c40f;
   	 color: #f1c40f;
 	 font-family: 'Montserrat', sans-serif; 
  	transition: .4s;
}
a:after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
  margin: auto;
  border: 2px solid rgba(0,0,0,0);
  transition: .4s;
}
.button-container a:hover:after {
  border-color: #f1c40f;
  width: calc(100% - 10px);
  height: calc(100% + 10px);
}
#layer {   
    width: 100px;
    height: 100px; 
    position: absolute;
    top:0;
    right:100;
      }   
#layer1 {   
    width: 100px;
    height: 100px; 
    position: absolute;
    top:50;
    right:100;
      } 
input[type=submit] {  

  background:none;
  text-decoration: none;
  outline: none;
  color: white;
  display: inline-block;
  position: relative;
  padding: 15px 30px;
  border: 1px solid;
  border-image: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);
  border-image-slice: 1;
  margin: 10px 20px;   font-family: 'Montserrat', sans-serif;
  text-transform: uppercase;
  overflow: hidden;
  letter-spacing: 2px;
  transition: .8s cubic-bezier(.165,.84,.44,1);
}
input[type=submit]:before {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  height: 0;
  width: 100%;
  z-index: -1;
  color: white;
  background: linear-gradient(180deg, #ff3000, #ed0200, #ff096c, #d50082);
  transition: .8s cubic-bezier(.165,.84,.44,1);
}
input[type=submit]:hover {background: rgba(255,255,255,0);}
input[type=submit]:hover:before {
  bottom: 0%;
  top: auto;
  height: 100%;
}  
</style>
	<title>Filmes</title>
</head>
<header>
	<div align="center">
		<h2>
        	<a href="new">New Film</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Film list</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="listActor">Actor list</a>
        		&nbsp;&nbsp;&nbsp;
        	<a href="showCrew-film-list">Crew list</a>
        </h2> 
	</div>
	<div id ="layer">
		<a href="user_list">Login</a>
	</div>  
</header>
<body>
    <table id="filter-table">
            <tr>
                <th>Name</th>
                <th>Year</th>
                <th>Genre</th>
                <th>Actions</th>
                <th>Show</th>
                <th>Add</th>
               
            </tr>
             <tr class='table-filters'>
       		 <td>
           		 <input type="text"/>
        	 </td>
        	 <td>
            	 <input type="number"/>
       	     </td>
             <td>
            	 <input type="text"/>
             </td>
           </tr>
            <c:forEach var="product" items="${listProduct}">
                <tr class='table-data'>
                    <td><c:out value="${product.name}" /></td>
                    <td><c:out value="${product.year}" /></td>
                    <td><c:out value="${product.director}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${product.id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${product.id}' />" onclick="return confirm('Are you sure you want to delete this film?');">Delete</a>  
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	         	
                    </td> 
                    <td>
                    <a href="show_actors?id=<c:out value='${product.id}' />">Show actors</a>  
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="showCrew-film?id=<c:out value='${product.id}' />">ShowCrew</a> 
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>    
                    <td>
                    	<a href="newActor?id=<c:out value='${product.id}' />">Add actor</a>  
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="newCrew?id=<c:out value='${product.id}' />">Add crew</a>
                    </td>       
                </tr>
               </c:forEach> 
        </table>
</body>
<footer>
</footer>
</html>
<script>
$('.table-filters input').on('input', function () {
    filterTable($(this).parents('table'));
});

function filterTable($table) {
    var $filters = $table.find('.table-filters td');
    var $rows = $table.find('.table-data');
    $rows.each(function (rowIndex) {
        var valid = true;
        $(this).find('td').each(function (colIndex) {
            if ($filters.eq(colIndex).find('input').val()) {
                if ($(this).html().toLowerCase().indexOf(
                $filters.eq(colIndex).find('input').val().toLowerCase()) == -1) {
                    valid = valid && false;
                }
            }
        });
        if (valid === true) {
            $(this).css('display', '');
        } else {
            $(this).css('display', 'none');
        }
    });
}
</script>