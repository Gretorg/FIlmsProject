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
</style>
	<title>Crew</title>
</head>
<body>
	<center>
        <h2>
        	<a href="listFilmUser">Film list</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="listActorUser">List of all actors</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="showCrew-film-list-user">Crew list</a>
        </h2>
	</center>
	<div id ="layer">
		<a href="user_list">Login</a>
	</div>
    <table id="filter-table">
    
            <tr>
            	<th>Film</th>
                <th>Director</th>
                <th>Doph</th>
                <th>Composer</th>
                
            </tr>
             <tr class='table-filters'>
             <td>
           		 <input type="text"/>
        	 </td>
       		 <td>
           		 <input type="text"/>
        	 </td>
             <td>
            	 <input type="text"/>
             </td>
             <td>
            	 <input type="text"/>
             </td>
           </tr>
            <c:forEach var="Crew_film" items="${crew_film}">
                <tr class='table-data'>
                    <td><c:out value="${Crew_film.getDirector()}" /></td>
                    <td><c:out value="${Crew_film.getDoph()}" /></td>
                    <td><c:out value="${Crew_film.getComposer()}" /></td>
                    <td><c:out value="${Crew_film.getFilmName()}" /></td>
                </tr>
            </c:forEach>
        </table>
</body>
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