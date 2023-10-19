<script setup>
import Header from "./partials/Header.vue";
import { ref } from "vue";

const hello = ref("Hello")
</script>

<template>
<Header />
  <h1>{{ hello }}</h1>
</template>

<style scoped>
</style>