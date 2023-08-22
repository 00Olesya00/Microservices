form = document.getElementById('addPlace');
url = 'http://localhost:8190/addPlace';

async function retriveFormValue(event) {
	event.preventDefault();
	
	const title = form.querySelector(' [name="title"] ').value,
		category = form.querySelector(' [name="category"] ').value,
		location = form.querySelector(' [name="location"] ').value,
		url = form.querySelector(' [name="url"] ').value,
		description = form.querySelector(' [name="description"] ').value,
		price = form.querySelector(' [name="price"] ').value,
		calc = form.querySelector(' [name="calc"] ').value,
		avatar = form.querySelector(' [name="avatar"] ').value;
		
		const sight = {
			title: title,
			category: category,
			location: location,
			url: url,
			description: description,
			price: price,
			calc: calc,
			avatar: avatar
		};
		console.log('sight', sight);
		try{
			const response = await fetch(url, {
				method: 'POST',
				body: JSON.stringify(sight),
				headers: {
					'Content-Type': 'application/json'
				}
			});
			const json = await response.json();
			console.log('Success: ', JSON.stringify(json));
		}catch (error){
			console.error('ERROR: ', error);
		}
	
}

form.addEventListener('submit', retriveFormValue);