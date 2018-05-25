<meta charset="utf-8">
<?
  session_start();
   $regist_day = date("Y-m-d (H:i)");  // 현재의 '년-월-일-시-분'을 저장
   $ip = $REMOTE_ADDR;         // 방문자의 IP 주소를 저장

   include "../lib/dbconn.php";       // dconn.php 파일을 불러옴

               // 레코드 삽입 명령을 $sql에 입력
	    $sql = "insert into redy(student_st_num, free_num) ";
		$sql .= "values('$usernick', $_GET[num]);";
		mysql_query($sql, $connect);  // $sql 에 저장된 명령 실행

//
   mysql_close();                // DB 연결 끊기
   echo "
	   <script>
     window.alert('참석 신청 완료')
     location.href = '/free/view.php?table=free&num=$_GET[num]&page=$_GET[page]';
	   </script>
	";
?>
