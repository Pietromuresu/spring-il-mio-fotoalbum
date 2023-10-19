import { ref} from 'vue'
import axios from 'axios';
export default{
  API_URL : "http://localhost:8080/api/v1.0",
  IMG_BASE_URL : "http://localhost:8080/imgs/",


  photos : ref([]),
  categories : ref([]),
  searchedName: ref(""),


  getPhotos(name){
    axios.get(this.API_URL + "/photos/all", {
      params:{
        title: name
      }
    })
          .then(res => {
            const data = res.data;
            this.photos.value = data;
          })
          .catch(err => console.log(err));

  },
  getCategories(name){
    axios.get(this.API_URL + "ingredients")
          .then(res => {
            const data = res.data;
            this.ingredients.value = data;
          })
          .catch(err => console.log(err));


  },


}