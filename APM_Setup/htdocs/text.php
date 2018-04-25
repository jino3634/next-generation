
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
    ddd
  </body>
</html>
<?

echo "string";

$conect = mysql_connect('localhost','root','apmsetup');

if($conect)
{
  echo "ok";
}
else {
  echo "DB 접속오류입니다.";
}

?>
