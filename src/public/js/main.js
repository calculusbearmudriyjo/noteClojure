$(document).ready(function() {
	$('#send').on('click', function() {
		var message = $('#message').val();
			console.log(message)
		$.get('/add', {message: message}, function(data) {
			$.get('/list', function(data) {
				console.log(data)
			})
		})
		return false;
	})		
})