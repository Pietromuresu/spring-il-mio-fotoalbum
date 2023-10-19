
<script setup>

  const name = "Header";

</script>


<template>
  
	<header
		class="navbar  pm-header">
	  <div 
	  	class="container">
		
				<div>
					<a 
						href="/" 
						class="navbar-brand">
						<img src="/logo.png" class="pm-logo">
					</a>
					<a 
						href="/" 
						class="navbar-link ">
						Home
					</a>
					
				</div>
			
				<div>
					<form class="d-flex" role="search" action="/name">
							<input class="form-control pm-search-bar me-2" type="search" placeholder="Search" aria-label="Search" name="name" th:value="${searchedName}">
							<button class="pm-btn " type="submit">
						<svg class="" height="20" width="20" viewBox="0 0 24 24" aria-label="Icona di ricerca" role="img"><path d="M10 16c-3.31 0-6-2.69-6-6s2.69-6 6-6 6 2.69 6 6-2.69 6-6 6m13.12 2.88-4.26-4.26A9.842 9.842 0 0 0 20 10c0-5.52-4.48-10-10-10S0 4.48 0 10s4.48 10 10 10c1.67 0 3.24-.41 4.62-1.14l4.26 4.26a3 3 0 0 0 4.24 0 3 3 0 0 0 0-4.24"></path></svg>
					</button>
						</form>
				</div>
				
				<div>
					<button type="button" class="btn-sm btn" data-bs-toggle="modal" data-bs-target="#exampleModal">
						<svg class="" height="24" width="24" viewBox="0 0 24 24" aria-hidden="true" aria-label="" role="img"><path d="M18 12.5a1.5 1.5 0 1 1 .001-3.001A1.5 1.5 0 0 1 18 12.5m-6 0a1.5 1.5 0 1 1 .001-3.001A1.5 1.5 0 0 1 12 12.5m-6 0a1.5 1.5 0 1 1 .001-3.001A1.5 1.5 0 0 1 6 12.5M12 0C5.925 0 1 4.925 1 11c0 2.653.94 5.086 2.504 6.986L2 24l5.336-3.049A10.93 10.93 0 0 0 12 22c6.075 0 11-4.925 11-11S18.075 0 12 0" style="fill: gray;"></path></svg>
					</button>
					<div class="modal fade" id="exampleModal" tabindex="1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-5" id="exampleModalLabel">Invia un messaggio</h1>
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
												class="form-control"
												id="text" 
												placeholder="Inserisci il messaggio"
												th:field="text"
												></textarea>
											</div>
										
											<button type="submit" class="btn btn-secondary">Submit</button>
										</form>
									</div>	
								</div>
							</div>
						</div>
					</div>
				</div>
	  </div>
	</header>
</template>

<style scoped>

a{
	text-decoration: none;
	color: black;
}
.pm-header{
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	background-color: white;
	z-index: 1000;
	
	box-shadow: 2px 2px 5px 1px rgb(190, 190, 190);
}

.pm-logo{
	height: 30px;
}



.pm-btn{
	background: none;
    border: none;
    color: inherit;
    padding: 0;
    font: inherit;
    cursor: pointer;
    
}

.pm-search-bar{
	border-radius: 30px;
}


</style>