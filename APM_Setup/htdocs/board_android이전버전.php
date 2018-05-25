<?

	$table = "free";
	$ripple = "free_ripple";
	$scale=10;			// 한 화면에 표시되는 글 수

	include "./lib/dbconn.php";
  $sql = "select * from $table order by num desc";


	$result = mysql_query($sql, $connect);
	$total_record = mysql_num_rows($result); // 전체 글 수

  // 전체 페이지 수($total_page) 계산
  if ($total_record % $scale == 0)
    $total_page = floor($total_record/$scale);
  else
    $total_page = floor($total_record/$scale) + 1;

  if (!$page)                 // 페이지번호($page)가 0 일 때
    $page = 1;              // 페이지 번호를 1로 초기화

  // 표시할 페이지($page)에 따라 $start 계산
  $start = ($page - 1) * $scale;
  $number = $total_record - $start;

  for ($i=$start; $i<$start+$scale && $i < $total_record; $i++)
  {
     mysql_data_seek($result, $i);     // 포인터 이동
     $row = mysql_fetch_array($result); // 하나의 레코드 가져오기

   $item_num     = $row[num];
   $item_id      = $row[id];
   $item_name    = $row[name];
	 $item_nick    = $row[nick];
   $item_hit     = $row[hit];
	 $item_date    = $row[regist_day];
   $item_date = substr($item_date, 0, 10);
   $item_subject = str_replace(" ", "&nbsp;", $row[subject]);

   $number--;

   $page = array(//게시물 정보
   'num'=>$row[num],
   'id'=>$row[id],
   'name'=>$row[name],
   'writer'=>$row[nick],
   'hit'=>$row[hit],
   'date'=>$item_date,
	 'subject'=>$item_subject
);


echo json_encode($page);//로그인 정보를 출력

   }

?>
