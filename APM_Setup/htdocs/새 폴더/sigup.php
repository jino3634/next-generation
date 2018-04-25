<?
$connect = mysql_connect("localhost","root","apmsetup");
mysql_select_db("check_",$connect);

echo "$id";


$sql1 = "select 0 from admin where id=$id";
$result = mysql_query($sql1,$connect);
$row = mysql_fetch_array($result);

if($row==1)
echo "아이디가 중복입니다.";

else if($passwd != $passwd_re)
echo "두 비밀번호가 다릅니다.";

else if($id == '' || $passwd == '' || $name =='')
echo "공란을 모두 채워주세요.";

else {
  $sql = "insert into admin values('$id','$passwd','$name');"

  $result = mysql_query($sql,$connect);

  if($result)
  echo "회원가입 완료.";
  else {
    echo "회원가입 에러";
  }
}
?>
