<?
  session_start();
  unset($_SESSION['userid']);
  unset($_SESSION['username']);
  unset($_SESSION['usernick']);
  unset($_SESSION['userlevel']);
  unset($_SESSION['view']);
  unset($_SESSION['del_num']);


  echo("
       <script>
          history.go(-1)
         </script>
       ");
?>
