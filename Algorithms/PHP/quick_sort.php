<?php

//quick_sort.php

/*
	Quick sort is a comparison sort, meaning that it can sort items of any type for which a "less-than" relation (formally, a total order) is defined.
*/
	
function quick_sort($array_to_sort)
 {
	$loe = $gt = array();
	if(count($array_to_sort) < 2)
	{
		return $array_to_sort;
	}
	$pivot_key = key($array_to_sort);
	$pivot = array_shift($array_to_sort);
	foreach($array_to_sort as $val)
	{
		if($val <= $pivot)
		{
			$loe[] = $val;
		}elseif ($val > $pivot)
		{
			$gt[] = $val;
		}
	}
	return array_merge(quick_sort($loe),array($pivot_key=>$pivot),quick_sort($gt));
}
 
$array_to_sort = array(2, 0, 7, 3, -1, 9, 1);

echo 'Original Array : '.implode(',',$array_to_sort).'\n';
$array_to_sort = quick_sort($array_to_sort);
echo 'Sorted Array : '.implode(',',$array_to_sort);
?>