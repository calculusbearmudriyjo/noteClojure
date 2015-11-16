$(document).ready(function() {
	$('#send').on('click', function() {
		var message = $('#message').val();
		var antiForgery = $('#__anti-forgery-token').val();
		$.post('/add', {'message': message, '__anti-forgery-token': antiForgery }, function(data) {
			$.get('/list', function(data) {
				console.log(data)
			})
		})
		return false;
	})		
})