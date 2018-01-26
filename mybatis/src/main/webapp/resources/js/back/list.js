/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	console.log("调用后台批量删除方法");
	$("#mainForm").attr("action",basePath + "DeleteBatch").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
    console.log("修改当前页码，调用后台重新查询");
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}
