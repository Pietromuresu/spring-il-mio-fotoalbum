
<script setup>
	import { onMounted } from "vue";
	import store from "../../stores/store";
	import modalMessage from "./modal-message.vue";

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
					<div class="d-flex" >
						<input
											class="form-control pm-search-bar me-2"
											type="search"
											placeholder="Search"
											aria-label="Search"
											name="name"
											v-model="store.searchedName.value">
						<button
							class="pm-btn "
							@click="store.getPhotos(store.searchedName.value)">
							<svg
								class=""
								height="20"
								width="20"
								viewBox="0 0 24 24"
								aria-label="Icona di ricerca"
								role="img"><path
								d="M10 16c-3.31 0-6-2.69-6-6s2.69-6 6-6 6 2.69 6 6-2.69 6-6 6m13.12 2.88-4.26-4.26A9.842 9.842 0 0 0 20 10c0-5.52-4.48-10-10-10S0 4.48 0 10s4.48 10 10 10c1.67 0 3.24-.41 4.62-1.14l4.26 4.26a3 3 0 0 0 4.24 0 3 3 0 0 0 0-4.24"></path></svg>
						</button>
					</div>
				</div>
				<div class="d-flex">
					<modalMessage/>
					<div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
								Login / Register
							</button>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="http://localhost:8080/register">Registrati</a></li>
								<li><a class="dropdown-item" href="http://localhost:8080/">Login</a></li>
							</ul>
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