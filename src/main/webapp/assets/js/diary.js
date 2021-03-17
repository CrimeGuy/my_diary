$(document).ready(function() {
	$.ajax({
		type: "post",
		url:"../diary/diaryPageData.action",
		dataType:"json",
		success:function(data){
			initDayData(data);
		}
	});		
});

function initDayData(data){
	var firstDayWeek = data[0].week;
	$('#diary-month-center').text(data[0].month + '月');
	var dayNo = "";
	for(var i = 0;i < data.length;i++){
		dayNo = (firstDayWeek + i);
		//alert($('#day-'+ dayNo + ' .day-mid-div'));
		$('#day-'+ dayNo + ' .day-mid-div').text(data[i].dayNo);
		//$('#day-' + dayNo).css('display','block');
		$('#day-' + dayNo).css('background-color','#FFE4E1');
		$('#day-' + dayNo).css('border','1px solid #000');
	}
}