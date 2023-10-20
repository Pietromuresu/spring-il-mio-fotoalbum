<script setup>
  import axios from 'axios';
import { ref } from 'vue';
  import store from '../../stores/store';
  let message = ref({
    text: null,
    email: null
  })


  function removeBackdrop(){
    const back = document.querySelector(".modal-backdrop");
    back.classList.remove("modal-backdrop");
  }

  function sendMessage(){
    axios.post(store.API_URL + "/message/send", message.value)
          .then(res => {
            console.log(res);
            message.value.email = null;
						message.value.text = null

          })
  }
</script>

<template>
  <div>
					<button
					  type="button"
					  class="btn-sm btn"
					  data-bs-toggle="modal"
					  data-bs-target="#exampleModal"
            @click="removeBackdrop()">
						<svg
						  class=""
						  height="24"
						  width="24"
						  viewBox="0 0 24 24"
						  aria-hidden="true"
						  aria-label=""
						  role="img"><path
						  d="M18 12.5a1.5 1.5 0 1 1 .001-3.001A1.5 1.5 0 0 1 18 12.5m-6 0a1.5 1.5 0 1 1 .001-3.001A1.5 1.5 0 0 1 12 12.5m-6 0a1.5 1.5 0 1 1 .001-3.001A1.5 1.5 0 0 1 6 12.5M12 0C5.925 0 1 4.925 1 11c0 2.653.94 5.086 2.504 6.986L2 24l5.336-3.049A10.93 10.93 0 0 0 12 22c6.075 0 11-4.925 11-11S18.075 0 12 0"
						  style="fill: gray;"></path></svg>
					</button>
					<div class="modal fade" id="exampleModal"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="false" data-backdrop="static" style="background-color: rgba(0, 0, 0, 0.5);">
						<div class="modal-dialog" >
							<div class="modal-content ">
								<div class="modal-header index">
									<h1 class="modal-title fs-5" id="exampleModalLabel">Invia un messaggio</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div class="pm-message-form">			
										<form @submit.prevent="sendMessage()">
											<div class="mb-3">
												<label for="exampleInputEmail1" class="form-label">Email </label>
												<input type="email" class="form-control" id="exampleInputEmail1" v-model="message.email" placeholder="example@gmail.com" aria-describedby="emailHelp">
												<div id="emailHelp" class="form-text">Non condivideremo la tua mail con nessun altro</div>
											</div>
											<div class="mb-3">
												<label  for="text" class="form-label">Messaggio</label>
												<textarea
												class="form-control"
												id="text" 
												placeholder="Inserisci il messaggio"
												v-model="message.text"
												></textarea>
											</div>
										
											<button type="submit" class="btn btn-secondary" data-bs-dismiss="modal" >Invia</button>
										</form>
									</div>	
								</div>
							</div>
						</div>
					</div>
				</div>
</template>



<style>
</style>