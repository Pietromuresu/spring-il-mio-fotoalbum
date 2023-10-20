import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Show from '../views/Show.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/photo/:id',
      name: 'show',
      component: Show
    },

  ]
})

export default router
