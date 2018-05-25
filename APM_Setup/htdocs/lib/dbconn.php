<?
    $connect=mysql_connect( "localhost", "root", "apmsetup") or
        die( "SQL server에 연결할 수 없습니다.");

        mysql_set_charset("euc-kr", $connect);

    mysql_select_db("check_",$connect);
?>
