<?php
$source = "http://api.majestic.com/api/json?app_api_key=96CA2AAC8EC2F73FA1365D69BED49B1D&cmd=GetBackLinkData&item=http://www.bbc.co.uk/news/world-africa-33684721&Count=50000&datasource=fresh";
$json = file_get_contents($source);
$decodedJson = json_decode($json);
//var_dump($decodedJson);
$arrayOfData = $decodedJson -> DataTables ->  BackLinks -> Data;
//foreach ( $arrayOfData as $value){
//	$value->Date = strtotime($value->Date);
//}

function sortByDate($a, $b){
	return strtotime($a->Date)-strtotime($b->Date); 
}
usort($arrayOfData, 'sortByDate');

//$gmt = gmdate('Y/m/d H:i:s', strtotime($arrayOfData[5]->Date));

foreach ( $arrayOfData as $value){
	$value->Date = gmdate('D M d H:i:s', strtotime($value->Date)) . ' GMT ' . gmdate('Y', strtotime($value->Date));
	
}

foreach ( $arrayOfData as $value){
	echo $value->Date;
	echo "\n";
	$url = explode("/", $value->SourceURL)[2];
	if (substr($url, 0, 3) == "www")
		$url = substr($url, 4);
	echo $url;
	echo "\n";

}