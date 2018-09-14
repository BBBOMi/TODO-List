function draw(type, node) {
	var current_ul = node.closest('ul');

	if(type === 'TODO') {
		type = 'DOING'				
	} else if(type === 'DOING') {
		type = 'DONE'
		var next = document.querySelector('#next');
		next.remove(this);
	}

	var next_ul = document.querySelector('div[id='+type+'] ul');
	next_ul.appendChild(node);
}

function clicked(id, type) {
	var oReq = new XMLHttpRequest();
	var temp_document = type.closest('li');
	type = type.closest('div').getAttribute('id');

	oReq.addEventListener('load', function() {
		if(this.responseText === "success"){
			draw(type, temp_document);						
		}
	});
	oReq.open('GET', '/Todo/todoType?id=' + id + '&type=' + type);
	oReq.send();
}

var el = document.getElementById('before');
el.addEventListener('click', function() {
	window.location.href = 'main';
});


