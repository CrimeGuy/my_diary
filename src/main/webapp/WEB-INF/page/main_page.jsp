<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="diary-main ">
	<input type="hidden" value="" id="monthNo"/>
	<input type="hidden" value="" id="yearNo"/>

	<div class="diary-title-div">
		<div class="left-title-div">diary</div>
		<div class="right-title-div"></div>
	</div>
	<div class="diary-month-div">
		<div class="diary-month-left">
		</div>
		<div class="diary-month-center" id="diary-month-center">几月</div>
		<div class="diary-month-right">
			<div class="next-month-btn"></div>
		</div>
	</div>
	<div class="diary-week-div">
	<div id="blank-div" class="blank-div"></div>
		<div id="blank-div" class="week-div">月曜日</div>
		<div id="monday-div" class="week-div">火曜日</div>
		<div id="tuesdag-div" class="week-div">水曜日</div>
		<div id="wednesday-div" class="week-div">木曜日</div>
		<div id="thursday-div" class="week-div">金曜日</div>
		<div id="friday-div" class="week-div">土曜日</div>
		<div id="saturday-div" class="week-div">日曜日</div>
		<div id="blank-div" class="blank-div"></div>
	</div>
	
	<!-- 第一行 -->
	<div class="diary-day-div-row" id="diary-day-div-row-1">
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-1" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-2" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-3" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-4" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-5" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-6" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-7" class="day-div day-frist">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-blank-div" style="float: right;">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
	</div>
	
	<!-- 第二行 -->
	<div class="diary-day-div-row" id="diary-day-div-row-2">
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-8" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-9" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-10" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-11" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-12" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-13" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-14" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
	</div>
		<!-- 第三行 -->
	<div class="diary-day-div-row" id="diary-day-div-row-3">
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div">
			<button type="button" id="pre-month-go" class="layui-btn layui-btn-radius layui-btn-warm">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;≪≪上个月≪≪&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</button>
			</div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-15" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-16" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-17" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-18" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-19" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-20" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-21" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div">
				<button type="button" id="next-month-go" class="layui-btn layui-btn-radius layui-btn-warm">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;≫≫下个月≫≫&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</button>
			</div>
			<div class="day-bom-div"></div>
		</div>
	</div>
	
	<!-- 第四行 -->
	<div class="diary-day-div-row" id="diary-day-div-row-4">
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-22" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-23" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-24" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-25" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-26" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-27" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-28" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
	</div>
	
	<!-- 第五行 -->
	<div class="diary-day-div-row" id="diary-day-div-row-5">
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-29" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-30" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-31" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-32" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-33" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-34" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-35" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
	</div>
	
	<!-- 第六行 -->
	<div class="diary-day-div-row" id="diary-day-div-row-6">
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-36" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div id="day-37" class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
		<div class="day-blank-div">
			<div class="day-top-div"></div>
			<div class="day-mid-div"></div>
			<div class="day-bom-div"></div>
		</div>
	</div>
</div>






























</body>
</html>