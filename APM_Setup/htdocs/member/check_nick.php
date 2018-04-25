<meta charset="utf-8">
<?
   if(!$nick)
   {
      echo("학번을 입력하세요.");
   }
   else
   {
      include "../lib/dbconn.php";

      $sql = "select * from member where st_num='$nick' ";

      $result = mysql_query($sql, $connect);
      $num_record = mysql_num_rows($result);

      if ($num_record)
      {
         echo "학번이 중복됩니다.<br>";
      }
      else
      {
         echo "가입되지 않은 학번입니다.";
      }

      mysql_close();
   }
?>
