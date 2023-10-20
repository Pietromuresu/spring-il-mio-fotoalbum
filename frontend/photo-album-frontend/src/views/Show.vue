
<script setup>
import store from "../stores/store";
import { RouterLink, RouterView } from "vue-router";
import { useRoute } from 'vue-router';
import axios from "axios";
import { onMounted, ref } from "vue";
import Header from "../components/partials/Header.vue";

  const name = "Show";
  const route = useRoute();
  const photo = ref(null);

  function getPhoto(){
    axios.get(store.API_URL + "/photos/" + route.params.id)
          .then(res => {
            const data = res.data;
            photo.value = data;
          })
          .catch(err => console.log(err));

  }

  onMounted(()=>{
    getPhoto()
  })
</script>

<template>
  <RouterView>
      <Header />
      <main  v-if="photo != null" >
        <h1 class="text-center p-4">Title: {{ photo.title }} </h1>
        <div   class=" container pt-5 d-flex justify-content-center">
          <div class="pm-img-details">
            <img class="pm-img" :src="store.IMG_BASE_URL + photo.photoUrl" >
          </div>
          <div class="p-5">
            
            
            <h5>Descrizione: </h5>
            <h6>{{ photo.description }}</h6>

            <h5>Categorie: </h5>
            <h6 v-for="cat in photo.categories" :key="cat.id" class="badge text-bg-secondary ms-2">{{ cat.name }}</h6>
          </div>
        </div>

      </main>
  </RouterView>  
</template>

<style scoped>
.pm-img-details{
  height: 400px;
}

.pm-img-details>.pm-img{
  box-shadow: 0 0 5px ;
  object-fit:cover;
  max-height: 500px;
}
</style>