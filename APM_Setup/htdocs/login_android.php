<?

$id= $_POST[id];//android 에서 id값 및 pw 값을 받아옴.
$pw= $_POST[pw];

//$id = jjj;//테스트 코드
//$pw = 123;

$sql = "select * from member where id = '$id'";//쿼리문, 해당 아이디가 있는지 탐색.

include "./lib/dbconn.php";//db 접속

$result = mysql_query($sql, $connect);//접속된 db에 쿼리를 날림
$num_match = mysql_num_rows($result);//select 결과의 행의 갯수를 앎, 0이면 없는 아이디로 처리.

if(!$num_match)//해당 아이디가 없을시
{
  echo "0";// 0을 출력
    exit;
 }
 else//비밀번호가 맞는지 탐색하는 문
 {
     $row = mysql_fetch_array($result);//검색된 열을 변수에 저장함

     $db_pass = $row[pass];//db에 저장된 password를 저장함

     if($pw != $db_pass)// 비밀번호가 틀렸을시
     {

echo "1";//1을 출력
        exit;
     }
     else// 계정 정보 전송 (로그인 성공)
     {

    $login = array(//로그인 정보를 저장. json으로 출력될 것이기 떄문에 "userid":"jino"등으로 저장됨
    'userid'=>$row[id],
    'username'=>$row[name],
    'usernick'=>$row[st_num],
    'userlevel'=>$row[level]
);

echo json_encode($login);//로그인 정보를 출력


     }
}

?>
