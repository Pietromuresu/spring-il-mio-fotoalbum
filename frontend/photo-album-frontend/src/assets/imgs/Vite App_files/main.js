import "/src/assets/main.css"
import "/node_modules/bootstrap/dist/css/bootstrap.min.css"
import "/node_modules/.vite/deps/bootstrap_dist_js_bootstrap__min__js.js?v=2fb64ea3"
import MasonryWall from "/node_modules/.vite/deps/@yeger_vue-masonry-wall.js?v=98d023a8"
import { createApp } from "/node_modules/.vite/deps/vue.js?v=610b12dc"
import { createPinia } from "/node_modules/.vite/deps/pinia.js?v=c0a76b42"



import App from "/src/App.vue"
import router from "/src/router/index.js"
const app = createApp(App)
app.use(MasonryWall)

app.use(createPinia())
app.use(router)

app.mount('#app')
