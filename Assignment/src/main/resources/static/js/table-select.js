/**
 * 
 */
window.selectAllHandle = function() {
	document.getElementsByName("selectone").forEach(
		(item) => {
			item.checked = document.getElementById("selectAll").checked ? true : false;
		});
}

window.selectOneHandle = function() {
	let isSame = true;
	let isSel = document.getElementsByName("selectone").item(0).checked;
	const list = document.getElementsByName("selectone");
	for (i = 0; i < list.length; i++) {
		let row = list.item(i);
		if (row.checked != isSel) {
			isSame = false;
			break;
		}
	}

	if (isSame)
		document.getElementById("selectAll").checked = isSel;
}

window.deleteHandle = function() {
	if (!confirm("Xác nhận xóa")) {
		return false;
	}
}

window.deleteAllHandle = function(delLink) {
	if (confirm("Xác nhận xóa")) {
		const list = [];
		document.getElementsByName("selectone").forEach(e => { if (e.checked) list.push(e.value) });
		document.getElementById("deleteAll").href = delLink + "?ids	=" + list;
		return true;
	} else {
		return false;
	}
}