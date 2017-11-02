<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/jquery-ui.min.css"
	rel="stylesheet">
    <link href="<%=request.getContextPath()%>/backstage/css/CourseReview.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <span class="navbar-brand">e-Look管理員您好</span>
                </div>
                <p class="navbar-text">提醒您，應謹慎使用審查功能，避免影響網站會員的權益</p>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">待審程的課程清單</h3>
                        </div>
                        <div class="col col-xs-6 text-right">
                            <div class="pull-right">
                                <div class="btn-group" data-toggle="buttons">
                                    <label class="btn btn-success btn-filter active" data-target="completed">
                                        <input type="radio" name="options" id="option1" autocomplete="off" checked>免費課程
                                    </label>
                                    <label class="btn btn-warning btn-filter" data-target="pending">
                                        <input type="radio" name="options" id="option2" autocomplete="off">線上付費
                                    </label>
                                    <label class="btn btn-info btn-filter" data-target="pending">
                                        <input type="radio" name="options" id="option3" autocomplete="off">募資課程
                                    </label>
                                    <label class="btn btn-default btn-filter" data-target="all">
                                        <input type="radio" name="options" id="option4" autocomplete="off"> All
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table id="mytable" class="table table-striped table-bordered table-list">
                        <thead>
                        <tr>
                            <th class="col-check"><input type="checkbox" id="checkall" onclick="test()"/></th>
                            <th class="col-tools"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
                            </th>
                            <th class="hidden-xs">會員編號</th>
                            <th class="col-text">課程編號</th>
                            <th class="col-text">課程標題</th>
                            <th class="col-text">課程募資起始日</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr data-status="completed">
                            <td align="center"><input type="checkbox" class="checkthis"/></td>
                            <td align="center">
                                <a class="btn btn-default"><span class="glyphicon glyphicon-pencil"
                                                                 aria-hidden="true"></span></a>
                                <a class="btn btn-danger"><span class="glyphicon glyphicon-trash"
                                                                aria-hidden="true"></span></a>
                            </td>
                            <td class="hidden-xs">1</td>
                            <td>John Doe</td>
                            <td>johndoe@example.com</td>
                            <td>2017-11-17</td>
                        </tr>
                        <tr data-status="pending">
                            <td align="center"><input type="checkbox" class="checkthis"/></td>
                            <td align="center">
                                <a class="btn btn-default"><span class="glyphicon glyphicon-pencil"
                                                                 aria-hidden="true"></span></a>
                                <a class="btn btn-danger"><span class="glyphicon glyphicon-trash"
                                                                aria-hidden="true"></span></a>
                            </td>
                            <td class="hidden-xs">2</td>
                            <td>Jen Curtis</td>
                            <td>jencurtis@example.com</td>
                            <td>2017-11-11</td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col col-xs-offset-3 col-xs-6">
                            <nav aria-label="Page navigation" class="text-center">
                                <ul class="pagination">
                                    <li>
                                        <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">«</span>
                                        </a>
                                    </li>
                                    <li class="active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li>
                                        <a href="#" aria-label="Next">
                                            <span aria-hidden="true">»</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col col-xs-3">
                            <div class="pull-right">
                                <button type="button" class="btn btn-primary">
                                    <span class="glyphicon glyphicon-plus"
                                          aria-hidden="true"></span>
                                    Add row
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <p class="navbar-text">貼心提醒：審查募資課程時，應以"募資啟始日"來判斷優先順序</p>
            </div>
        </nav>
    </div>
</div>
</section>

<!-- script的集結地========================================================================================== -->
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.min.js"></script> 
<script src="assets/js/jquery.scrollex.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script>
$(document).ready(function () {
    $('.btn-filter').on('click', function () {
        var $target = $(this).data('target');
        if ($target != 'all') {
            $('.table tbody tr').css('display', 'none');
            $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
        } else {
            $('.table tbody tr').css('display', 'none').fadeIn('slow');
        }
    });

    $('#checkall').on('click', function () {
        if ($("#mytable #checkall").is(':checked')) {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", true);
            });

        } else {
            $("#mytable input[type=checkbox]").each(function () {
                $(this).prop("checked", false);
            });
        }
    });
});
<!-- script的集結地========================================================================================== -->
</script>
</body>
</html>