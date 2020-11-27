<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<style>
		body{
			background: #1D1B26;
		}
		h2{
		color:#f1c40f;
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
th{
    color: #f1c40f;
    }
input[type=submit] {  

  background:none;
  text-decoration: none;
  outline: none;
  color: #f1c40f;
  display: inline-block;
  position: relative;
  padding: 15px 30px;
  border: 1px solid;
  border-image: linear-gradient(180deg, #f1c40f, ##f1c40f, #f1c40f, #f1c40f);
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
  background: linear-gradient(180deg, #f1c40f, #f1c40f, #f1c40f, #f1c40f);
  transition: .8s cubic-bezier(.165,.84,.44,1);
}
input[type=submit]:hover {background: rgba(255,255,255,0);}
input[type=submit]:hover:before {
  bottom: 0%;
  top: auto;
  height: 100%;
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
		<h2>Crew</h2>
        <h2>
        	<a href="showCrew-film-list">Crew list</a>
        </h2>
	</center>
	<div id ="layer">
		<a href="user_list">Login</a>
	</div>
    <div align="center">
		<c:if test="${Crew != null}">
			<form action="updateCrew" method="post">
        </c:if>
        <c:if test="${Crew == null}">
			<form action="insertCrew" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${Crew != null}">
            			Edit Crew
            		</c:if>
            		<c:if test="${Crew == null}">
            			Add New Crew
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${Crew != null}">
        			<input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
        		</c:if>    
            <tr>
                <th>Director: </th>
                <td>
                	<input type="text" name="director" size="45" required
                			value="<c:out value='${Crew.getDirector()}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Doph: </th>
                <td>
                	<input type="text"  name="doph" size="45" required min="1" step="any"
                			value="<c:out value='${Crew.getDoph()}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Composer: </th>
                <td>
                	<input type="text"  name="composer" size="45" required min="1" step="any"
                		value="<c:out value='${Crew.getComposer()}' />"
                	/>
                </td>
            </tr>
            
             <c:if test="${Crew == null}">
            <input type="hidden"  name="id" size="45" value="<%= request.getParameter("id") %>"required min="1" step="any"/>
            </c:if>
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />          
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>
