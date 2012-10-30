<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Grid Test</title>
	<!-- styles -->
	<link rel="stylesheet" href="/grid/resources/styles/common.css"/>
	<link rel="stylesheet" href="/grid/resources/styles/grid.css"/>

	<!-- scripts -->
	<script type="text/javascript" src="/grid/resources/scripts/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="/grid/resources/scripts/jquery-ui-1.9.1.custom.min.js"></script>
	<script type="text/javascript" src="/grid/resources/scripts/grid.js"></script>
</head>
<body>

<div id="grid">
<div id="overlay" class="hidden"></div>

<c:set var="cellIndex" value="0" scope="page" />
<c:forEach var="row" begin="1" end="${grid.rows}">

    <c:choose>
        <c:when test='${row % 2 eq 0}'>
            <c:set var="rowColor" value="even" scope="page"/>
        </c:when>
        <c:otherwise>
            <c:set var="rowColor" value="odd" scope="page"/>
        </c:otherwise>
    </c:choose>

    <ul class="${rowColor}">

    <c:forEach var="cell" begin="1" end="${grid.columns}">

        <li id="cell_${cellIndex}" class="${grid.tiles[cellIndex].tileType} ${grid.tiles[cellIndex].tileSafety}"><a><b></b><span></span><em></em></a>
            <div id="info_${cellIndex}" class="tile popup hidden">
                <b></b><span>
                <div class="title">${grid.tiles[cellIndex].tileType.description}<a class="close" href="#">X</a></div>
                <div class="info">
                    Some info about this tile
                </div>
                </span><em></em>
            </div>
        </li>

        <c:set var="cellIndex" value="${cellIndex + 1}" scope="page" />

    </c:forEach>

    </ul>

</c:forEach>

</div> <!-- grid -->

</body>
</html>
