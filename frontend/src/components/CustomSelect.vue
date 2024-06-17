<template>
  <div class="select-container">
    <IonLabel>Extras</IonLabel>
    <div class="custom-select">
      <div class="selected-option" @click="toggleDropdown">
        <span v-if="!selectedOptions.length">Select Options</span>
        <span v-else>{{ selectedOptions.join(', ') }}</span>
      </div>
      <div class="dropdown-options" v-if="dropdownOpen">
        <div
          class="dropdown-option"
          v-for="option in options"
          :key="option.value"
          @click="selectOption(option)"
        >
          <i :class="option.iconClass"></i>
          <span>{{ option.text }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import { IonLabel } from '@ionic/vue';

export default defineComponent({
  name: 'CustomSelect',
  components: {
    IonLabel, // Register IonLabel as a component
  },
  emits: ['updateExtras'],
  setup(_, { emit }) {
    const dropdownOpen = ref(false);
    const selectedOptions = ref<string[]>([]);
    const options = ref([
      { value: 'Balcony', text: 'Balcony', iconClass: 'bi bi-house' },
      { value: 'Air Conditioning', text: 'Air Conditioning', iconClass: 'bi bi-snow' },
      { value: 'Bathroom', text: 'Bathroom', iconClass: 'bi bi-droplet' },
      { value: 'Whirlpool', text: 'Whirlpool', iconClass: 'bi bi-star' },
    ]);

    const toggleDropdown = () => {
      dropdownOpen.value = !dropdownOpen.value;
    };

    const selectOption = (option: { value: string; text: string }) => {
      if (selectedOptions.value.includes(option.text)) {
        selectedOptions.value = selectedOptions.value.filter(opt => opt !== option.text);
      } else {
        selectedOptions.value.push(option.text);
      }
      emit('updateExtras', selectedOptions.value);
    };

    return { dropdownOpen, selectedOptions, options, toggleDropdown, selectOption };
  },
});
</script>

<style scoped>
.select-container {
  margin-bottom: 16px;
}
.custom-select {
  position: relative;
  cursor: pointer;
}
.selected-option {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
.dropdown-options {
  position: absolute;
  top: 100%;
  left: 0;
  right: 0;
  border: 1px solid #ccc;
  border-top: none;
  background: #fff;
  z-index: 10;
}
.dropdown-option {
  padding: 8px;
  cursor: pointer;
  display: flex;
  align-items: center;
}
.dropdown-option:hover {
  background-color: #f1f1f1;
}
.dropdown-option i {
  margin-right: 8px;
}
</style>