function deletePerson(){
	swal({
		  title: 'Are you sure?',
		  text: "You won't be able to revert this!",
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Yes, delete it!'
		}).then(function(){
			confirmDeletePerson();
		})
}

function confirmDeletePerson(){
	$(document.getElementById('allUsers:hdnBtn')).click();
}

function registerSuccess(){
	swal({
		  title: 'Register Success!',
		  text: 'You will be redirect to the home',
		  type: 'success',
		  timer: 3000
		}).then(
		  function () {},
		  // handling the promise rejection
		  function (dismiss) {
		    if (dismiss === 'timer') {
		      console.log('I was closed by the timer');
		      $(document.getElementById('registrationForm:hdnBtn')).click();	      
		    }
		  }
		)
}