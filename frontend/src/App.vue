<template>
  <ion-app>
    <h1 v-if="selectedColor !== -1" :class="colorClass">Hallo {{ name }}</h1>
    <p>Some text.</p>
    <p>More text</p>
    <input type="text" v-model="name" placeholder="Geben Sie Ihren Namen ein" />
    <select v-model="selectedColor">
      <option :value="1">Rot</option>
      <option :value="2">Grün</option>
      <option :value="3">Blau</option>
    </select>
  </ion-app>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { IonApp } from '@ionic/vue';

const name = ref('');
const selectedColor = ref(-1);

const colorClass = computed(() => {
  switch (selectedColor.value) {
    case 1:
      return 'red';
    case 2:
      return 'green';
    case 3:
      return 'blue';
    default:
      return '';
  }
});
</script>

<style scoped>
.red {
  color: red;
}
.green {
  color: green;
}
.blue {
  color: blue;
}
</style>