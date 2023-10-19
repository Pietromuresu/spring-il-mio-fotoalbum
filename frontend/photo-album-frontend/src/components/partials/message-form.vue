<template>
		
	<body>
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
		Launch demo modal
	</button>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
				<div class="pm-message-form">			
		
				<form>
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email </label>
						<input type="email" class="form-control" id="exampleInputEmail1" th:field="email" aria-describedby="emailHelp">
						<div id="emailHelp" class="form-text">Non condivideremo la tua mail con nessun altro</div>
					</div>
					<div class="mb-3">
						<label  for="text" class="form-label">Password</label>
						<textarea
						id="text" 
						placeholder="Inserisci il messaggio"
						th:field="text"
						></textarea>
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Check me out</label>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
		
			</div>	
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
		

	</body>
</template>