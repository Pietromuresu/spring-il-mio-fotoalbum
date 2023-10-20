<script setup>
import MasonryWall from '@yeger/vue-masonry-wall'
import { onMounted, ref } from "vue";
import store from "../stores/store"
import { RouterLink } from 'vue-router';
import Show from '../views/Show.vue';

let photos = ref([]);

  components: 
    MasonryWall;
  

onMounted(() => {
  store.getPhotos()
})

</script>

<template>
  <div class="container">
    <h1 class="py-3 text-center ">All photos</h1>
    <MasonryWall :items="store.photos.value" :ssr-columns="5" :column-width="200"  :gap="10" >
      
      <template  #default="{ item }" >
        <router-link :to="{ name: 'show', params: { id: item.id } }" >
          <div th:each="photo : ${photos}" 
          class="pm-post" 
          :photo="item" >
          
            <div>
              <img 
              class="pm-photo"
              :src="store.IMG_BASE_URL + item.photoUrl">
            </div>
            
            <a href="/" class="pm-post-link">
              <div class="pm-hover text-white">
                {{ item.title }}
              </div>
            </a>
          </div>	
        </router-link>
      </template>
    </MasonryWall>
  
  </div>
</template>

<style scoped>
a{
  text-decoration: none;
}

.pm-post{
  box-shadow: 0 0 5px black;
	position: relative;
	border-radius: 10px;
	overflow: hidden;
	margin: 7px;
  max-width: 250px;
  height: 100%;
}

.pm-post:hover>.pm-post-link{
	display: flex;
}


.pm-post-link{
	display: none;
	justify-content: end;
	flex-direction: column-reverse;
	padding: 5px;
	height: 100%;
	width: 100%;
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(255, 255, 255, 0.1);
}
</style>