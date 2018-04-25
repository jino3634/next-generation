<?php
// 세션사용을 하기위한 필수메서드, 세션사용선언
session_start();
// #1 MySQL 연결
$db = mysql_connect( localhost , 'root' , 'apmsetup' );
if( !$db ){
    die('MySQL connect ERROR : ' . mysql_error());
}
// #2 DB접속
$ret = mysql_select_db( 'check_', $db);
if( !$ret ){
    die('MySQL select ERROR : '. mysql_error());
}

?>
<!-- 게시판 HTML소스코드 !-->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>index</title>
    <link href="bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="index.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">게시판</a>
<?php

if( !isset($_SESSION[is_login]) ){ // 세션값이 없을 때 = "로그인 전 상태"

?>

        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <!--
                 method=POST , action=signin.php
                 POST방식으로 signin.php로 입력받은 데이터를 전송하는 form태그
          !-->
          <form class="navbar-form navbar-right" method=POST action=signin.php>

            <div class="form-group">
              <input type="text" name="user_id" placeholder="USER ID" class="form-control">
            </div>

            <div class="form-group">
              <input type="password" name="user_pw" placeholder="Password" class="form-control">
            </div>

            <button type="submit" class="btn btn-success">Sign in</button>

          </form>
        </div><!--/.navbar-collapse -->
      </div>


<?php

}else{    // 세션값이 존재 = "로그인 된 상태" => 아이디 비밀번호 입력 폼 화면에 출력x
    echo " Welcome~ ";
}
?>
  </nav>

    <!-- 게시글들을 모아놓는 테이블 -->
      <div class="jumbotron">
      <div class="container">
        <div class="table-responsive">
          <table class="table table-bordered table-striped">
            <thead>
              <tr>
                <th> 번호 </th>
                <th> 게시글 제목 </th>
                <th> 작성자 </th>
                <th> 작성시간</th>
              </tr>
            </thead>
            <tbody>
<?php


$resource = mysql_query( "SELECT * FROM board ");
// board테이블의 데이터 개수를 저장
$total_len = mysql_num_rows($resource);


if ( isset($_GET[idx]) ){         // GET메서드로 출력할 게시글 시작번호가 넘어온다
    $start = $_GET[idx] * 10;    // 10개씩 화면에 출력 / ORDER BY , LIMIT 설명은 따로하겠습니다
                                // $start = board테이블의 x번째 데이터를 지정
    $sql = "SELECT * FROM board ORDER BY no DESC LIMIT $start, 10 ";
} else{            // idx변수가 넘어오지않았으므로 처음 10개의 게시글을 출력
    $sql = "SELECT * FROM board ORDER BY no DESC LIMIT 10";
}
// resource변수에 10개의 데이터들을 저장한다
$resource = mysql_query( $sql );

$num=1;    // 게시글 번호
while( $row = mysql_fetch_assoc( $resource ) ){
    print "<tr>";
    echo "<th> $num </th>";
    print "<td> $row[title] </td>";
    print "<td> $row[user_id] </td>";
    print "<td> $row[write_time] </td>";
    print "</tr>";

    $num++;
}

// 게시글 목록 페이지 개수(count) = 총 게시글수 / 10 한다
$count = (int)( $total_len / 10 );
// 마지막 게시글 목록의 게시글 개수가 1개 이상,10개 이하인 경우 게시글목록개수+1
if ( $total_len % 10 ){ $count++; }

    print "<tr>";
    print "<td colspan=4 align=center>";
    for ( $i = 0; $i < $count ; $i++ ){ // 변수i와 게시글목록개수 비교
        // 게시글 목록 번호를 idx변수에 넣고 GET메서드로 전송한다
        print "<a href=http://192.168.6.123/index.php?idx={$i}>" ;
        $j = $i + 1;
        print "[{$j}]";    // 게시글 목록 번호: " [1][2] "
        print "</a>";
    }
    print "</td>";
    print "</tr>";
?>
            </tbody>
          </table>
        </div>

      </div>
    </div>
      <hr>
      <footer>
        <p>&copy; Company 2014</p>
      </footer>

  </body>
</html>
