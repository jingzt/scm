/**
 * 采购管理-日历统计
 */
$(function() {
	$("#incomeCalendar").fullCalendar({
		header : {
			left : "prev,next",
			center : "title",
			right : "month"
		},
		selectable: true,
		events : "getIncomeCalendarData.do",
		dayClick : function(date, jsEvent, view) {
			window.location="getIncomeList.htm?dateTime="+date.Format("yyyy-MM-dd");
		}
	})
});